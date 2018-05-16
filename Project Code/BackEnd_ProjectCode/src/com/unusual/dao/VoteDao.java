package com.unusual.dao;

import org.apache.commons.dbutils.QueryRunner;

import com.unusual.utils.DataSourceUtils;

public class VoteDao {

	public void addVote() {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		//修改表中的vote 数据, 让它加1
		String sql = "";
		//返回
		
		
	}

}
