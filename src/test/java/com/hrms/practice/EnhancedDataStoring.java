package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class EnhancedDataStoring {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:drivertype://hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	String query = "select * from ohrm_language;";

	@Test
	public void storeData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int colNums = rsMetaData.getColumnCount();
		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> mapData;
		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			for (int i = 1; i <= colNums; i++) {
				mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			listData.add(mapData);

		}
		System.out.println(listData);
	}

}
