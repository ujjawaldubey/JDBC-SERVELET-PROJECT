package com.jsp.job_portal_management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.job_portal_management.dao.UserDao;
import com.jsp.job_portal_management.dao.UserProfileDao;
import com.jsp.job_portal_management.dto.User;
import com.jsp.job_portal_management.dto.UserProfile;
import com.jsp.job_portal_management.service.UserProfileService;
import com.jsp.job_portal_management.service.UserService;

@SuppressWarnings("serial")
@WebServlet(value = "/updateUserProfile")
public class UserProfileController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDao dao = new UserDao();

		UserProfileService profileService = new UserProfileService();

		UserProfileDao profileDao = new UserProfileDao();
		
		String userEmail = req.getParameter("email");

		User user = dao.getAllUserDetailsByEmailDao(userEmail);

		UserProfile profile = new UserProfile(req.getParameter("current"), req.getParameter("permanent"),
				Integer.parseInt(req.getParameter("pincode")), req.getParameter("state"), req.getParameter("city"),
				req.getParameter("education"), req.getParameter("country"), user);

		int userid=profileDao.getUserIdByUserIdFromUserProfileDao(user.getId());
		
		if(userid!=0) {
			profile.setUser(user);
			profileDao.updateUserProfileByUserIdDao(profile);
		}else {
			profileService.saveUserProfileService(profile);
		}
		
		req.setAttribute("userDetails", user);

		req.getRequestDispatcher("user-profile.jsp").forward(req, resp);
	}

}
