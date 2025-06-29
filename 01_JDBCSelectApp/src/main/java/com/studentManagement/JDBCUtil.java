package com.studentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	static String url = "jdbc:mysql://localhost:3306/jdbcsessions";
	static String username = "root";
	static String password = "Shishira13";
	static Connection connection;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			System.out.println("Connection is null");
			try {
				connection = DriverManager.getConnection(url, username, password);
				System.out.println(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else {
            System.out.println("Returning existing connection: " + connection);
        }
		System.out.println(connection);
		return connection;
		}
	

	public static void closeConnection(Connection connection) throws SQLException {
		 if (connection != null) {
	            try {
	                connection.close();
	                System.out.println("🔒 Connection closed successfully.");
	                connection = null; // Reset connection after closing
	            } catch (SQLException e) {
	                System.out.println("❌ Error while closing the connection!");
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("⚠️ No active connection to close.");
	        }
	}

}
