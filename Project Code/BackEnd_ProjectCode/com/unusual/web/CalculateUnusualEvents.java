package com.unusual.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unusual.domain.Commits;
import com.unusual.domain.Issues;
import com.unusual.domain.PullRequests;
import com.unusual.service.CalculateUnusualEventsService;

public class CalculateUnusualEvents extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String repository_id=request.getParameter("repository_id");
		CalculateUnusualEventsService service = new CalculateUnusualEventsService();
		//System.out.println("id:"+repository_id);
		List<Commits> commitsList = null;
		List<Issues> issuesList = null;
		List<PullRequests> pullRequestsList = null;
		try {
			commitsList = service.getCommitsList(repository_id);
			issuesList = service.getIssuesList(repository_id);
			pullRequestsList = service.getPullRequestsList(repository_id);
			
			service.deleteEventByRepositoryId(repository_id);
			
			service.calculate(commitsList, issuesList, pullRequestsList);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		

		
		request.getRequestDispatcher("/tables.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
