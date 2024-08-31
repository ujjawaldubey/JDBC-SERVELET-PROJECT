package com.jsp.job_portal_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.job_portal_management.dao.RecruiterDao;
import com.jsp.job_portal_management.dto.PostJob;
import com.jsp.job_portal_management.dto.Recruiter;
import com.jsp.job_portal_management.service.PostJobService;

@SuppressWarnings({ "unused", "serial" })
@WebServlet(value = "/postJob")
public class PostJobController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RecruiterDao dao = new RecruiterDao();
		
		HttpSession httpSession = req.getSession();
		
		String recruiterEmail =(String)httpSession.getAttribute("recruiterSession");
		
		Recruiter recruiter = dao.getRecruiterAllColumnDataByEmailDao(recruiterEmail);
		
		
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String title = req.getParameter("title");
		long phone  = Long.parseLong(req.getParameter("phone"));
		String location = req.getParameter("location");
		String experience = req.getParameter("experience");
		String description = req.getParameter("description");
		String skill  = req.getParameter("skill");
		String role = req.getParameter("role");
		String salary = req.getParameter("salary");
		
		
		PostJob postJob = 
				PostJob.builder()
				.name(name)
				.email(email)
				.title(title)
				.phone(phone)
				.location(location)
				.experience(experience)
				.description(description)
				.skills(skill)
				.role(role)
				.salary(salary)
				.recruiter(recruiter).build();
		
		PostJobService jobService = new PostJobService();
		
		if(httpSession.getAttribute("recruiterSession")!=null) {
			   jobService.savePostJobService(postJob);
			req.getRequestDispatcher("recruiter-home.jsp").forward(req, resp);
		}else {
			req.setAttribute("sessionLogout", "your session is logout please login with valid credential");
			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
		}
	}
}
