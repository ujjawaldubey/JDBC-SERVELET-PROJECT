package com.jsp.job_portal_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostJob {
	private int id;
	private String name;
	private String email;
	private long phone;
	private String title;
	private String location;
	private String experience;
	private String description;
	private String skills;
	private String role;
	private String salary;
	private String verify;
	
	private Recruiter recruiter;

	public PostJob(int id, String name, String email, long phone, String title, String location, String experience,
			String description, String skills, String role, String salary, String verify) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.title = title;
		this.location = location;
		this.experience = experience;
		this.description = description;
		this.skills = skills;
		this.role = role;
		this.salary = salary;
		this.verify = verify;
	}
}
