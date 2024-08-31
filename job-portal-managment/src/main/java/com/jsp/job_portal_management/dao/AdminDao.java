package com.jsp.job_portal_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.job_portal_management.connection.UserConnection;
import com.jsp.job_portal_management.dto.Admin;

public class AdminDao {

	Connection connection = UserConnection.getUserConnection();

	public Admin loginAdminDao(String email) {
		
		String selectQuery = "Select * from admin where email=?";

		try {
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setString(1, email);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				return new Admin(resultSet.getString("email"), resultSet.getString("pass"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
}
