package com.unusual.domain;

import java.util.Date;

public class PullRequests {
	private String pull_request_id;
	private String issue_id;
	private String comment_number;
	private String repository_idp;
	private String title;
	private String body;
	private Date pull_request_date;
	private String repository_name;
	
	
	public String getPull_request_id() {
		return pull_request_id;
	}
	public void setPull_request_id(String pull_request_id) {
		this.pull_request_id = pull_request_id;
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
	public String getRepository_idp() {
		return repository_idp;
	}
	public void setRepository_idp(String repository_idp) {
		this.repository_idp = repository_idp;
	}
	public String getRepository_name() {
		return repository_name;
	}
	public void setRepository_name(String repository_name) {
		this.repository_name = repository_name;
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
	public Date getPull_request_date() {
		return pull_request_date;
	}
	public void setPull_request_date(Date pull_request_date) {
		this.pull_request_date = pull_request_date;
	}
}
