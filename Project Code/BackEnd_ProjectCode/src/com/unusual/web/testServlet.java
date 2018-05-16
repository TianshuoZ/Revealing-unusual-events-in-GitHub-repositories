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
import com.unusual.service.TestService;

public class testServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		TestService service = new TestService();	
		List<User> accountList = null; 
		try {
			accountList = service.getUsername(username);
			if(accountList != null) {
				Gson gson = new Gson();
				String json = gson.toJson(accountList);
				System.out.println(json);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else {
				response.getWriter().write("数据未取到!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}