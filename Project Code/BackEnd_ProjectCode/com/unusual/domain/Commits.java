package com.unusual.domain;

import java.util.Date;

public class Commits {
	private String commit_id;
	private String comment_number;
	private String repository_idc;
	private String file_change;
	private String lines_added;
	private String lines_deleted;
	private String lines_modified;
	private Date commit_date;
	private String unusual_event_id;
	private String user_id;
	private String repository_name;

	
	public String getRepository_name() {
		return repository_name;
	}
	public void setRepository_name(String repository_name) {
		this.repository_name = repository_name;
	}
	public String getLines_modified() {
		return lines_modified;
	}
	public void setLines_modified(String lines_modified) {
		this.lines_modified = lines_modified;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCommit_id() {
		return commit_id;
	}
	public void setCommit_id(String commit_id) {
		this.commit_id = commit_id;
	}
	public String getComment_number() {
		return comment_number;
	}
	public void setComment_number(String comment_number) {
		this.comment_number = comment_number;
	}
	
	public String getFile_change() {
		return file_change;
	}
	public void setFile_change(String file_change) {
		this.file_change = file_change;
	}
	public String getLines_added() {
		return lines_added;
	}
	public void setLines_added(String lines_added) {
		this.lines_added = lines_added;
	}
	public String getLines_deleted() {
		return lines_deleted;
	}
	public void setLines_deleted(String lines_deleted) {
		this.lines_deleted = lines_deleted;
	}
	public String getRepository_idc() {
		return repository_idc;
	}
	public void setRepository_idc(String repository_idc) {
		this.repository_idc = repository_idc;
	}
	public Date getCommit_date() {
		return commit_date;
	}
	public void setCommit_date(Date commit_date) {
		this.commit_date = commit_date;
	}
	public String getUnusual_event_id() {
		return unusual_event_id;
	}
	public void setUnusual_event_id(String unusual_event_id) {
		this.unusual_event_id = unusual_event_id;
	}

	
}
