package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.Commits;
import com.unusual.domain.Issues;
import com.unusual.domain.IssuesHistory;
import com.unusual.domain.PullRequests;
import com.unusual.utils.DataSourceUtils;

public class CalculateUnusualEventsDao {

	public List<Commits> getCommitsList(String repository_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from commit where repository_idc=?";
		List<Commits> commitsList = runner.query(sql, new BeanListHandler<Commits>(Commits.class),repository_id);
		
		return commitsList;
	}

	public List<Issues> getIssuesList(String repository_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from issue where repository_idi=?";
		List<Issues> issueslist = runner.query(sql, new BeanListHandler<Issues>(Issues.class),repository_id);
		String issueid = null;
		for(int i=0;i<issueslist.size();i++) {
			issueid = issueslist.get(i).getIssue_id();
			sql = "select * from issue_history where issue_id_f=?";
			IssuesHistory issuesHistory = runner.query(sql, new BeanHandler<IssuesHistory>(IssuesHistory.class),issueid);
			issueslist.get(i).setDate(issuesHistory.getDate());
			issueslist.get(i).setIssue_history_id(issuesHistory.getIssue_history_id());
			issueslist.get(i).setIssue_status(issuesHistory.getIssue_status());
		}
		return issueslist;
	}

	public List<PullRequests> getPullRequestsList(String repository_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from pull_request where repository_idp=?";
		List<PullRequests> pullrequestslist = runner.query(sql, new BeanListHandler<PullRequests>(PullRequests.class),repository_id);
		return pullrequestslist;
	}
	

	public void deleteEventByRepositoryId(String repository_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delet from unusual_event where repository_idf=?";
		runner.update(sql);
	}

}
