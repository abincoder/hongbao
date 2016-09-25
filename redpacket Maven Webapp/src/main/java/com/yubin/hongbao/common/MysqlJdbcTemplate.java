package com.yubin.hongbao.common;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlJdbcTemplate {
	
	protected static JdbcTemplate jdbcTemplate ;
	

	public  void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
}
