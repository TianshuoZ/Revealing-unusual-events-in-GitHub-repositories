package com.unusual.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.unusual.domain.Events;
import com.unusual.domain.Repository;
import com.unusual.domain.User;
import com.unusual.service.GetUserInfoService;
/**
 * This page is for the basic information displaying on dashboard.jsp
 * @function 1.use username to enter system 
 * @function 2.get user's unusual events and display on table 
 * @function 3.simple status display
 * 
 * @version 1.0
 * @author lee
 *
 */
public class GetUserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现简单登录功能
		String username = request.getParameter("username");
		GetUserInfoService service = new GetUserInfoService();
		List<User> userList = null;
		try {
			userList = service.getUserInfo(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String userid = (userList.get(0)).getUser_id();
		//实现读取 unusual_event 数据
		List<Events> eventsList = null;
		try {
			eventsList = service.getEventsList(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//实现拿到最新的Unusual Event
		List<Events> latestEventList = null;
		try {
			latestEventList = service.getLatestEventList(userid);
//			System.out.println(latestEventList);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		int reposNum=0;
		Object commitNum=0;
		Object issueNum=0;
		Object pullRequestNum=0;
		int unusualEventsNum=0;
		try {
			//repository 数量
			reposNum = (int) service.getRepositoryNum(userid);
			//commit数量
			commitNum = service.getCommmitNum(userid);
			//pull-request数量
			pullRequestNum = service.getPullRequestNum(userid);
			//issue数量
			issueNum = service.getIssueNum(userid);
			//添加unusualevents 数量
			unusualEventsNum = (int) service.getUnusualEventsNum(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//用 user_id 取所有该用户下的所有 repository ---> repositoryList
		List<Repository> repositoryList = null;
		try {
			repositoryList = service.getRepositoryList(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String user_avatar = userList.get(0).getUser_avatar();
		
		
		//判断是否 userList 是否为空
		if(userList.size() != 0) {
			request.setAttribute("userList", userList);
			request.setAttribute("user_avatar", user_avatar);
			request.setAttribute("username", username);
			request.setAttribute("commitNum", commitNum);
			request.setAttribute("repositoryList", repositoryList);
			request.setAttribute("latestEventList", latestEventList);
			request.setAttribute("issueNum", issueNum);
			request.setAttribute("pullRequestNum", pullRequestNum);
			request.setAttribute("repository", reposNum);
			request.setAttribute("unusualEvents", unusualEventsNum);
//			Gson gson = new Gson();
//			String json = gson.toJson(userList);
//			System.out.println(json);
//			System.out.println("username:\t"+username);
			
			request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
			
		}else {
			request.setAttribute("loginInfo", "Your username is wrong...");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}