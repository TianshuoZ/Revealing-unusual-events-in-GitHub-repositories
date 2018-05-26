package com.unusual.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.admin.dao.AdminEventsListDao;
import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;

public class AdminEventsListService {

	public List<Event_Name> getEventsList() throws SQLException {
		AdminEventsListDao dao = new AdminEventsListDao();
		return dao.getEventsList();
	}
	
}
