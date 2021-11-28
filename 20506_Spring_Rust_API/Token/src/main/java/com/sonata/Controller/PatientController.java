package com.sonata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.Model.Patient;
import com.sonata.Reoisitory.PatientReoisitory;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientReoisitory pr;

	@PostMapping("/updatedetails")
	public int updateDetails(@RequestBody Patient p) {
		return pr.updateDeails(p.getPatID(), p.getAge(), p.getBloodGroup(), p.getName(), p.getPhoneNumber(),
				p.getSex());
	}
	
	@PostMapping("/info")
	public Patient getInfo(@RequestBody Patient p) {
		return pr.findByeMail(p.geteMail());
	}
}
