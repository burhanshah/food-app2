package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dao.OrderDao;
import com.foodapp.model.Order;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Object userName = request.getSession().getAttribute("userName");
		
		Order order = null;
		// When user want to add order
		
//			OrderDao orders = new OrderDao();
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			String comments = request.getParameter("comments");
			String orderId = request.getParameter("orderId");
			System.out.println(orderId);
			
			
			int orderIndex = Integer.parseInt(orderId) - 1;
			
			System.out.println(orderIndex);
			OrderDao.getAllOrders().get(orderIndex).setAddress(address);
			OrderDao.getAllOrders().get(orderIndex).setContact(contact);
			OrderDao.getAllOrders().get(orderIndex).setComments(comments);
			
			//request.setAttribute("order", orders);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp");
			dispatcher.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
