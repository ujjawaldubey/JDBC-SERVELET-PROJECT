package com.jsp.job_portal_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.job_portal_management.connection.UserConnection;
import com.jsp.job_portal_management.dto.AppliedJob;

public class AppliedJobDao {

	Connection connection = UserConnection.getUserConnection();
	
	public AppliedJob saveAppliedJobDao(AppliedJob appliedJob) {
		
		String insertQuery  = "insert into appliedjob(userid,jobid) values(?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, appliedJob.getUser().getId());
			preparedStatement.setInt(2, appliedJob.getJob().getId());
			
			preparedStatement.execute();
			
			return appliedJob;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
