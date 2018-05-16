package com.unusual.domain;

import java.util.Date;

public class Feedback {
	private String feedback_id;
	private String content;
	private Date feedback_date;
	public String getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(String feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getFeedback_date() {
		return feedback_date;
	}
	public void setFeedback_date(Date feedback_date) {
		this.feedback_date = feedback_date;
	}
	public String getUnsuaul_event_id() {
		return unsuaul_event_id;
	}
	public void setUnsuaul_event_id(String unsuaul_event_id) {
		this.unsuaul_event_id = unsuaul_event_id;
	}
	private String unsuaul_event_id;
}
