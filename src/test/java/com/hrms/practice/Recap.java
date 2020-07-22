package com.hrms.practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Recap {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:drivertype://hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void gettingConnected() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_skill");
		ResultSetMetaData rsMetadata=rs.getMetaData();
		int cols= rsMetadata.getColumnCount();
		System.out.println(cols);
		for( int i=1;i<=cols;i++) {
			String colName= rsMetadata.getColumnName(i);
			System.out.println(colName);
		}
		String id;
		String name;
		while (rs.next()) {
			id = rs.getObject("id").toString();
			name = rs.getObject("name").toString();
			System.out.println(id + " = " + name);

		}
		rs.close();
		st.close();
		conn.close();
	}

}
