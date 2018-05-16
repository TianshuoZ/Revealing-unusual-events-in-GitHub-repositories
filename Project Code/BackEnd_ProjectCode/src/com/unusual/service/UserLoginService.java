package com.unusual.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.dao.UserLoginDao;
import com.unusual.domain.User;

public class UserLoginService {

	public List<User> getLoginData(String username) throws SQLException {
		UserLoginDao dao = new UserLoginDao();
		return dao.getLoginData(username);
	}

}
