package com.rakib.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hibernate_master";
		String userName = "root";
		String passWord = "mysql123";
		try {
			System.out.println("Database Connection " + url);
			Connection connect = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connection Successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
