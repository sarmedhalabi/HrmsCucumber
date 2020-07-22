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

import org.junit.Ignore;
import org.junit.Test;

public class StoringDataAsel {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:drivertype://hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Ignore
	@Test
	public void getAndStoreData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location;");
		List<Map<String, String>> listData = new ArrayList<>();
		while (rs.next()) {
			Map<String, String> map = new LinkedHashMap<>();
			map.put("id", rs.getObject("id").toString());
			map.put("name", rs.getObject("name").toString());
			map.put("country_code", rs.getObject("country_code").toString());
			System.out.println(map);// it will print out each map
			listData.add(map);

		}

		System.out.println(listData);// it will print out the whole list of all map
		System.out.println("+++++++++++++++++++");
		for (Map<String, String> data : listData) {
			String id = data.get("id");
			String name = data.get("name");
			String country_code = data.get("country_code");
			System.out.println(id + " " + name + " " + country_code);
		}

	}

	@Test
	public void getAndStoreDataEnhanced() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location;");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int colsCount = rsMetaData.getColumnCount();

		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> rowmap;
		while (rs.next()) {
			rowmap = new LinkedHashMap<>();
			for(int i=1; i<=colsCount;i++) {
				rowmap.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
				
			}
			listData.add(rowmap);
			

		}
		System.out.println(listData);

	}
}
