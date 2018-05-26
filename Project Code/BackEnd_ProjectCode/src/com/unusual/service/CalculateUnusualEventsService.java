package com.unusual.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.websocket.OnError;

import com.unusual.dao.CalculateUnusualEventsDao;
import com.unusual.domain.Commits;
import com.unusual.domain.Events;
import com.unusual.domain.Issues;
import com.unusual.domain.IssuesHistory;
import com.unusual.domain.PullRequests;

import javafx.beans.binding.When;

public class CalculateUnusualEventsService {
	CalculateUnusualEventsDao dao = new CalculateUnusualEventsDao();
	public List<Commits> getCommitsList(String repository_id) throws SQLException {
		
		return dao.getCommitsList(repository_id);
	}

	public List<Issues> getIssuesList(String repository_id) throws SQLException {
		return dao.getIssuesList(repository_id);
	}

	public List<PullRequests> getPullRequestsList(String repository_id) throws SQLException {
		
		return dao.getPullRequestsList(repository_id);
	}
	

	public void deleteEventByRepositoryId(String repository_id) throws SQLException {
		dao.deleteEventByRepositoryId(repository_id);
		
	}
	
	public List<Events> calculate(List<Commits> commits,List<Issues> issues,List<PullRequests> pullrequests)
	{
		List<Events> events = null;
		int[] added=new int[commits.size()];
		int[] deleted=new int[commits.size()];
		int[] modify=new int[commits.size()];
		int[] pullrequestcomment=new int[pullrequests.size()];
		int[] index=new int[3];//index[0]:Q1;	index[1]:Q3;	index[2]:3*IQR.
		long[] days=new long[1000];
		
		
		for(int i=0;i<commits.size();i++)
		{
			added[i] = Integer.parseInt(commits.get(i).getLines_added());
			deleted[i] = Integer.parseInt(commits.get(i).getLines_deleted());
			modify[i] = added[i] + deleted[i];
		}
		
		for(int i=0;i<issues.size();i++)
		{
			for(int j=0;j<issues.size()-1;j++)
			{
				Date date1 = issues.get(j).getDate();
				Date date2 = issues.get(j+1).getDate();
				days[j] = (date1.getTime()-date2.getTime())/(24*60*60*1000)>0 ? (date1.getTime()-date2.getTime())/(24*60*60*1000): 
					   (date2.getTime()-date1.getTime())/(24*60*60*1000); 		
			}
			String label=issues.get(i).getIssue_label();
			//later
		}
		
		
		
		for(int i=0;i<pullrequests.size();i++)
		{
			pullrequestcomment[i]= Integer.parseInt(pullrequests.get(i).getComment_number());
		}
		
		
		index = getthreevalue(added);
		for(int i=0;i<commits.size();i++)
		{
			if(Integer.parseInt(commits.get(i).getLines_added())<index[0]-index[2]||
					Integer.parseInt(commits.get(i).getLines_added())>index[1]+index[2])
			{
				Events newEvents = null;			  
				newEvents.setUnusual_event_id(UUID.randomUUID().toString().replace("-", ""));
				newEvents.setEvent_name_idf("6");
				newEvents.setDetail(commits.get(i).getLines_added()+" lines code have been added.");
				newEvents.setHappened_date(commits.get(i).getCommit_date());
				newEvents.setUser_id(commits.get(i).getUser_id());
				newEvents.setRepository_idf(commits.get(i).getRepository_id());
				newEvents.setCommit_idf(commits.get(i).getCommit_id());
				events.add(newEvents);
			}
		}
		index = getthreevalue(deleted);
		for(int i=0;i<commits.size();i++)
		{
			if(Integer.parseInt(commits.get(i).getLines_deleted())<index[0]-index[2]||
					Integer.parseInt(commits.get(i).getLines_deleted())>index[1]+index[2])
			{
				Events newEvents = null;			  
				newEvents.setUnusual_event_id(UUID.randomUUID().toString().replace("-", ""));
				newEvents.setEvent_name_idf("5");
				newEvents.setDetail(commits.get(i).getLines_deleted()+" lines code have been deleted.");
				newEvents.setHappened_date(commits.get(i).getCommit_date());
				newEvents.setUser_id(commits.get(i).getUser_id());
				newEvents.setRepository_idf(commits.get(i).getRepository_id());
				newEvents.setCommit_idf(commits.get(i).getCommit_id());
				events.add(newEvents);
			}
		}
		index = getthreevalue(modify);
		for(int i=0;i<commits.size();i++)
		{
			if(modify[i]<index[0]-index[2]||modify[i]>index[1]+index[2])
			{
				Events newEvents = null;			  
				newEvents.setUnusual_event_id(UUID.randomUUID().toString().replace("-", ""));
				newEvents.setEvent_name_idf("1");
				newEvents.setDetail(modify[i]+" lines code have been modified.");
				newEvents.setHappened_date(commits.get(i).getCommit_date());
				newEvents.setUser_id(commits.get(i).getUser_id());
				newEvents.setRepository_idf(commits.get(i).getRepository_id());
				newEvents.setCommit_idf(commits.get(i).getCommit_id());
				events.add(newEvents);
			}
		}
		index = getthreevalue(pullrequestcomment);
		for(int i=0;i<pullrequests.size();i++)
		{
			if(Integer.parseInt(pullrequests.get(i).getComment_number())<index[0]-index[2]||
					Integer.parseInt(pullrequests.get(i).getComment_number())>index[1]+index[2])
			{
				Events newEvents = null;			  
				newEvents.setUnusual_event_id(UUID.randomUUID().toString().replace("-", ""));
				newEvents.setEvent_name_idf("2");
				newEvents.setDetail("This pull request have "+pullrequests.get(i).getComment_number()+" comments.");
				newEvents.setHappened_date(pullrequests.get(i).getPull_request_date());
				newEvents.setUser_id(pullrequests.get(i).getUser_id());
				newEvents.setRepository_idf(pullrequests.get(i).getRepository_id());
				newEvents.setPull_request_idf(pullrequests.get(i).getPull_request_id());
				events.add(newEvents);
			}
		}
		
		return events;
		
	}
	public int[] getthreevalue(int[] arr)
	{
		int []index=new int[3];
		Arrays.sort(arr);
		index[0]=arr[(int) (arr.length*0.25)];
		index[1]=arr[(int) (arr.length*0.75)];
		index[2]=3*(index[1]-index[0]);
		return index;
	}

	

}
