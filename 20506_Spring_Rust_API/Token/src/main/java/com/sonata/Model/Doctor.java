package com.sonata.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "eMail", "phoneNumber" }))
public class Doctor {
	@Id
	@SequenceGenerator(name = "doctor_sequence", sequenceName = "doctor_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_sequence")
	private Long drID;
	private String drName;
	private String speclization;
	@Column(nullable = false)
	private String eMail;
	private String phoneNumber;

	public Long getDrID() {
		return drID;
	}

	public void setDrID(Long drID) {
		this.drID = drID;
	}

	public String getDrName() {
		return drName;
	}

	public void setDrName(String drName) {
		this.drName = drName;
	}

	public String getSpeclization() {
		return speclization;
	}

	public void setSpeclization(String speclization) {
		this.speclization = speclization;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Doctor [drID=" + drID + ", drName=" + drName + ", speclization=" + speclization + ", eMail=" + eMail
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
