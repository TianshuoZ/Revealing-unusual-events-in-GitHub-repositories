package com.unusual.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.domain.Event_Name;
import com.unusual.domain.Events;
import com.unusual.domain.User;
import com.unusual.service.GetUnusualEventsListService;
import com.unusual.service.GetUserInfoService;


public class GetUnusualEventsListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		GetUserInfoService service = new GetUserInfoService();
		
		List<User> userList = null;
		try {
			userList = service.getUserInfo(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String userid = (userList.get(0)).getUser_id();
		
		List<Events> unusualEventsList = null;
		
		GetUnusualEventsListService service2 = new GetUnusualEventsListService();
		try {
			unusualEventsList = service2.getUnusualEventList(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		List<Event_Name> eventNameList = null;
		try {
			eventNameList = service2.getEventNameList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		System.out.println("unusual:"+unusualEventsList);
		
		request.setAttribute("unusualEventsList", unusualEventsList);
		request.setAttribute("username", username);
		request.setAttribute("eventNameList", eventNameList);
		request.getRequestDispatcher("/tables.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
