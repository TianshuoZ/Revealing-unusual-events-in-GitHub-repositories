package com.unusual.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;
import com.unusual.utils.DataSourceUtils;

public class AdminEventsListDao {

	public List<Event_Name> getEventsList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from event_name";
		List<Event_Name> eventsList = runner.query(sql, new BeanListHandler<Event_Name>(Event_Name.class));
		return eventsList;
	}

}
