package com.studentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	static String addStudent = "insert into stud(name,email,course,fee,address,contactNo,paid,due)"+"values(?,?,?,?,?,?,?,?)";
	static String viewStudent="select * from stud where name=?";
	static String editStudent="UPDATE stud SET course=? WHERE name=?";
	static String deleteStudent="delete from stud where name=?";
     PreparedStatement statement = null;
     static Connection connection=null;
	 String name=null,course=null;
	 int fee=0,paid=0,due=0;
	 //Integer rs=null;
	// ResultSet rs=null;
	 Scanner sc = new Scanner(System.in);
	 static {
		 connection=JDBCUtil.getConnection();
	 }

	public void addStudent(String name,String email,String course,int fee,String address,Long contactNo,int paid,int due) throws ClassNotFoundException, SQLException {	
		statement =connection.prepareStatement(addStudent);
		statement.setString(1, name);
		statement.setString(2,email);
		statement.setString(3, course);
		statement.setInt(4, fee);
		statement.setString(5, address);
		statement.setLong(6, contactNo);
		statement.setInt(7, paid);
		statement.setInt(8, due);
		//rs=statement.executeUpdate();
		int rowsAffected = statement.executeUpdate();
		if (rowsAffected > 0) {
            System.out.println("New student '" + name + "' added successfully.");
            viewStudent(name);
        } else {
            System.out.println("Failed to add new student.");
        }
		
	}
	public void viewStudent(String name) throws ClassNotFoundException, SQLException {
		statement =connection.prepareStatement(viewStudent);
		statement.setString(1, name);
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			String name1=rs.getString(1);
			String email=rs.getString(2);
			String course=rs.getString(3);
			int fee=rs.getInt(4);
			String address=rs.getString(5);
			long contactNo=rs.getLong(6);
			int paid=rs.getInt(7);
			int due=rs.getInt(8);
			System.out.print(name1+"\t");
			System.out.print(email+"\t");
			System.out.print(course+"\t");
			System.out.print(fee+"\t");
			System.out.print(address+"\t");
			System.out.print(contactNo+"\t");
			System.out.print(paid+"\t");
			System.out.println(due);
		}
	}
	public void editStudent(String course,String name) throws SQLException, ClassNotFoundException {
		statement =connection.prepareStatement(editStudent);
		statement.setString(1, course);
		statement.setString(2,name );
		int rowsAffected=statement.executeUpdate();
		if(rowsAffected>0) {
			 System.out.println("Update successful! " + rowsAffected + " row(s) updated.");
		}
		else {
		    System.out.println("No rows updated. Maybe the student name does not exist.");
		}
		
		viewStudent(name);
		
	}
	public void dueFeeUpdate(String name,int amt) throws SQLException, ClassNotFoundException{
		statement =connection.prepareStatement("UPDATE stud SET paid=paid+'"+amt+"',due = due-'"+amt+"' WHERE name=?");
		statement.setString(1, name);
		int rs=statement.executeUpdate();
		System.out.println("Amount paid:"+amt);
		viewStudent(name);
	}
	public void deleteStudent(String name) throws SQLException, ClassNotFoundException {
		statement =connection.prepareStatement(deleteStudent);
		statement.setString(1, name);
		int rs=statement.executeUpdate();
		System.out.println("student "+name+" Deleted");
		
	}
}
