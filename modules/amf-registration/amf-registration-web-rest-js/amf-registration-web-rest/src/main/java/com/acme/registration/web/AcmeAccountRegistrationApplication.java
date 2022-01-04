package com.acme.registration.web;

import com.acme.registration.model.Account;
import com.acme.registration.service.AccountLocalService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
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

	@GET
	@Path("/account-exists")
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkAccountExists(String body) throws PortalException {
		Account account = _jSONFactory.looseDeserialize(body, Account.class);

		account = _accountLocalService.getAccount(account.getAccountId());

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

	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(String body) {
		Account account = _jSONFactory.looseDeserialize(body, Account.class);

		account = _accountLocalService.addAccount(account);

		return Response.ok(
			_jSONFactory.looseSerialize(account)
		).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccount(
			@PathParam("id") long accountId){
		try{
			Account account = _accountLocalService.getAccount(accountId);

			if(account != null){
				String json = _OBJECT_MAPPER.writeValueAsString(
						JSONFactoryUtil.looseSerialize(account));

				return Response.ok(
						json, MediaType.APPLICATION_JSON
				).build();
			}
			else{
				return Response.status(
						Response.Status.NOT_FOUND
				).build();
			}
		} catch (PortalException | JsonProcessingException e) {
			e.printStackTrace();
		}

		return Response.status(
				Response.Status.INTERNAL_SERVER_ERROR
		).build();
	}

	private static final ObjectMapper _OBJECT_MAPPER = new ObjectMapper() {
		{
			configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
			disable(SerializationFeature.INDENT_OUTPUT);

		}
	};

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private JSONFactory _jSONFactory;

	@Context
	private HttpServletRequest _request;

}