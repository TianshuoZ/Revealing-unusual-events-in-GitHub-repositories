package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.unusual.domain.Commits;
import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;
import com.unusual.domain.Repository;
import com.unusual.domain.User;
import com.unusual.utils.DataSourceUtils;

public class GetUserInfoDao {

	public List<User> getUserInfo(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where user_name=?";
		List<User> userList = runner.query(sql,new BeanListHandler<User>(User.class),username);
		return userList;
	}

	public List<Events> getEventsList(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from unusual_event where user_idf=?";
		List<Events> eventsList = runner.query(sql,new BeanListHandler<Events>(Events.class),userid);
//		System.out.println("eventlist="+eventsList);
		return eventsList;
	}

	public Object getRepositoryNum(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user_repository where user_id=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),userid);
		return query.intValue();
	}

	public List<Commits> getIndCommits(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from commit where repository_idc=?";
		List<Commits> commitsList = runner.query(sql, new BeanListHandler<Commits>(Commits.class),uid);
		return commitsList;
	}

	public List<Events> getLatestEventList(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from unusual_event where user_idf=? order by happened_date desc limit 0,1;";
		List<Events> latestEventList = runner.query(sql,new BeanListHandler<Events>(Events.class),userid );
		//封装好所需要的数据: event_name_idf--->event_artifact  event_name_idf--->event_name
		Events event = latestEventList.get(0);
		String event_name_id = event.getEvent_name_idf();
		sql = "select * from event_name where event_name_id=?";
		Event_Name eName = runner.query(sql, new BeanHandler<Event_Name>(Event_Name.class),event_name_id);
		// 设置值给 event_name 和 event_artifact
//		System.out.println("ename.getevent_name:"+eName.getEvent_name());
		latestEventList.get(0).setEvent_name(eName.getEvent_name());
		latestEventList.get(0).setEvent_artifact(eName.getEvent_artifact());
		return latestEventList;
	}

	public int getUnusualEventsNum(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from unusual_event where user_idf=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(),userid);
		return query.intValue();
	}

	public List<Repository> RepositoryList(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user_repository where user_id=?";
		List<Repository> repositoryList = runner.query(sql, new BeanListHandler<Repository>(Repository.class),userid);
		return repositoryList;
	}

	public Repository getNumberList(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select sum(commit_number),sum(pull_request_number),sum(issue_number)"
				+ " from user_repository where user_id=?";
		Repository numberList = runner.query(sql,new BeanHandler<Repository>(Repository.class) ,userid);
		return numberList;
	}

	public Object getCommitNum(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select sum(commit_number)"
				+ " from user_repository where user_id=?";
		Object commitNum = runner.query(sql, new ScalarHandler(),userid);
		return commitNum;
	}

	public Object getPullRequestNum(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select sum(pull_request_number)"
				+ " from user_repository where user_id=?";
		Object pullRequestNum = runner.query(sql, new ScalarHandler(),userid);
		return pullRequestNum;
	}

	public Object getIssueNum(String userid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select sum(issue_number)"
				+ " from user_repository where user_id=?";
		Object issueNum = runner.query(sql, new ScalarHandler(),userid);
		return issueNum;
	}

}
