package com.sonata.Model;

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
public class DoctorLogin {
	
	@Id
	@SequenceGenerator(name = "doctor_login_sequence", sequenceName = "doctor_login_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_login_sequence")
	private Long docLogID;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "dr_id", referencedColumnName = "drID")
	private Doctor doc;
	private String password;

	public Doctor getDoctor() {
		return doc;
	}

	public void setDoctor(Doctor doctor) {
		this.doc = doctor;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DoctorLogin [doctor=" + doc + ", password=" + password + "]";
	}

}
