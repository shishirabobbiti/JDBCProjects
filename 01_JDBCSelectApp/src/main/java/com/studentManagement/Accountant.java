package com.studentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Accountant {
	static String addAccountant = "insert into accountant(name,password,email,contactNo)values(?,?,?,?)";
	static String viewAccountant="select * from accountant where name=?";
	static String deleteAccountant="delete from accountant where name=?";
	 PreparedStatement statement = null;
     static Connection connection=null;
	 String name=null,course=null;
	 int fee=0,paid=0,due=0;
	 Scanner sc = new Scanner(System.in);
	 static {
		 connection=JDBCUtil.getConnection();
	 }
	public void AddAccountant(String name,String password,String email,long contactNo) throws SQLException{
		//Scanner sc = new Scanner(System.in);
		statement =connection.prepareStatement(addAccountant);
		statement.setString(1, name);
		statement.setString(2,password);
		statement.setString(3, email);
		statement.setLong(4, contactNo);
		//rs=statement.executeUpdate();
		int rowsAffected = statement.executeUpdate();
		if (rowsAffected > 0) {
            System.out.println("New accountant '" + name + "' added successfully.");
            viewAccountant(name);
        } else {
            System.out.println("Failed to add new Accountant.");
        }
		
	}
	public void viewAccountant(String name) throws SQLException {
		statement =connection.prepareStatement(viewAccountant);
		statement.setString(1, name);
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			String accName1=rs.getString(1);
			String password1=rs.getString(2);
			String email1=rs.getString(3);
			long contactno=rs.getLong(4);
			System.out.print(accName1+"\t");
			System.out.print(password1+"\t");
			System.out.print(email1+"\t");
			System.out.println(contactno+"\t");
		}
	}
	public void deleteAccountant(String name) throws SQLException, ClassNotFoundException {
		statement =connection.prepareStatement(deleteAccountant);
		statement.setString(1, name);
		int rs=statement.executeUpdate();
		System.out.println("Accountant "+name+" Deleted");
		
	}

}
