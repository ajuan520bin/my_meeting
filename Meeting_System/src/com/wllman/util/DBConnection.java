package com.wllman.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/meeting?characterEncoding=utf-8";
			String username="root";
			String password="root";
			Connection con=DriverManager.getConnection(url,username,password);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DBConnection.getConnection());

	}

}
