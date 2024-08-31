package com.jsp.job_portal_management.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.job_portal_management.dao.UserDao;
import com.jsp.job_portal_management.dto.User;

@WebServlet(value = "/updateProfileImage")
@MultipartConfig
public class UpdateImageController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao dao = new UserDao();
		
		String email = req.getParameter("email");
		
		User user = dao.getAllUserDetailsByEmailDao(email);
		
		Part file = req.getPart("image");
		
		InputStream image = file.getInputStream();
		
		dao.updateUserProfileImageDao(email, image);
		
		req.setAttribute("userDetails", user);
		
		req.getRequestDispatcher("user-profile.jsp").include(req, resp);
	}
}
