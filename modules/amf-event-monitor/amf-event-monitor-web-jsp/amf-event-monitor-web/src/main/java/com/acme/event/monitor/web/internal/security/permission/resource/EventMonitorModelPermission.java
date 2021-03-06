package com.acme.event.monitor.web.internal.security.permission.resource;

import com.acme.event.monitor.model.Event;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(immediate = true)
public class EventMonitorModelPermission {

	public static boolean contains(
			PermissionChecker permissionChecker, Event event, String actionId)
		throws PortalException {

		return _eventModelResourcePermission.contains(
			permissionChecker, event, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long eventId, String actionId)
		throws PortalException {

		return _eventModelResourcePermission.contains(
			permissionChecker, eventId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.acme.event.monitor.model.Event)",
		unbind = "-"
	)
	protected void setEntryModelPermission(
		ModelResourcePermission<Event> modelResourcePermission) {

		_eventModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<Event> _eventModelResourcePermission;

}