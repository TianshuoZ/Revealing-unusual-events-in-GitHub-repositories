package com.unusual.domain;

import java.util.Date;

public class Events {

	private String unusual_event_id;
	private String event_name_idf;
	private String event_name;
	private String event_artifact;
	private String commit_idf;
	private String detail;
	private Date happened_date;
	private String repository_idf;
	private String user_id;
	private String issue_idf;
	private String pull_request_idf;
	private int up_number;
	private int down_number;
	private String repository_name;
	
	
	public String getRepository_name() {
		return repository_name;
	}
	public void setRepository_name(String repository_name) {
		this.repository_name = repository_name;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_artifact() {
		return event_artifact;
	}
	public void setEvent_artifact(String event_artifact) {
		this.event_artifact = event_artifact;
	}

	public String getUnusual_event_id() {
		return unusual_event_id;
	}
	public void setUnusual_event_id(String unusual_event_id) {
		this.unusual_event_id = unusual_event_id;
	}
	
	public String getEvent_name_idf() {
		return event_name_idf;
	}
	public void setEvent_name_idf(String event_name_idf) {
		this.event_name_idf = event_name_idf;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getHappened_date() {
		return happened_date;
	}
	public void setHappened_date(Date happened_date) {
		this.happened_date = happened_date;
	}	
	public String getCommit_idf() {
		return commit_idf;
	}
	public void setCommit_idf(String commit_idf) {
		this.commit_idf = commit_idf;
	}
	public String getRepository_idf() {
		return repository_idf;
	}
	public void setRepository_idf(String repository_idf) {
		this.repository_idf = repository_idf;
	}
	public String getIssue_idf() {
		return issue_idf;
	}
	public void setIssue_idf(String issue_idf) {
		this.issue_idf = issue_idf;
	}
	public String getPull_request_idf() {
		return pull_request_idf;
	}
	public void setPull_request_idf(String pull_request_idf) {
		this.pull_request_idf = pull_request_idf;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getUp_number() {
		return up_number;
	}
	public void setUp_number(int up_number) {
		this.up_number = up_number;
	}
	public int getDown_number() {
		return down_number;
	}
	public void setDown_number(int down_number) {
		this.down_number = down_number;
	}
	
}
