package com.jsp.job_portal_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsp.job_portal_management.connection.UserConnection;
import com.jsp.job_portal_management.dto.User;
import com.jsp.job_portal_management.dto.UserProfile;

public class UserProfileDao {

	Connection connection = UserConnection.getUserConnection();

	public UserProfile saveUserProfileDao(UserProfile profile) {

		String insertQuery = "insert into userprofile(current,permanent,pincode,state,city,education,country,userid) values(?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement ps = connection.prepareStatement(insertQuery);

			System.out.println(profile.getUser().getId());

			ps.setString(1, profile.getCurrentAddress());
			ps.setString(2, profile.getPermanentAddress());
			ps.setInt(3, profile.getPincode());
			ps.setString(4, profile.getState());
			ps.setString(5, profile.getCity());
			ps.setString(6, profile.getEducation());
			ps.setString(7, profile.getCountry());
			ps.setInt(8, profile.getUser().getId());

			ps.execute();

			return profile;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int getUserIdByUserIdFromUserProfileDao(int userId) {

		String selectQuery = "select userid from userprofile where userid=?";

		try {
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, userId);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				return resultSet.getInt("userid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public UserProfile getUserProfileByUserIdDao(int userId) {
		String selectQuery = "SELECT * FROM userprofile where userid="+userId;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			if(resultSet.next()) {
				
				return new UserProfile(
						resultSet.getString("current"),
						resultSet.getString("permanent"), 
						resultSet.getInt("pincode"), 
						resultSet.getString("state"), 
						resultSet.getString("city"),
						resultSet.getString("education"), 
						resultSet.getString("country"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateUserProfileByUserIdDao(UserProfile profile) {
		
		String updateQuery = "update userprofile set  current=?,permanent=?,pincode=?,state=?,city=?,education=?,country=? Where userid=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, profile.getCurrentAddress());
			ps.setString(2, profile.getPermanentAddress());
			ps.setInt(3, profile.getPincode());
			ps.setString(4, profile.getState());
			ps.setString(5, profile.getCity());
			ps.setString(6, profile.getEducation());
			ps.setString(7, profile.getCountry());
			ps.setInt(8, profile.getUser().getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
