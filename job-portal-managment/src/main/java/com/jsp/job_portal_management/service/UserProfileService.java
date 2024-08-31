package com.jsp.job_portal_management.service;

import com.jsp.job_portal_management.dao.UserProfileDao;
import com.jsp.job_portal_management.dto.UserProfile;

public class UserProfileService {

	UserProfileDao dao = new UserProfileDao();
	
	public UserProfile saveUserProfileService(UserProfile profile) {
		
		return dao.saveUserProfileDao(profile);
	}
}
