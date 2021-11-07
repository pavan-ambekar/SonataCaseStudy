package com.sonata.mainClasses;

import java.sql.Date;

public class PatientFeedback {
	private int feedbackID;
	private int drID;
	private int patID;
	private String feedback;
	private Date date;

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public int getDrID() {
		return drID;
	}

	public void setDrID(int drID) {
		this.drID = drID;
	}

	public int getPatID() {
		return patID;
	}

	public void setPatID(int patID) {
		this.patID = patID;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PatientFeedback [feedbackID=" + feedbackID + ", drID=" + drID + ", patID=" + patID + ", feedback="
				+ feedback + ", date=" + date + "]";
	}

}
