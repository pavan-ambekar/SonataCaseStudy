package com.sonata.mainClasses;

public class Diseases {
	private int disID;
	private String disName;

	public int getDisID() {
		return disID;
	}

	public void setDisID(int disID) {
		this.disID = disID;
	}

	public String getDisName() {
		return disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

	@Override
	public String toString() {
		return "Diseases [disID=" + disID + ", disName=" + disName + "]";
	}

}
