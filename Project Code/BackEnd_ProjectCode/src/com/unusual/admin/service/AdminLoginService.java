package com.unusual.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.admin.dao.AdminLoginDao;
import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;

public class AdminLoginService {

	AdminLoginDao dao = new AdminLoginDao();
	public List<Events> getAllUnusualEvents() throws SQLException {
		return dao.getAllUnusualEvents();
	}

	public String getUserNumber() throws SQLException {
		return dao.getUserNumber();
	}

	public String getRepositoryNumber() throws SQLException {
		return dao.getRepositoryNumber();
	}

	public String getEventNumber() throws SQLException {
		return dao.getEventNumber();
	}

	public List<Event_Name> getEventsList() throws SQLException {
		return dao.getEventsList();
	}

}
