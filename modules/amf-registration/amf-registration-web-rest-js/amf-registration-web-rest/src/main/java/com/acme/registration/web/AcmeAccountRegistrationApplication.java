package com.acme.registration.web;

import com.acme.registration.model.Account;
import com.acme.registration.service.AccountLocalService;

import com.liferay.portal.kernel.json.JSONFactory;

import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/account-registration",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=AcmeAccountRegistration.Rest"
	},
	service = Application.class
)
public class AcmeAccountRegistrationApplication extends Application {

	@Path("/add-account")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAccount(String body) {
		Account account = _jSONFactory.looseDeserialize(body, Account.class);

		account = _accountLocalService.addAccount(account);

		return Response.ok(
			_jSONFactory.looseSerialize(account)
		).build();
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@Reference
	private AccountLocalService _accountLocalService;

	@Reference
	private JSONFactory _jSONFactory;

	@Context
	private HttpServletRequest _request;

}