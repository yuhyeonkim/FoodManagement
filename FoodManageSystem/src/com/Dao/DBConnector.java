package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	private static final String driverName = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String id = "pro1";
	private static final String pw = "pro1";
	
	public static Connection getConnection() throws Exception{
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, id, pw);
		//System.out.println("Connection 객체 연결 성공!");
		
		return conn;
	}
}




