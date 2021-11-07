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
public class Patient {
	@Id
	@SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
	private Long patID;
	private String name;
	private int age;
	private String sex;
	@Column(nullable = false)
	private String eMail;
	private String phoneNumber;
	private String bloodGroup;

	public Long getPatID() {
		return patID;
	}

	public void setPatID(Long patID) {
		this.patID = patID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "Patient [patID=" + patID + ", name=" + name + ", age=" + age + ", sex=" + sex + ", eMail=" + eMail
				+ ", phoneNumber=" + phoneNumber + ", bloodGroup=" + bloodGroup + "]";
	}

}
