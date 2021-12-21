/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.acme.event.monitor.service.impl;

import com.acme.event.monitor.model.Event;
import com.acme.event.monitor.service.base.EventServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=amf",
		"json.web.service.context.path=Event"
	},
	service = AopService.class
)
public class EventServiceImpl extends EventServiceBaseImpl {

	public Event addEvent(
			long groupId, String eventType, String ipAddress,
			ServiceContext serviceContext)
			throws PortalException {

		return eventLocalService.addEvent(groupId, eventType, ipAddress, serviceContext);
	}

}