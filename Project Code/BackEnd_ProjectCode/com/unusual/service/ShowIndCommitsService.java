package com.unusual.service;

import java.sql.SQLException;
import java.util.List;

import com.unusual.dao.GetUserInfoDao;
import com.unusual.dao.ShowIndCommitsDao;
import com.unusual.domain.Commits;

public class ShowIndCommitsService {
	public List<Commits> getIndCommits(String uid) throws SQLException {
		ShowIndCommitsDao dao = new ShowIndCommitsDao();
		return dao.getIndCommits(uid);
	}
}
