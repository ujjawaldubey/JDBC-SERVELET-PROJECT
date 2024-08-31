package com.jsp.job_portal_management.dto;

public class UserProfile {
	
	private int id;
	private String currentAddress;
	private String permanentAddress;
	private int pincode;
	private String state;
	private String city;
	private String education;
	private String country;
	private User user;
	
	public UserProfile() {
		super();
	}

	public UserProfile(int id, String currentAddress, String permanentAddress, int pincode, String state, String city,
			String education, String country, User user) {
		super();
		this.id = id;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.education = education;
		this.country = country;
		this.user = user;
	}
	public UserProfile(String currentAddress, String permanentAddress, int pincode, String state, String city,
			String education, String country, User user) {
		super();
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.education = education;
		this.country = country;
		this.user = user;
	}	

	public UserProfile(String currentAddress, String permanentAddress, int pincode, String state, String city,
			String education, String country) {
		super();
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.education = education;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
