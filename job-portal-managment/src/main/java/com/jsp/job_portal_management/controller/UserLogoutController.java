package com.jsp.job_portal_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/userLogout")
public class UserLogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("userSession")!=null) {
			req.setAttribute("logoutMsg", "logout successfully");
			httpSession.invalidate();
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
	}
}
