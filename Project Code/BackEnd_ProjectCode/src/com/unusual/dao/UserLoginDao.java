package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.User;
import com.unusual.utils.DataSourceUtils;

public class UserLoginDao {

	public List<User> getLoginData(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where user_name=?";
		List<User> user = runner.query(sql, new BeanListHandler<User>(User.class), username);
		return user;
	}

}
