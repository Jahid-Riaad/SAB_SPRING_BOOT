package com.sab.sabglobal.dbutil;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import javax.sql.DataSource;

public class Function extends StoredProcedure {
	public Function(DataSource dataSource, String name) {
		super(dataSource, name);
		setFunction(true);
	}

	public Function(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
		setFunction(true);
	}

}
