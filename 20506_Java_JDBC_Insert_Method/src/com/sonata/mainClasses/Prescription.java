package com.sonata.mainClasses;

public class Prescription {
	private int slotID;
	private String prescription;

	public int getSlotID() {
		return slotID;
	}

	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Prescription [slotID=" + slotID + ", prescription=" + prescription + "]";
	}

}
