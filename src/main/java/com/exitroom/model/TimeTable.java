package com.exitroom.model;

import java.util.Date;

public class TimeTable {

	private Date date;
	private String time;

	public TimeTable(Date date, String time) {
		this.date = date;
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
