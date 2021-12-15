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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AMF_Event&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Event
 * @generated
 */
public class EventTable extends BaseTable<EventTable> {

	public static final EventTable INSTANCE = new EventTable();

	public final Column<EventTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EventTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> eventType = createColumn(
		"eventType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> dateTime = createColumn(
		"dateTime", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> ipAddress = createColumn(
		"ipAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EventTable() {
		super("AMF_Event", EventTable::new);
	}

}