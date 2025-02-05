package com.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Class.forName
		//Connection
		//Statement
		//ResultSet
		
		String url="jdbc:mysql://localhost:3306/jdbcsessions";
		String username="root";
		String password="Shishira13";
		String query="SELECT * FROM student";
		
		//java environment database setup
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded successfully...");
		
		//database connection
		Connection connection = DriverManager.getConnection(url,username,password);
		System.out.println("Connection to database is successfull...");
		
		//query prepare
		PreparedStatement statement = connection.prepareStatement(query);
		
		//query execute
		ResultSet executeQuery = statement.executeQuery();
		
		//result usage
		while(executeQuery.next()) {
			int sid=executeQuery.getInt(1);
			String sname=executeQuery.getString(2);
			int sage=executeQuery.getInt(3);
			String saddress=executeQuery.getString(4);
			String sclass=executeQuery.getString(5);
			System.out.print(sid+"\t");
			System.out.print(sname+"\t");
			System.out.print(sage+"\t");
			System.out.print(saddress+"\t");
			System.out.print(sclass+"\t");
			System.out.println();
		}
	}

}
