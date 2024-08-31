package com.jsp.job_portal_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.job_portal_management.connection.UserConnection;
import com.jsp.job_portal_management.dto.PostJob;

/**
 * 
 * @author Mo Masood Ansari
 *
 *
 */
public class PostJobDao {

	Connection con = UserConnection.getUserConnection();

	public PostJob savePostJobDao(PostJob job) {

		String insertQuery = "insert into postjob(name,email,phone,title,location,experience,description,skill,role,salary,verified,recruiterid)  values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setString(1, job.getName());
			ps.setString(2, job.getEmail());
			ps.setLong(3, job.getPhone());
			ps.setString(4, job.getTitle());
			ps.setString(5, job.getLocation());
			ps.setString(6, job.getExperience());
			ps.setString(7, job.getDescription());
			ps.setString(8, job.getSkills());
			ps.setString(9, job.getRole());
			ps.setString(10, job.getSalary());
			ps.setString(11, "no");
			ps.setInt(12, job.getRecruiter().getId());
			ps.execute();
			return job;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PostJob getPostJobByIdDao(int id) {

		String selectQuery = "SELECT * From postjob";

		try {
			PreparedStatement ps = con.prepareStatement(selectQuery);

			ResultSet set = ps.executeQuery();

			if (set.next()) {

				PostJob postJob = new PostJob(set.getInt("id"), set.getString("name"), set.getString("email"),
						set.getLong("phone"), set.getString("title"), set.getString("location"),
						set.getString("experience"), set.getString("description"), set.getString("skill"),
						set.getString("role"), set.getString("salary"), set.getString("verified"));
				return postJob;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int verifyPostJobDao(int id) {
		String updateQuery = "update postjob set verified='yes' Where id=" + id;
		try {
			Statement statement = con.createStatement();
			return statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<PostJob> getAllVerifiedJobDao() {
		String selectQuery = "SELECT * From postjob where verified='yes'";
		try {
			Statement ps = con.createStatement();
			ResultSet set = ps.executeQuery(selectQuery);
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
}
