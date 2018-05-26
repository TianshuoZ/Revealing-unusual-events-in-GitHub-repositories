package com.unusual.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.admin.dao.AdminUsersDao;
import com.unusual.domain.User;

public class AdminUsersService {

	public List<User> getUsers() throws SQLException {
		AdminUsersDao dao = new AdminUsersDao();
		return dao.getUsers();
	}
	
}
