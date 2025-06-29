package com.edit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EditRecord {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name: ");
		String name=s.next();
		System.out.println("Enter address: ");
		String address=s.next();
		String url="jdbc:mysql://localhost:3306/jdbcsessions";
		String username="root";
		String password="Shishira13";
		String editQuery="UPDATE student SET saddress =? WHERE sname=?";
		String selectQuery="select * from student";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement statement=connection.prepareStatement(editQuery);
		statement.setString(1, address);
		statement.setString(2, name);
		int rowsEffected=statement.executeUpdate();
		System.out.println("No of rows effected::"+rowsEffected);
		PreparedStatement selectStatement=connection.prepareStatement(selectQuery);
		ResultSet executeQuery = selectStatement.executeQuery();
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
