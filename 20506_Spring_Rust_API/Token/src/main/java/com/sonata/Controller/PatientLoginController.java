package com.sonata.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.Model.PatientLogin;
import com.sonata.Reoisitory.PatientLoginRepoisitory;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patient")
public class PatientLoginController {
	
	@Autowired
	private PatientLoginRepoisitory patLogRepo;
	
	@GetMapping("/show")
	public List<PatientLogin> showAll(){
		return patLogRepo.findAll();
	}
	
	@PostMapping("/add")
	public PatientLogin add(@RequestBody PatientLogin p1) {
		return patLogRepo.save(p1);
	}
	
	@PostMapping("/getpassword")
	public String getPassword(@RequestBody String s) {
		return patLogRepo.getPass(s);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PatientLogin> delete(@PathVariable Long id) {
		patLogRepo.deleteById(id);
		return ResponseEntity.status(200).build();
	}

}
