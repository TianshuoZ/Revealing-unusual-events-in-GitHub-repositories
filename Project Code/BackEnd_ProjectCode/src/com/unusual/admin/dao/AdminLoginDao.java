package com.unusual.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;
import com.unusual.utils.DataSourceUtils;

public class AdminLoginDao {

	public List<Events> getAllUnusualEvents() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from unusual_event";
		List<Events> unusualEventsList = runner.query(sql,new BeanListHandler<Events>(Events.class));
		return unusualEventsList;
	}

	public String getUserNumber() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select count(*) from user";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		String userNum = query.intValue()+"";
		return userNum;
	}

	public String getRepositoryNumber() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select count(*) from user_repository";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		String repositoryNum = query.intValue()+"";
		return repositoryNum;
	}

	public String getEventNumber() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select count(*) from event_name";
		Long query = (Long) runner.query(sql, new ScalarHandler());
		String eventsNum = query.intValue()+"";
		return eventsNum;
	}

	public List<Event_Name> getEventsList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from event_name limit 0,5";
		List<Event_Name> eventsList = runner.query(sql, new BeanListHandler<Event_Name>(Event_Name.class));
		return eventsList;
	}
	
}
