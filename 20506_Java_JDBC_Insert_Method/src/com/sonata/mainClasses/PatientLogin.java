package com.sonata.mainClasses;

public class PatientLogin {
	private int patID;
	private String password;

	public int getPatID() {
		return patID;
	}

	public void setPatID(int patID) {
		this.patID = patID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PatientLogin [patID=" + patID + ", password=" + password + "]";
	}

}
