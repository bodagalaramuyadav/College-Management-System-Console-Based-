package com.StudentManagement.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// Database credentials stored as constants
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	private static final String USER = "root";
	private static final String PASS = "040802";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {
		Connection con = null;
		try {
			// Load the driver once
			Class.forName(DRIVER);
			// Establish connection
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Database Connection Failed!");
			e.printStackTrace();
		}
		return con;
	}
}