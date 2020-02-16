package com.lti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private String url = "jdbc:mysql://localhost:3307/test";
	private String username = "root";
	private String password = "";
	private String driver = "com.mysql.jdbc.Driver";

	// Define Connection
	public Connection getConnection() {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	// Load Driver
	public void loadDriver(String driver) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Define Functions to put into Database

	public boolean checkLogin(String uname, String pname) {

		loadDriver(driver);
		Connection connection = getConnection();
		String query = "select * from test.user_details where name=? and password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, pname);

			// Points to row into a result we got
			ResultSet resultSet = preparedStatement.executeQuery();

			// Checks if data exist or not
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
