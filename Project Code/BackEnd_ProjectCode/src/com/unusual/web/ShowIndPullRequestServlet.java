package com.unusual.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowIndPullRequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		request.setAttribute("username", username);
		/*
		 * 添加 service 获取数据的方法, 
		 * service---> 调用ShowAllDataService
		 * getIndCommits()方法写在 ShowAllDataService 里
		 */

		request.getRequestDispatcher("/ind_pull_request.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}