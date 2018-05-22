package com.unusual.domain;

import java.util.Date;

public class Issues {
	private String issue_id;
	private String comment_number;
	private String repository_idi;
	private String repository_name;
	private String title;
	private String body;
	private Date issue_date;
	private String issue_label;
	
	
	public String getRepository_idi() {
		return repository_idi;
	}
	public void setRepository_idi(String repository_idi) {
		this.repository_idi = repository_idi;
	}
	public String getRepository_name() {
		return repository_name;
	}
	public void setRepository_name(String repository_name) {
		this.repository_name = repository_name;
	}
	public String getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}
	public String getComment_number() {
		return comment_number;
	}
	public void setComment_number(String comment_number) {
		this.comment_number = comment_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
	public String getIssue_label() {
		return issue_label;
	}
	public void setIssue_label(String issue_label) {
		this.issue_label = issue_label;
	}

	
}
