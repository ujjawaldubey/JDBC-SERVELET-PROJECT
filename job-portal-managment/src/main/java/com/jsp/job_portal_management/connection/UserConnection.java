package com.jsp.job_portal_management.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class UserConnection {

	
	public static  Connection getUserConnection() {
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal", "root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
