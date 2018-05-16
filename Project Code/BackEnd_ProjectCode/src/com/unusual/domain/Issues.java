package com.unusual.domain;

import java.util.Date;

public class Issues {
	private String issue_id;
	private String comment_number;
	private Repository repository_id;
	private String title;
	private String body;
	private Date issue_date;
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
	public Repository getRepository_id() {
		return repository_id;
	}
	public void setRepository_id(Repository repository_id) {
		this.repository_id = repository_id;
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
	private String issue_label;
	
}
