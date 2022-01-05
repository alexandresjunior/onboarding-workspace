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
import com.acme.event.monitor.service.base.EventLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactory;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.acme.event.monitor.model.Event",
	service = AopService.class
)
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {

	public Event addEvent(
			long groupId, String eventType, String ipAddress,
			ServiceContext serviceContext)
		throws PortalException {

		Group group = groupLocalService.getGroup(groupId);
		User user = userLocalService.getUser(serviceContext.getUserId());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		long eventId = counterLocalService.increment(Event.class.getName());

		Event event = createEvent(eventId);

		event.setGroupId(groupId);
		event.setCompanyId(group.getCompanyId());
		event.setUserId(user.getUserId());
		event.setUserName(user.getScreenName());
		event.setCreateDate(serviceContext.getCreateDate(new Date()));
		event.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		event.setEventType(eventType);
		event.setDateTime(simpleDateFormat.format(date));
		event.setIpAddress(ipAddress);

		resourceLocalService.addResources(
			user.getCompanyId(), groupId, user.getUserId(),
			Event.class.getName(), event.getEventId(), false, true, true);

		return super.addEvent(event);
	}

	public List<Event> getEventsByType(String eventType) {
		DynamicQuery dynamicQuery = dynamicQueryFactoryUtil.forClass(
			Event.class, getClassLoader());

		Property eventTypeProperty = propertyFactoryUtil.forName("eventType");

		dynamicQuery.add(eventTypeProperty.eq(eventType));

		return dynamicQuery(dynamicQuery);
	}

	@Reference
	protected DynamicQueryFactory dynamicQueryFactoryUtil;

	@Reference
	protected GroupLocalService groupLocalService;

	@Reference
	protected PropertyFactory propertyFactoryUtil;

}