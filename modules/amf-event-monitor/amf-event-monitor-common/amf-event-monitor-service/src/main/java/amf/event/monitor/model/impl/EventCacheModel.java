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

package amf.event.monitor.model.impl;

import amf.event.monitor.model.Event;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EventCacheModel)) {
			return false;
		}

		EventCacheModel eventCacheModel = (EventCacheModel)object;

		if (eventId == eventCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{eventId=");
		sb.append(eventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", dateTime=");
		sb.append(dateTime);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		eventImpl.setEventId(eventId);
		eventImpl.setGroupId(groupId);
		eventImpl.setCompanyId(companyId);
		eventImpl.setUserId(userId);

		if (userName == null) {
			eventImpl.setUserName("");
		}
		else {
			eventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventImpl.setCreateDate(null);
		}
		else {
			eventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventImpl.setModifiedDate(null);
		}
		else {
			eventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventType == null) {
			eventImpl.setEventType("");
		}
		else {
			eventImpl.setEventType(eventType);
		}

		if (dateTime == null) {
			eventImpl.setDateTime("");
		}
		else {
			eventImpl.setDateTime(dateTime);
		}

		if (ipAddress == null) {
			eventImpl.setIpAddress("");
		}
		else {
			eventImpl.setIpAddress(ipAddress);
		}

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		dateTime = objectInput.readUTF();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(eventId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (dateTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dateTime);
		}

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public long eventId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String eventType;
	public String dateTime;
	public String ipAddress;

}