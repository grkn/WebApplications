package com.grkn.tests;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class TransactionTest{

	@Autowired
	private
	DataSource dataSource;
	
	/**
	 * First update statement is rollbacked is transaction manager is defined
	 * else fist update statement is committed.
	 */
	@Test
	@Transactional(value = "transactionalManager")
	public void test(){
		JdbcTemplate tmp = new JdbcTemplate(dataSource);
		tmp.update("insert into grkn.users values(7,'aaaaa','bbbbbb','cccccc',1)");
		//Intentionally error occured
		tmp.update("insert into grkn.users values('aaaaa','bbbbbb','cccccc',1)");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}	
}
