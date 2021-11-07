package com.sonata.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Diseases {

	@Id
	@SequenceGenerator(name = "diseases_sequence", sequenceName = "diseases_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diseases_sequence")
	private Long disID;
	private String disName;


	
	public Long getDisID() {
		return disID;
	}

	public void setDisID(Long disID) {
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
