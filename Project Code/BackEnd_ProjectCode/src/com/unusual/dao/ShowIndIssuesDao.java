package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.Issues;
import com.unusual.domain.Repository;
import com.unusual.domain.User;
import com.unusual.utils.DataSourceUtils;

public class ShowIndIssuesDao {

	public String getUserid(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select user_id from user where user_name=?";
		User userlist = runner.query(sql, new BeanHandler<User>(User.class),username );
		String uid = userlist.getUser_id();
//		System.out.println(uid);
		return uid;
	}

	public List<Issues> getIssuesList(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from issue where user_id=?";
		List<Issues> issuesList = runner.query(sql, new BeanListHandler<Issues>(Issues.class),userid);
		
		for(int i=0;i<issuesList.size();i++) {
			String repositoryId = issuesList.get(i).getRepository_idi();
			sql = "select repository_name from user_repository where repository_id=?";
			Repository repositoryName= runner.query(sql, new BeanHandler<Repository>(Repository.class),repositoryId);
//			System.out.println(repositoryName.getRepository_name());
			issuesList.get(i).setRepository_name(repositoryName.getRepository_name());
		}
		
		return issuesList;
	}

}
