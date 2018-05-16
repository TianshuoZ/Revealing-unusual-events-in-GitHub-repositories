package com.unusual.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.unusual.domain.User;
import com.unusual.service.UserLoginService;

public class UserLoginServelet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.get form data from the page
		String username = request.getParameter("username");
//		String userpwd = request.getParameter("userpwd");
		//2.transmit data to service layer
		UserLoginService service = new UserLoginService();
		List<User> loginData = null;
		try {
			loginData = service.getLoginData(username);
			System.out.println(loginData.get(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.judge if the logindata is not null -----> login successfully
		if(loginData != null) {
			//redirect to the dashboard.jsp
			System.out.println(loginData.get(0));
			request.setAttribute("loginData", loginData);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/dashboard.jsp");
			
//			Gson gson = new Gson();
//			String json = gson.toJson(loginData);
//			response.setContentType("type/html;charset=UTF-8");
//			response.getWriter().write(json);
			
		}else {
			//login failed ----> forward to the index page and display the information
			request.setAttribute("loginInfo", "Your Username or Password is Wrong!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}