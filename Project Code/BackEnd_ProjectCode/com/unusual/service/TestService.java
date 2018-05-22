package com.unusual.service;

import java.sql.SQLException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import com.unusual.dao.TestDao;
import com.unusual.domain.User;

public class TestService {

	public List<User> getUsername(String username) throws SQLException {
		TestDao dao = new TestDao();
		return dao.getUsername(username);
	}

}
