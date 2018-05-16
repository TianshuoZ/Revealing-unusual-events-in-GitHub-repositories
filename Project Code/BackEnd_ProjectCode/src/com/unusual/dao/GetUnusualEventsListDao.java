package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;
import com.unusual.domain.Repository;
import com.unusual.utils.DataSourceUtils;

public class GetUnusualEventsListDao {

	public List<Events> getUnusualEventList(String userid) throws SQLException {
		//this function just for the first table 
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from unusual_event where user_idf=?";
		String eventNameId = null;
		List<Events> unusualEventList = runner.query(sql, new BeanListHandler<Events>(Events.class), userid);
		sql = "select * from event_name";
		List<Event_Name> eventNameList = runner.query(sql, new BeanListHandler<Event_Name>(Event_Name.class));
		
		//set event_artifact and event_name
		for(int i=0;i<unusualEventList.size();i++) {
			eventNameId = unusualEventList.get(i).getEvent_name_idf();
			sql = "select * from event_name where event_name_id=?";
			Event_Name temp = runner.query(sql, new BeanHandler<Event_Name>(Event_Name.class),eventNameId);
			unusualEventList.get(i).setEvent_artifact(temp.getEvent_artifact());
			unusualEventList.get(i).setEvent_name(temp.getEvent_name());
		}
		//set repository name
		for(int i=0;i<unusualEventList.size();i++) {
			String repository_id = unusualEventList.get(i).getEvent_name_idf();
			sql = "select repository_name from user_repository where repository_id=?";
			Repository temp = runner.query(sql, new BeanHandler<Repository>(Repository.class),repository_id);
			unusualEventList.get(i).setRepository_name(temp.getRepository_name());
		}
	
		return unusualEventList;
	}

	public List<Event_Name> getUnusualEventNameList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from event_name";
		return runner.query(sql, new BeanListHandler<Event_Name>(Event_Name.class));
	}

}
