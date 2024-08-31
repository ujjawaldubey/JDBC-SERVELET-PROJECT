package com.jsp.job_portal_management.service;

import com.jsp.job_portal_management.dao.RecruiterDao;
import com.jsp.job_portal_management.dto.Recruiter;

public class RecruiterService {
	
	RecruiterDao dao = new RecruiterDao();
	public Recruiter saveRecruiterService(Recruiter recruiter) {
		return dao.saveRecruiterDao(recruiter);
	}
	
	public Recruiter getRecruiterByEmailService(String email) {
		return dao.getRecruiterByEmailDao(email);
	}
		

}
