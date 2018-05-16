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
import com.unusual.service.GetUserInfoService;

public class GetUserNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从 header.jsp 获得 username
		String username = request.getParameter("username");
//		System.out.println("username="+username);
		GetUserInfoService service = new GetUserInfoService();
		List<User> loginData = null;
		
		try {
			loginData = service.getUserInfo(username);
			Gson gson = new Gson();
			String json = gson.toJson(loginData);
//			System.out.println(json);
			response.getWriter().write(json);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}