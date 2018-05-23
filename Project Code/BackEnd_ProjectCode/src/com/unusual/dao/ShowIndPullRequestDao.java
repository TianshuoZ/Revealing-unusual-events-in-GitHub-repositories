package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.PullRequests;
import com.unusual.domain.Repository;
import com.unusual.domain.User;
import com.unusual.utils.DataSourceUtils;

public class ShowIndPullRequestDao {

	public String getUserid(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select user_id from user where user_name=?";
		User userlist = runner.query(sql, new BeanHandler<User>(User.class),username );
		String uid = userlist.getUser_id();
//		System.out.println(uid);
		return uid;
	}

	public List<PullRequests> getPullRequestList(String user_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from pull_request where user_id=?";
		List<PullRequests> pullRequestsList = runner.query(sql, new BeanListHandler<PullRequests>(PullRequests.class),user_id );
		
		for(int i=0;i<pullRequestsList.size();i++) {
			String repositoryId = pullRequestsList.get(i).getRepository_idp();
			sql = "select repository_name from user_repository where repository_id=?";
			Repository repositoryName= runner.query(sql, new BeanHandler<Repository>(Repository.class),repositoryId);
//			System.out.println(repositoryName.getRepository_name());
			pullRequestsList.get(i).setRepository_name(repositoryName.getRepository_name());
		}
		return pullRequestsList;
	}

}
