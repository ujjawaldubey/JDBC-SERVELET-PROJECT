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

import com.jsp.job_portal_management.dto.User;
import com.jsp.job_portal_management.service.UserService;

@WebServlet(value = "/registration")
@MultipartConfig
public class RegisterUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		String jobType = req.getParameter("options");
		String city = req.getParameter("city");
		Part cv = req.getPart("cv");
		Part img = req.getPart("image");

		InputStream resume = cv.getInputStream();
		InputStream image = img.getInputStream();
		
		User user = new User(name, email, password, city, jobType, phone, resume, image);

		UserService service = new UserService();

		service.saveUserService(user);
		req.getRequestDispatcher("user-login.jsp").forward(req, resp);

	}
}
