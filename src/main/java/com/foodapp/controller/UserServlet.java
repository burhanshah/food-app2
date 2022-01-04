package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dao.UserDao;
import com.foodapp.model.User;
import com.foodapp.model.UserType;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserRegistration.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/AdminLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userTypeStr = request.getParameter("userType");
		UserType userType = UserType.CUSTOMER;
		if (UserType.ADMIN.toString().equalsIgnoreCase(userTypeStr)) {
			userType = UserType.ADMIN;
		}

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassWord(password);
		user.setUserType(userType);

		userDao.registerUser(user);
		request.setAttribute("user", user);
		// response.sendRedirect("");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserDetails.jsp");
		dispatcher.forward(request, response);

	}

}
