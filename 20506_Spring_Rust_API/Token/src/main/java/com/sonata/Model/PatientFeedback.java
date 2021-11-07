package com.sonata.Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PatientFeedback {
	@Id
	@SequenceGenerator(name = "feedback_sequence", sequenceName = "feedback_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_sequence")
	private Long feedbackID;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "dr_id", referencedColumnName = "drID")
	private Doctor doctor;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "pat_id", referencedColumnName = "patID")
	
	private Patient patient;
	private String feedback;
	private Date date;

	public Long getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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
		return "PatientFeedback [feedbackID=" + feedbackID + ", doctor=" + doctor + ", patient=" + patient
				+ ", feedback=" + feedback + ", date=" + date + "]";
	}

}
