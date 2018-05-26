package com.unusual.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.User;
import com.unusual.utils.DataSourceUtils;

public class AdminUsersDao {

	public List<User> getUsers() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		List<User> userList = runner.query(sql, new BeanListHandler<User>(User.class));
		return userList;
	}

}
