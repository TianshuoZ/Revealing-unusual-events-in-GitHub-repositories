package com.unusual.domain;

import java.util.Date;

public class Repository {
	private String repository_id;
	private String repository_name;
	private String commit_number;
	private String pull_request_number;
	private String issue_number;
	private String user_id;
	private Date create_date;
	public String getRepository_id() {
		return repository_id;
	}
	public void setRepository_id(String repository_id) {
		this.repository_id = repository_id;
	}
	public String getRepository_name() {
		return repository_name;
	}
	public void setRepository_name(String repository_name) {
		this.repository_name = repository_name;
	}
	public String getCommit_number() {
		return commit_number;
	}
	public void setCommit_number(String commit_number) {
		this.commit_number = commit_number;
	}
	public String getPull_request_number() {
		return pull_request_number;
	}
	public void setPull_request_number(String pull_request_number) {
		this.pull_request_number = pull_request_number;
	}
	public String getIssue_number() {
		return issue_number;
	}
	public void setIssue_number(String issue_number) {
		this.issue_number = issue_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}
