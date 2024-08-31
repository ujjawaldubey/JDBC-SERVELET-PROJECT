package com.jsp.job_portal_management.controller;

import java.io.IOException;
import java.lang.module.ModuleDescriptor.Requires;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.job_portal_management.dao.AdminDao;
import com.jsp.job_portal_management.dto.Admin;
import com.jsp.job_portal_management.dto.Recruiter;
import com.jsp.job_portal_management.dto.User;
import com.jsp.job_portal_management.service.RecruiterService;
import com.jsp.job_portal_management.service.UserService;


@SuppressWarnings("serial")
@WebServlet(value ="/userlogin")
public class UserLoginController extends HttpServlet{
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession httpSession = req.getSession();
		
		UserService service = new UserService();
		RecruiterService recruiterService = new RecruiterService();
		
		AdminDao adminDao = new AdminDao();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String loginType = req.getParameter("login");
		
		
		
		if(loginType.equals("user")) {
			User user=service.loginUserByEmailPasswordService(username);
			if(user!=null) {
				
				if(user.getPassword().equals(password)) {
					httpSession.setAttribute("userSession", username);
					req.getRequestDispatcher("user-home.jsp").forward(req, resp);
				}else {
					req.setAttribute("passwordWrong", "password is incorrect");
					req.getRequestDispatcher("user-login.jsp").forward(req, resp);
				}
				
			}else {
				req.setAttribute("emailWrong", "email is incorrect");
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}
			
		}else if(loginType.equals("admin")) {
			Admin admin = adminDao.loginAdminDao(username);
			
			if(admin!=null) {
				if(admin.getPassword().equals(password)) {
					httpSession.setAttribute("adminSession", username);
					req.getRequestDispatcher("admin-home.jsp").forward(req, resp);
				}else {
					req.setAttribute("passwordWrong", "password is incorrect");
					req.getRequestDispatcher("user-login.jsp").forward(req, resp);
				}
			}else {
				req.setAttribute("emailWrong", "email is incorrect");
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}
		}
		
		else {
			Recruiter recruiter = recruiterService.getRecruiterByEmailService(username);
			
			if(recruiter!=null) {
				if(recruiter.getPassword().equals(password)) {
					httpSession.setAttribute("recruiterSession", username);
					req.getRequestDispatcher("recruiter-home.jsp").forward(req, resp);
				}else {
					req.setAttribute("passwordWrong", "password is incorrect");
					req.getRequestDispatcher("user-login.jsp").forward(req, resp);
				}
			}else {
				req.setAttribute("emailWrong", "email is incorrect");
				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
			}
			
			
		}
	}

}
