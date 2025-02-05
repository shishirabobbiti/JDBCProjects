package com.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id: ");
		int id=s.nextInt();
		System.out.println("Enter name");
		String name=s.next();
		System.out.println("Enter salary: ");
		int salary=s.nextInt();
		System.out.println("Enter address: ");
		String address=s.next();
		System.out.println("Enter dob");
		String dob=s.next();
		String url="jdbc:mysql://localhost:3306/jdbcsessions";
		String username="root";
		String password="Shishira13";
		String selectQuery="select * from employee";
		String addQuery="INSERT INTO employee (id, ename, esalary,eaddress,edob)"
				+ "VALUES (?, ?, ?, ?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,username,password);
		PreparedStatement statement=connection.prepareStatement(addQuery);
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setInt(3, salary);
		statement.setString(4, address);
		statement.setString(5, dob);
		int rowsEffected=statement.executeUpdate();
		System.out.println("No of rows effected::"+rowsEffected);
		PreparedStatement selectstatement=connection.prepareStatement(selectQuery);
		ResultSet executeQuery=selectstatement.executeQuery();
		while(executeQuery.next()) {
			int eid=executeQuery.getInt(1);
			String ename=executeQuery.getString(2);
			int esalary=executeQuery.getInt(3);
			String eaddress=executeQuery.getString(4);
			String edob=executeQuery.getString(5);
			System.out.print(eid+"\t");
			System.out.print(ename+"\t");
			System.out.print(esalary+"\t");
			System.out.print(eaddress+"\t");
			System.out.print(edob+"\t");
			System.out.println();
		}
	}
	
}
