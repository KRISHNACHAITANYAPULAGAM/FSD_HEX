package com.ecomm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String url="jdbc:mysql://localhost:3306/lms_db";
	private static final String user="root";
	private static final String pass="1670";
	private static Connection conn;
	public DBUtil() {
		
	}
	public static Connection connect() {
		try {
		conn=DriverManager.getConnection(url,user,pass);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static void close() {
		try {
			if(!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void main(String [] args) {
		if(DBUtil.connect() != null) {
			System.out.println("connect success");
			DBUtil.close();
			System.out.println("closed connection");
		}
		
		
	}
	
	
	
}
