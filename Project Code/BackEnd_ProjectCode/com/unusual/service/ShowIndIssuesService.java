package com.unusual.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.dao.ShowIndIssuesDao;
import com.unusual.domain.Issues;

public class ShowIndIssuesService {

	public String getUserid(String username) throws SQLException {
		ShowIndIssuesDao dao = new ShowIndIssuesDao();
		return dao.getUserid(username);
	}

	public List<Issues> getIssuesList(String userid) throws SQLException {
		ShowIndIssuesDao dao = new ShowIndIssuesDao();
		return dao.getIssuesList(userid);
	}

}
