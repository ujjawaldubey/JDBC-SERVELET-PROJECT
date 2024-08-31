package com.jsp.job_portal_management.dto;

public class AppliedJob {
	
	private int id;
	private User user;
	private PostJob job;

	public AppliedJob() {
		super();
	}

	public AppliedJob(User user, PostJob job) {
		super();
		this.user = user;
		this.job = job;
	}

	public AppliedJob(int id, User user, PostJob job) {
		super();
		this.id = id;
		this.user = user;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostJob getJob() {
		return job;
	}

	public void setJob(PostJob job) {
		this.job = job;
	}
}
