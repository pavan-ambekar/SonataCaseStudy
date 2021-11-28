package com.sonata.Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PatientFeedback {
	@Id
	@SequenceGenerator(name = "feedback_sequence", sequenceName = "feedback_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_sequence")
	private Long feedbackID;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "solt_id", referencedColumnName = "slotID")
	private Slot slot;
	
	private String feedback;
	private Date date;
	public Long getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
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
		return "PatientFeedback [feedbackID=" + feedbackID + ", slot=" + slot + ", feedback=" + feedback + ", date="
				+ date + "]";
	}



}
