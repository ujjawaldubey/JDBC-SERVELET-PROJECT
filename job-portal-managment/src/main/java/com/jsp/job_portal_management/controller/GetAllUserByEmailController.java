package com.jsp.job_portal_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.job_portal_management.dao.UserDao;
import com.jsp.job_portal_management.dto.User;

@WebServlet("/getUserDetails")
public class GetAllUserByEmailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		
		String email = (String) httpSession.getAttribute("userSession");
		
		UserDao dao = new UserDao();
		
		User user=dao.getAllUserDetailsByEmailDao(email);
		
		req.setAttribute("userDetails", user);
		
		
		req.getRequestDispatcher("user-profile.jsp").forward(req, resp);
	}
}
