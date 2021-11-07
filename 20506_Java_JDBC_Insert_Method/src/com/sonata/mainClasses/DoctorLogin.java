package com.sonata.mainClasses;

public class DoctorLogin {
	private int drID;
	private String password;

	public int getDrID() {
		return drID;
	}

	public void setDrID(int drID) {
		this.drID = drID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DoctorLogin [drID=" + drID + ", password=" + password + "]";
	}

}
