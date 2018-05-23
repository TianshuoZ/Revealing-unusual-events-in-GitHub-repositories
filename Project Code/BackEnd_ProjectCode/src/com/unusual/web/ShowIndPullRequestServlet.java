package com.unusual.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.domain.PullRequests;
import com.unusual.service.ShowIndPullRequestService;

public class ShowIndPullRequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String user_avatar = request.getParameter("user_avatar");
		String user_id = null;
		ShowIndPullRequestService service = new ShowIndPullRequestService();
		try {
			user_id = service.getUserid(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * 添加 service 获取数据的方法, 
		 * service---> 调用ShowAllDataService
		 * getIndCommits()方法写在 ShowAllDataService 里
		 */
		
		List<PullRequests> pullRequestsList = null;
		try {
			pullRequestsList = service.getPullRequestList(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("username", username);
		request.setAttribute("user_avatar", user_avatar);
		request.setAttribute("pullRequestsList", pullRequestsList);
		request.getRequestDispatcher("/ind_pull_request.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}