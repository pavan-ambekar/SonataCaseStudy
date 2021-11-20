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

import com.sonata.Model.Doctor;
import com.sonata.Model.Patient;
import com.sonata.Model.Prescription;
import com.sonata.Model.Slot;
import com.sonata.Reoisitory.PrescriptionRepoisitory;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pres")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionRepoisitory presRepo;
	
	@GetMapping("/show")
	public List<Prescription> showAll(){
		return presRepo.findAll();
	}
	
	@PostMapping("/add")
	public Prescription add(@RequestBody Prescription p ) {
		return presRepo.save(p);
	}
	
	@PostMapping("/bydoc")
	public List<Prescription> findByDoc(@RequestBody Doctor doc){
		return presRepo.findByDoc(doc.getDrID());
	}
	
	@PostMapping("/bypat")
	public List<Prescription> findByPat(@RequestBody Patient pat){
		return presRepo.findByDoc(pat.getPatID());
	}
	
	@PostMapping("/bydocanddate")
	public List<Prescription> findByDocAndDate(@RequestBody Slot s){
		return presRepo.findByDocAndDate(s.getDoctor().getDrID(), s.getDate());
	}
	
	@PostMapping("/bypatanddate")
	public List<Prescription> findByPatAndDate(@RequestBody Slot s){
		return presRepo.findByPatAndDate(s.getPatient().getPatID(), s.getDate());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Prescription> delete(@PathVariable Long id) {
		presRepo.deleteById(id);
		return ResponseEntity.status(200).build();
	}
	
}
