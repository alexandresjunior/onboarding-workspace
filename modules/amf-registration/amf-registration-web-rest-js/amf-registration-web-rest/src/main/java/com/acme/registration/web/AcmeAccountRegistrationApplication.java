package com.acme.registration.web;

import com.acme.registration.dto.AccountDTO;
import com.acme.registration.model.Account;
import com.acme.registration.service.AccountLocalService;
import com.acme.registration.service.AccountLocalServiceUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;

import java.security.Principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/accounts",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=AcmeAccountRegistration.Rest"
	},
	service = Application.class
)
public class AcmeAccountRegistrationApplication extends Application {

	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(String body) {
		AccountDTO accountDTO = _jSONFactory.looseDeserialize(
			body, AccountDTO.class);

		long accountId = _counterLocalService.increment(
			Account.class.getName());

		Account account = _accountLocalService.createAccount(accountId);

		account = _accountLocalService.addAccount(
			accountDTO.toAccount(account));

		return Response.ok(
			_jSONFactory.looseSerialize(account)
		).build();
	}

	@GET
	@Path("/account-exists")
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkAccountExists(String body) throws PortalException {
		AccountDTO accountDTO = _jSONFactory.looseDeserialize(
			body, AccountDTO.class);

		Account account = _accountLocalService.getAccount(
			accountDTO.getAccountId());

		boolean accountExists = Boolean.TRUE;

		if (account == null) {
			accountExists = Boolean.FALSE;
		}

		JSONObject response = _jSONFactory.createJSONObject();

		response.put("accountExists", accountExists);

		return Response.ok(
			response
		).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteAccount(@PathParam("id") long accountId) {
		try {
			_accountLocalService.deleteAccount(accountId);
		}
		catch (PortalException e) {
			_log.error(e, e);

			return Response.status(
				Response.Status.NOT_FOUND
			).build();
		}

		return Response.status(
			Response.Status.ACCEPTED
		).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccount(@PathParam("id") long accountId) {
		try {
			Account account = _accountLocalService.getAccount(accountId);

			if (account != null) {
				String json = _OBJECT_MAPPER.writeValueAsString(
					JSONFactoryUtil.looseSerialize(account));

				return Response.ok(
					json, MediaType.APPLICATION_JSON
				).build();
			}

			return Response.status(
				Response.Status.NOT_FOUND
			).build();
		}
		catch (JsonProcessingException | PortalException exception) {
			_log.error(exception, exception);
		}

		return Response.status(
			Response.Status.INTERNAL_SERVER_ERROR
		).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAccounts() {
		List<AccountDTO> accountsDTO = new ArrayList<>();

		List<Account> accounts = AccountLocalServiceUtil.getAccounts(-1, -1);

		for (Account account : accounts) {
			accountsDTO.add(AccountDTO.fromAccount(account));
		}

		try {
			String json = _OBJECT_MAPPER.writeValueAsString(accountsDTO);

			return Response.ok(
				json, MediaType.APPLICATION_JSON
			).build();
		}
		catch (JsonProcessingException jPE) {
			_log.error(jPE, jPE);
		}

		return Response.status(
			Response.Status.NO_CONTENT
		).build();
	}

	@GET
	@Path("/sample")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSampleResponse() throws PortalException {
		JSONObject response = _jSONFactory.createJSONObject();

		Principal principal = _request.getUserPrincipal();

		long userId = GetterUtil.getLong(principal.getName());

		User user = _userLocalService.getUser(userId);

		response.put("email", user.getEmailAddress());

		return Response.ok(
		).entity(
			response.toString()
		).build();
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Path("/{id}")
	@PUT
	public Response updateAccount(
		@PathParam("id") long accountId, String body) {

		AccountDTO accountDTO = _jSONFactory.looseDeserialize(
			body, AccountDTO.class);

		try {
			Account account = _accountLocalService.getAccount(accountId);

			_accountLocalService.updateAccount(accountDTO.toAccount(account));

			return Response.status(
				Response.Status.ACCEPTED
			).build();
		}
		catch (PortalException e) {
			_log.error(e, e);

			return Response.status(
				Response.Status.NOT_FOUND
			).build();
		}
	}

	private static final ObjectMapper _OBJECT_MAPPER = new ObjectMapper() {
		{
			configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
			disable(SerializationFeature.INDENT_OUTPUT);
		}
	};

	private static final Log _log = LogFactoryUtil.getLog(
		AcmeAccountRegistrationApplication.class);

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private JSONFactory _jSONFactory;

	@Context
	private HttpServletRequest _request;

	@Reference
	private UserLocalService _userLocalService;

}