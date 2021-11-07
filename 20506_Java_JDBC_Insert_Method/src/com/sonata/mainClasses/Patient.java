package com.sonata.mainClasses;

public class Patient {
	private int patID;
	private String name;
	private int age;
	private String sex;
	private String eMail;
	private String phoneNumber;
	private String bloodGroup;

	public int getPatID() {
		return patID;
	}

	public void setPatID(int patID) {
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
		return "Paitent [patID=" + patID + ", name=" + name + ", age=" + age + ", sex=" + sex + ", eMail=" + eMail
				+ ", phoneNumber=" + phoneNumber + ", bloodGroup=" + bloodGroup + "]";
	}

}
