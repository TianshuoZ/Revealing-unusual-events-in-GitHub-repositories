package com.unusual.admin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.admin.service.AdminEventsListService;
import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;

public class AdminEventsListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminEventsListService service = new AdminEventsListService();
		List<Event_Name> events = null;
		try {
			events = service.getEventsList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("events", events);
		
		request.getRequestDispatcher("/admin/eventlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}