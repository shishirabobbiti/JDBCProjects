package com.studentManagement;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
          Student s = new Student();
          Accountant a=new Accountant();
		Boolean b=true;
		while(b) {
			System.out.println("1.Admin\n2.Accountant\n3.Exit");
			int viewOption=sc.nextInt();
			if(viewOption==1) {
				System.out.println("1.Add Accountant\n2.View Accountant\n3.Delete Accountant\n4.Exit");
				int choice=sc.nextInt();
				if(choice==1) {
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Password");
				String password = sc.next();
				System.out.println("Enter email");
				String email = sc.next();
				System.out.println("Enter contactNo");
				long contactNo = sc.nextInt();
				a.AddAccountant(name,password,email,contactNo);	
				}
				else if(choice==2) {
					System.out.println("Enter Name");
					String name = sc.next();
					 a.viewAccountant(name);
				}
				else if(choice==3) {
					System.out.println("Enter Name");
					String name = sc.next();
					a.deleteAccountant(name);
				}
				else if(choice==4) {
					b=false;
				}
				else {
					System.out.println("Invalid Option");
				}
			}
			else if(viewOption==2) {
				System.out.println("1.Add Student\n2.View Student\n3.Edit Student\n4.FeeDue update\n5.Delete Student\n6.Exit");
				int choice=sc.nextInt();
				if(choice==1) {
					System.out.println("Enter Name");
					String name = sc.next();
					System.out.println("Enter Email");
					String email = sc.next();
					System.out.println("Enter course");
					String course = sc.next();
					System.out.println("Enter Fee");
					int fee = sc.nextInt();
					System.out.println("Enter Address");
					String address = sc.next();
					System.out.println("Enter Contact No");
					long contactNo = sc.nextLong();
					System.out.println("Enter amount paid");
			    	int paid = sc.nextInt();
			    	System.out.println("Enter amount due");
			    	int due = sc.nextInt();
					s.addStudent(name,email,course,fee,address,contactNo,paid,due);
				}
				else if(choice==2) {
					System.out.println("Enter Name");
					String name = sc.next();
					s.viewStudent(name);
				}
				else if(choice==3) {
					System.out.println("Enter Name");
					String name = sc.next();
					System.out.println("Enter course");
					String course = sc.next();
					s.editStudent(course,name);
				}
				else if(choice==4) {
					System.out.println("Enter Name");
					String name = sc.next();
			        System.out.println("Enter Amount");
			        int amt = sc.nextInt();
			        s.dueFeeUpdate(name, amt);
				}
				else if(choice==5) {
					System.out.println("Enter Name");
					String name = sc.next();
					s.deleteStudent(name);
				}
				else if(choice==6) {
					b=false;
				}
				else {
					System.out.println("Invslid Choice");
				}
			}
			else if(viewOption==3) {
				b=false;
			}
			else {
				System.out.println("Invalid Choice");
			}
			}
			
     
	}
	

}
