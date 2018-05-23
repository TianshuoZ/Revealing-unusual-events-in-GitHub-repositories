package com.unusual.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.dao.ShowIndPullRequestDao;
import com.unusual.domain.PullRequests;

public class ShowIndPullRequestService {

	public String getUserid(String username) throws SQLException {
		ShowIndPullRequestDao dao = new ShowIndPullRequestDao();
		return dao.getUserid(username);
	}

	public List<PullRequests> getPullRequestList(String user_id) throws SQLException {
		ShowIndPullRequestDao dao = new ShowIndPullRequestDao();
		return dao.getPullRequestList(user_id);
	}

}
