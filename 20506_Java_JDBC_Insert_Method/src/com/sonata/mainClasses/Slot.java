package com.sonata.mainClasses;

import java.sql.Date;
import java.sql.Time;

public class Slot {
	private int slotID;
	private int drID;
	private int patID;
	private int disID;
	private Date date;
	private Time startTime;
	private Time endTime;

	public int getSlotID() {
		return slotID;
	}

	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}

	public int getDrID() {
		return drID;
	}

	public void setDrID(int drID) {
		this.drID = drID;
	}

	public int getPatID() {
		return patID;
	}

	public void setPatID(int patID) {
		this.patID = patID;
	}

	public int getDisID() {
		return disID;
	}

	public void setDisID(int disID) {
		this.disID = disID;
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
		return "Slot [slotID=" + slotID + ", drID=" + drID + ", patID=" + patID + ", disID=" + disID + ", date=" + date
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
