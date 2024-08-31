package com.jsp.job_portal_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.job_portal_management.connection.UserConnection;
import com.jsp.job_portal_management.dto.PostJob;

public class GetJobDetails {

	Connection conn = UserConnection.getUserConnection();

	public List<PostJob> getAllPostedJobDetailsDao() {

		String selectQuery = "SELECT * FROM postjob";

		try {
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			ResultSet set = ps.executeQuery();

			List<PostJob> jobs = new ArrayList<PostJob>();

			while (set.next()) {

				PostJob postJob = new PostJob(set.getInt("id"), set.getString("name"), set.getString("email"),
						set.getLong("phone"), set.getString("title"), set.getString("location"),
						set.getString("experience"), set.getString("description"), set.getString("skill"),
						set.getString("role"), set.getString("salary"), set.getString("verified"));
				jobs.add(postJob);
			}
			return jobs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PostJob getJobByIdDao(int jobId) {

		String selectQuery = "SELECT * FROM postjob where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(selectQuery);
			ps.setInt(1, jobId);
			ResultSet set = ps.executeQuery();

			if (set.next()) {

				return new PostJob(set.getInt("id"), set.getString("name"), set.getString("email"),
						set.getLong("phone"), set.getString("title"), set.getString("location"),
						set.getString("experience"), set.getString("description"), set.getString("skill"),
						set.getString("role"), set.getString("salary"), set.getString("verified"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
