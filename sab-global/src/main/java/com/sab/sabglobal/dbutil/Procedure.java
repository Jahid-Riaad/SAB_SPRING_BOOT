package com.sab.sabglobal.dbutil;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;

public class Procedure extends StoredProcedure {

	public Procedure(DataSource dataSource, String name) {
		super(dataSource, name);
		setFunction(false);
	}
	
	public Procedure(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
		setFunction(false);
	}

}
