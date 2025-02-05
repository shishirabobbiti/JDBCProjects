package com.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class SelectUser {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name: ");
		String name=s.next();
		String url="jdbc:mysql://localhost:3306/jdbcsessions";
		String username="root";
		String password="Shishira13";
		String query="select * from student where sname='"+name+"'";
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded successfully...");
		
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement statement=connection.prepareStatement(query);
		ResultSet executeQuery = statement.executeQuery();
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
