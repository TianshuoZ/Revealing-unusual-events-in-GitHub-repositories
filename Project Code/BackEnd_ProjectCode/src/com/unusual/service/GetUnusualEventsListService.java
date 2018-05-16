package com.unusual.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.dao.GetUnusualEventsListDao;
import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;

public class GetUnusualEventsListService {

	public List<Events> getUnusualEventList(String userid) throws SQLException {
		GetUnusualEventsListDao dao = new GetUnusualEventsListDao();
		return dao.getUnusualEventList(userid);
	}

	public List<Event_Name> getEventNameList() throws SQLException {
		GetUnusualEventsListDao dao = new GetUnusualEventsListDao();
		return dao.getUnusualEventNameList();
	}

	

}
