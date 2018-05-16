package com.unusual.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.domain.Commits;
import com.unusual.domain.User;
import com.unusual.service.GetUserInfoService;
import com.unusual.service.ShowIndCommitsService;

public class ShowIndCommitsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		request.setAttribute("username", username);
		/*
		 * 添加 service 获取数据的方法, 
		 * service---> 调用ShowAllDataService
		 * getIndCommits()方法写在 ShowAllDataService 里
		 */
		GetUserInfoService service = new GetUserInfoService();
		//用 username 获取 uid, 调用 GetUserInfoServlet 中的方法
		List<User> userList = null;
		String uid = null;
		try {
			userList = service.getUserInfo(username);
			uid = (userList.get(0)).getUser_id();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//### Attention: 在 dao 层实际是用 repository_idc 查询的数据 ###
		List<Commits> commitsList = null;
		ShowIndCommitsService service2 = new ShowIndCommitsService();
		try {
			commitsList = service2.getIndCommits(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("commitsList", commitsList);
		
		request.getRequestDispatcher("/ind_commits.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}