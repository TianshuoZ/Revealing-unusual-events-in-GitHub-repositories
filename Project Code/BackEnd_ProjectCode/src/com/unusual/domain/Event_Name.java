package com.unusual.domain;

public class Event_Name {
	private String event_name_id;
	private String event_artifact;
	private String event_name;
	private String up_number;
	private String down_number;
	public String getUp_number() {
		return up_number;
	}
	public void setUp_number(String up_number) {
		this.up_number = up_number;
	}
	public String getDown_number() {
		return down_number;
	}
	public void setDown_number(String down_number) {
		this.down_number = down_number;
	}
	public String getEvent_name_id() {
		return event_name_id;
	}
	public void setEvent_name_id(String event_name_id) {
		this.event_name_id = event_name_id;
	}
	public String getEvent_artifact() {
		return event_artifact;
	}
	public void setEvent_artifact(String event_artifact) {
		this.event_artifact = event_artifact;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	
}
