package com.jsp.job_portal_management.service;

import com.jsp.job_portal_management.dao.PostJobDao;
import com.jsp.job_portal_management.dto.PostJob;

public class PostJobService {

	PostJobDao dao = new PostJobDao();
	
	public PostJob savePostJobService(PostJob job) {
		return dao.savePostJobDao(job);
	}
	
	public int verifyPostJobService(int id) {
		return dao.verifyPostJobDao(id);
	}
}
