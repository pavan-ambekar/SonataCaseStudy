package com.sonata.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Slot {
	@Id
	@SequenceGenerator(name = "slot_sequence", sequenceName = "slot_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slot_sequence")
	private Long slotID;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "dr_id", referencedColumnName = "drID")
	private Doctor doctor;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "pat_id", referencedColumnName = "patID")
	private Patient patient;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "dis_id", referencedColumnName = "disID")
	private Diseases diseases;
	private Date date;
	private Time startTime;
	private Time endTime;

	public Long getSlotID() {
		return slotID;
	}

	public void setSlotID(Long slotID) {
		this.slotID = slotID;
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

	public Diseases getDiseases() {
		return diseases;
	}

	public void setDiseases(Diseases diseases) {
		this.diseases = diseases;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Slot [slotID=" + slotID + ", doctor=" + doctor + ", patient=" + patient + ", diseases=" + diseases
				+ ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
