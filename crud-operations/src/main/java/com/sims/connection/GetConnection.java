package com.sims.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public static Connection connection;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/simscollege",
					"root", "keerat123");
			System.out.println("Connection Successful");
			return connection;
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public static void main(String[] args) {
		getConnection();
	}
}
