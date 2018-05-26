package com.unusual.admin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.admin.service.AdminEventsListService;
import com.unusual.admin.service.AdminLoginService;
import com.unusual.admin.service.AdminUsersService;
import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;
import com.unusual.domain.Repository;
import com.unusual.domain.User;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Get all unusualevent as a list type
		AdminLoginService service = new AdminLoginService();
		AdminUsersService usersService = new AdminUsersService();
		List<Event_Name> eventNameList = null;
		List<User> usersList = null;
		List<Repository> repositoriesList = null;
		String UserNumber = null;
		String RepositoryNumber = null;
		String EventNumber = null;
		try {
			UserNumber = service.getUserNumber();
			RepositoryNumber= service.getRepositoryNumber();
			EventNumber= service.getEventNumber();
			eventNameList = service.getEventsList();
			usersList = usersService.getUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("eventNameList", eventNameList);
		request.setAttribute("UserNumber", UserNumber);
		request.setAttribute("RepositoryNumber", RepositoryNumber);
		request.setAttribute("EventNumber", EventNumber);
		request.setAttribute("usersList", usersList);
		
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}