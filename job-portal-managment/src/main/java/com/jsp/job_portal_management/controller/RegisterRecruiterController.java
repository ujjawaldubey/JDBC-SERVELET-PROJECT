package com.jsp.job_portal_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.job_portal_management.dto.Recruiter;
import com.jsp.job_portal_management.service.RecruiterService;

@WebServlet(value = "/recruiterRegister")
public class RegisterRecruiterController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		String companyName = req.getParameter("company");
		

		RecruiterService service = new RecruiterService();
		
		service.saveRecruiterService(new Recruiter(name, email, password, companyName, phone));
		
		req.getRequestDispatcher("user-login.jsp").forward(req, resp);
	}
	
}
