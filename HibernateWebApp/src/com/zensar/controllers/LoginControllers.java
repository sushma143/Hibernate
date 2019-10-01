package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entity.User;
import com.zensar.exceptions.ServiceException;

import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
 * Servlet implementation class LoginControllers
 */
/**
 * @author Sushma Kumari
 * @version 2.0
 * @creation_date 21st Sept 2019 5.32PM
 * @modification_date 21st Sept 2019 11:49 AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is a controller class. 
 *				
 */
@WebServlet("/checkuser")
public class LoginControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//setUserService variable && call business layer component
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDaoImpl();
		UserService userService=new UserServiceImpl();
		((UserServiceImpl) userService).setUserDao(userDao);
		
		setUserService(userService); 
		
	}
	
	
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String username=request.getParameter("username");
		String password=request.getParameter("passwd");
		
//		 HttpSession session=request.getSession();  
//	        session.setAttribute("uname",username); 
	        
		
		PrintWriter out =response.getWriter();
		
		//System.out.println("Session id in Product servlet:"+session.getId());
		User clientUser=new User();
		clientUser.setUsername(username);
		clientUser.setPassword(password);
		
//		if(username!=null && password!=null &&
//				username.equals("sushma") && password.equals("123456"))
//		{
//			//out.println("<p> Dear "+username+" Welcome to Zensar<p>");
//			RequestDispatcher rd = request.getRequestDispatcher("Welcome");
//			rd.forward(request, response); 
//		}
//		else
//		{
//			out.println("<p>Sorry ! Invalid Username/Password</p>");
//			RequestDispatcher rd= request.getRequestDispatcher("Login.html");
//			rd.include(request, response);
//		}
		
	
		try {
			if(userService.validateUser(clientUser))
			{
				//out.println("<p> Dear "+username+" Welcome to Zensar<p>");
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response); 
			}
			else
			{
				out.println("<p>Sorry ! Invalid Username/Password</p>");
				RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
