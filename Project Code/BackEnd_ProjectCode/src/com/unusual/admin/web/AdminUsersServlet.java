package com.unusual.admin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.admin.service.AdminUsersService;
import com.unusual.domain.User;

public class AdminUsersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminUsersService service = new AdminUsersService();
		List<User> userList = null;
		
		try {
			userList = service.getUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("userList", userList);
		
		request.getRequestDispatcher("/admin/userlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}