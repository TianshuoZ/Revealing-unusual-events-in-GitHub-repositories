package com.unusual.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.unusual.domain.Commits;
import com.unusual.domain.Repository;
import com.unusual.utils.DataSourceUtils;

public class ShowIndCommitsDao {

	public List<Commits> getIndCommits(String uid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from commit where user_id=?";
		List<Commits> commitsList= runner.query(sql, new BeanListHandler<Commits>(Commits.class),uid);
		
		for(int i=0;i<commitsList.size();i++) {
			String repositoryId = commitsList.get(i).getRepository_idc();
			sql = "select repository_name from user_repository where repository_id=?";
			Repository repositoryName= runner.query(sql, new BeanHandler<Repository>(Repository.class),repositoryId);
//			System.out.println(repositoryName.getRepository_name());
			commitsList.get(i).setRepository_name(repositoryName.getRepository_name());
		}
		
		return commitsList;
	}

}
