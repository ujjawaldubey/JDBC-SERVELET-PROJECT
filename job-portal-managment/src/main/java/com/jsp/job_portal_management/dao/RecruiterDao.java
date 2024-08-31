package com.jsp.job_portal_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.job_portal_management.connection.UserConnection;
import com.jsp.job_portal_management.dto.Recruiter;
import com.jsp.job_portal_management.dto.User;
import com.mysql.cj.xdevapi.Result;

public class RecruiterDao {

	Connection connection = UserConnection.getUserConnection();
	
	public Recruiter saveRecruiterDao(Recruiter recruiter) {
		
		
		try {
			String insertRecruiterQuery = "insert into recruiter(name,email,phone,password,company) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertRecruiterQuery);
			preparedStatement.setString(1, recruiter.getName());
			preparedStatement.setString(2, recruiter.getEmail());
			preparedStatement.setLong(3, recruiter.getPhone());
			preparedStatement.setString(4, recruiter.getPassword());
			preparedStatement.setString(5, recruiter.getCompany());
			
			if(preparedStatement.execute())
			{
				return recruiter;
			}

		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public Recruiter getRecruiterByEmailDao(String email) {
		String selectQuery = "select * from recruiter where email=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Recruiter(resultSet.getString("email"), resultSet.getString("password"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
	
	public Recruiter getRecruiterAllColumnDataByEmailDao(String email) {
		String selectQuery = "select * from recruiter where email=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new Recruiter(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getString("company"),resultSet.getLong("phone"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
}
