package com.sonata.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.Model.Doctor;
import com.sonata.Reoisitory.DoctorRepoisitory;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorRepoisitory dr;
	
	@PostMapping("/updatedetails")
	public int updateDetails(@RequestBody Doctor doc) {
		return dr.updateDeails(doc.getDrID(), doc.getDrName(), doc.getPhoneNumber(), doc.getSpeclization());
	}
}
