package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.unusual.domain.User;
import com.unusual.utils.DataSourceUtils;

public class TestDao {

	public List<User> getUsername(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where user_name=?";
		List<User> accountList = runner.query(sql, new BeanListHandler<User>(User.class),username);
		return accountList;
	}

}
