package com.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/jdbcsessions";
		String username="root";
		String password="Shishira13";
		String query="select * from employee";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement statement=connection.prepareStatement(query);
		ResultSet executeQuery=statement.executeQuery();
		while(executeQuery.next()) {
			int id=executeQuery.getInt(1);
			String ename=executeQuery.getString(2);
			int esalary=executeQuery.getInt(3);
			String eaddress=executeQuery.getString(4);
			String edob=executeQuery.getString(5);
			System.out.print(id+"\t");
			System.out.print(ename+"\t");
			System.out.print(esalary+"\t");
			System.out.print(eaddress+"\t");
			System.out.print(edob+"\t");
			System.out.println();
		}
		

	}

}
