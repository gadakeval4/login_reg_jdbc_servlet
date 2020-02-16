package com.lti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

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

	public String insert(User user) {

		// Driver Loaded
		loadDriver(driver);

		// We got Connection
		Connection con = getConnection();
		String message = "Data Entered Successfully";
		String insert_query = "insert into test.user_details values (?,?,?,?)";
		try {

			PreparedStatement preparedStatement = con.prepareStatement(insert_query);

			// Setting Placeholder
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAge());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Data not Entered";
		}
		return message;

	}

}
