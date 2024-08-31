package com.jsp.job_portal_management.dto;

public class Recruiter {

	private int id;
	private String name;
	private String email;
	private String password;
	private String company;
	private long phone;
	
	public Recruiter() {
		super();
	}

	public Recruiter(int id, String name, String email, String password, String company, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.company = company;
		this.phone = phone;
	}
	
	/*
	 * get AllColumn By Email for that we have created this constructor
	 */
	public Recruiter(int id, String name, String email, String company, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.company = company;
		this.phone = phone;
	}

	public Recruiter(String name, String email, String password, String company, long phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.company = company;
		this.phone = phone;
	}
	
	

	public Recruiter(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}	
	
}
