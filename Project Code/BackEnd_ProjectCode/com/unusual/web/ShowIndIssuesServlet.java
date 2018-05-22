package com.unusual.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.domain.Issues;
import com.unusual.service.ShowIndIssuesService;

public class ShowIndIssuesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String user_avatar = request.getParameter("user_avatar");
		String userid = null;
		ShowIndIssuesService service = new ShowIndIssuesService();
		try {
			userid = service.getUserid(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * 添加 service 获取数据的方法, 
		 * service---> 调用ShowAllDataService
		 * getIndCommits()方法写在 ShowAllDataService 里
		 */
		//得到所有 issue的列表
		List<Issues> issuesList = null;
		try {
			issuesList = service.getIssuesList(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("username", username);
		request.setAttribute("user_avatar", user_avatar);
		request.setAttribute("issuesList", issuesList);

		request.getRequestDispatcher("/ind_issues.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}