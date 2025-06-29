package com.studentManagement;

import java.time.LocalDate;

public class DateExample {

	public static void main(String[] args) {
		
		//Database->date format
		
		//java.util.Date->Java programs
		//java.sql.Date->jdbc programs
		
		java.util.Date date=new java.util.Date();
		long value=date.getTime();
		System.out.println(value);
		java.sql.Date sqlDate= new java.sql.Date(value);
		System.out.println(sqlDate);

	}

}
