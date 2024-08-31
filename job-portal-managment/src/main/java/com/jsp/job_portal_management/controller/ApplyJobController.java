package com.jsp.job_portal_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.job_portal_management.dao.AppliedJobDao;
import com.jsp.job_portal_management.dao.PostJobDao;
import com.jsp.job_portal_management.dto.AppliedJob;
import com.jsp.job_portal_management.dto.PostJob;
import com.jsp.job_portal_management.dto.User;
import com.jsp.job_portal_management.service.UserService;
import com.mysql.cj.Session;

@WebServlet(value = "/applyJob")
public class ApplyJobController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PostJobDao dao = new PostJobDao();
		
		UserService service = new UserService();
		
		AppliedJobDao appliedJobDao = new AppliedJobDao();

		HttpSession httpSession = req.getSession();

		String userEmail = (String) httpSession.getAttribute("userSession");

		Integer jobId = Integer.parseInt(req.getParameter("id"));

		User user = service.loginUserByEmailPasswordService(userEmail);

		PostJob postJob = dao.getPostJobByIdDao(jobId);
		
		if(userEmail!=null) {
			   	
				req.setAttribute("appliJobMsg", "Applied-Successfully");
				AppliedJob appliedJob = new AppliedJob(user, postJob);
				appliedJobDao.saveAppliedJobDao(appliedJob);
				
			   req.getRequestDispatcher("applied-job.jsp").forward(req, resp);
		}else {
			req.setAttribute("appliJobMsg", "Please-Login-And-Then-Apply");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
		
	}
}
