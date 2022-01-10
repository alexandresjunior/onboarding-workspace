package com.acme.registration.portlet;

import com.acme.registration.constants.RegistrationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Onboarding",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Registration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/home.jsp",
		"javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RegistrationPortlet extends MVCPortlet {
}