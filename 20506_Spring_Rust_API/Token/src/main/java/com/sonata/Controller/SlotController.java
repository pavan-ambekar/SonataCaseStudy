package com.sonata.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.Model.Doctor;
import com.sonata.Model.Patient;
import com.sonata.Model.Slot;
import com.sonata.Reoisitory.SlotRepoisitory;

@RestController
@RequestMapping("/slot")
public class SlotController {
	
	@Autowired
	private SlotRepoisitory sr;
	
	@GetMapping("/show")
	public List<Slot> showAll(){
		return sr.findAll();
	}
	
	@PostMapping("/add")
	public Slot add(@RequestBody Slot s) {
		return sr.save(s);
	}
	
	@PostMapping("/bydoc")
	public List<Slot> byDoc(@RequestBody Doctor doc){
		return sr.findByDoctor(doc);
	}
	
	@PostMapping("/bypat")
	public List<Slot> byPat(@RequestBody Patient p){
		return sr.findByPatient(p);
	}

	@PostMapping("/bydocanddate")
	public List<Slot> byDocAndDate(@RequestBody Slot s){
		return sr.findByDoctorAndDate(s.getDoctor(), s.getDate());
	}
	
	@PostMapping("/bypatanddate")
	public List<Slot> byPatAndDate(@RequestBody Slot s){
		return sr.findByPatientAndDate(s.getPatient(), s.getDate());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Slot> delete(@PathVariable Long id) {
		sr.deleteById(id);
		return ResponseEntity.status(200).build();
	}
	
}
