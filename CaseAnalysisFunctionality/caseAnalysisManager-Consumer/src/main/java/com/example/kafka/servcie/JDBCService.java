package com.example.kafka.servcie;

import java.sql.Types;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.kafka.consumer.constants.ConsumerConstants;

public class JDBCService {


	public static void saveRecord(String event) {

		JdbcTemplate template = new JdbcTemplate(getDataSource());

		// define query arguments
		Object[] params = new Object[] { event};

		// define SQL types of the arguments
		int[] types = new int[] { Types.CLOB};

		// execute insert query to insert the data
		// return number of row / rows processed by the executed query
		int row = template.update(ConsumerConstants.ADD_AUDITS, params, types);
		
		System.out.println(row + " row inserted.");

	}


	public static DriverManagerDataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");

		dataSource.setUsername("sys as sysdba");

		dataSource.setPassword("Welcome01");

		return dataSource;
	}

}
