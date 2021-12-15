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

package amf.event.monitor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link amf.event.monitor.service.http.EventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EventSoap implements Serializable {

	public static EventSoap toSoapModel(Event model) {
		EventSoap soapModel = new EventSoap();

		soapModel.setEventId(model.getEventId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventType(model.getEventType());
		soapModel.setDateTime(model.getDateTime());
		soapModel.setIpAddress(model.getIpAddress());

		return soapModel;
	}

	public static EventSoap[] toSoapModels(Event[] models) {
		EventSoap[] soapModels = new EventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[][] toSoapModels(Event[][] models) {
		EventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[] toSoapModels(List<Event> models) {
		List<EventSoap> soapModels = new ArrayList<EventSoap>(models.size());

		for (Event model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSoap[soapModels.size()]);
	}

	public EventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getDateTime() {
		return _dateTime;
	}

	public void setDateTime(String dateTime) {
		_dateTime = dateTime;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	private long _eventId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _eventType;
	private String _dateTime;
	private String _ipAddress;

}