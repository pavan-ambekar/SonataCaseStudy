package com.sonata.mainClasses;

public class Doctor {
	private int drID;
	private String drName;
	private String speclization;
	private String eMail;
	private String phoneNumber;

	public int getDrID() {
		return drID;
	}

	public void setDrID(int drID) {
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
