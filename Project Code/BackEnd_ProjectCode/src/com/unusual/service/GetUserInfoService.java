package com.unusual.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.dao.GetUserInfoDao;
import com.unusual.domain.Commits;
import com.unusual.domain.Events;
import com.unusual.domain.Repository;
import com.unusual.domain.User;

public class GetUserInfoService {

	public List<User> getUserInfo(String username) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getUserInfo(username);
	}

	public List<Events> getEventsList(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getEventsList(userid);
	}

	public Object getRepositoryNum(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getRepositoryNum(userid);
	}



	public List<Events> getLatestEventList(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getLatestEventList(userid);
	}

	public int getUnusualEventsNum(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getUnusualEventsNum(userid);
	}

	public List<Repository> getRepositoryList(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.RepositoryList(userid);
		
	}

	public Object getCommmitNum(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getCommitNum(userid);
	}

	public Object getPullRequestNum(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getPullRequestNum(userid);
	}

	public Object getIssueNum(String userid) throws SQLException {
		GetUserInfoDao dao = new GetUserInfoDao();
		return dao.getIssueNum(userid);
	}


}
