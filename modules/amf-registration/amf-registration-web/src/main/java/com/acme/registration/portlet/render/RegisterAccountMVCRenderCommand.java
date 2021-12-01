package com.acme.registration.portlet.render;

import com.acme.registration.constants.RegistrationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
		"mvc.command.name=" + RegistrationPortletKeys.REGISTRATION_MVC_COMMAND_NAME
	},
	service = MVCRenderCommand.class
)
public class RegisterAccountMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/view.jsp";
	}

}