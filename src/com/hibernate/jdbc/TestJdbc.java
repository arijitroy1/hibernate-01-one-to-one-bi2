package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String args[]) throws SQLException {
		String jdbc = "jdbc:mysql://127.0.0.1:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			Connection conn = DriverManager.getConnection(jdbc, user, pass);
			System.out.print("Connection Successfull");
		}catch(Exception e) {
			System.out.print("Error "+e.getMessage());
		}
	}
}
