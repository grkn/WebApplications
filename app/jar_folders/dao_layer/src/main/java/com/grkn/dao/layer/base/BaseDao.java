package com.grkn.dao.layer.base;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao{
	
	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
	
	
	protected JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
}
