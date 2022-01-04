package com.foodapp.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.dao.LoginDao;
import com.foodapp.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
@WebServlet("/userlogin")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }
    
    
      protected void doGet(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    	  
//    	  doPost(request, response);

			
			  response.getWriter().append("Served at: ").append(request.getContextPath());
			  
			  request.getSession().removeAttribute("userType");
			  
			  RequestDispatcher dispatcher =
			  request.getRequestDispatcher("WEB-INF/views/UserLogin.jsp");
			  dispatcher.forward(request, response);
			  }
      
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        loginBean.setRole(role);
        

        try {
        	
        	String userValidate = loginDao.validate(loginBean);
        	
            if (userValidate.equals("admin")) {
//                response.sendRedirect("loginsuccess.html");
//            	 response.sendRedirect("WEB-INF/views/AdminPannel.jsp");
            	  
            	HashMap<String, String> userDetails = new HashMap<String, String>();
            	  userDetails.put("username", username);
            	  userDetails.put("password", password);
            	  userDetails.put("role", role);
            	  

            	  // Creating a Session object and storing 
            	  // HashMap into it
            	  
            	  HttpSession session = request.getSession();
            	  session.setAttribute("user", userDetails);
            	  
            	 
         		// forwarding request to AdminPannel.jsp page
         			RequestDispatcher dispatcher =
         					request.getRequestDispatcher("WEB-INF/views/AdminPannel.jsp");
         				dispatcher.forward(request, response);
            	  } 
            	  else if (userValidate.equals("customer")) {
   	  
            		  HashMap<String, String> userDetails = new HashMap<String, String>();
                	  userDetails.put("username", username);
                	  userDetails.put("password", password);
                	  userDetails.put("role", role);
                	  

                	  // Creating a Session object and storing 
                	  // HashMap into it
                	  
                	  HttpSession session = request.getSession();
                	  session.setAttribute("user", userDetails);
                	  
            		// forwarding request to WelcomeUser.jsp page
            		  RequestDispatcher dispatcher =
               			 request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp");
            		  dispatcher.forward(request, response);
              	}
            		  
//            	if (loginBean.getRole() == "admin") {
//            		HttpSession session = request.getSession();
//            		session.setAttribute("user", userDetails);
//            	  // forwarding request to AdminPannel.jsp page
//            	RequestDispatcher dispatcher =
//            			 request.getRequestDispatcher("WEB-INF/views/AdminPannel.jsp");
//            	dispatcher.forward(request, response);
//            	} else if (loginBean.getRole() == "customer" ) {
//            		
//            		HttpSession session = request.getSession();
//            		session.setAttribute("user", userDetails);
//              	  
//            		RequestDispatcher dispatcher =
//               			 request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp");
//               	dispatcher.forward(request, response);
//            	}
            	
            else {
               // HttpSession session = request.getSession();
            	System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);
     
                request.getRequestDispatcher("/JSP/index.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}