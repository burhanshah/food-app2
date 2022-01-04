package com.foodapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.dao.LoginDao;
import com.foodapp.dao.OrderDao;
import com.foodapp.model.LoginBean;
import com.foodapp.model.Order;
import com.foodapp.model.UserType;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/views/allorders.jsp");
		dispatcher.forward(request, response);
  


		//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String resname = request.getParameter("resname");
//
//		Object user = request.getSession().getAttribute("userType");
//		if (UserType.ADMIN.toString().equalsIgnoreCase(user.toString())) {
//			request.setAttribute("allorders", OrderDao.getAllOrders());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/allorders.jsp");
//			dispatcher.forward(request, response);
//			return;
//		}
//		Object userName = request.getSession().getAttribute("userName");
//		Map<String, String[]> parameterMap = request.getParameterMap();
//		Order order = null;
//		// When user want to add order
//		if(parameterMap.size() > 0) {
//			order = OrderDao.addOrder(userName.toString(), parameterMap, resname);
//			request.setAttribute("order", order);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/order.jsp");
//			dispatcher.forward(request, response);
//		} else {
//			// When user want to see his own order
//			request.setAttribute("allorders", OrderDao.getOrderByUser(userName.toString()));
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/allorders.jsp");
//			dispatcher.forward(request, response);
//			return;
//			
//		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
