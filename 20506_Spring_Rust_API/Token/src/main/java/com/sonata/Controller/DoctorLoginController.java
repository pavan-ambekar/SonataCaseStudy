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

import com.sonata.Model.DoctorLogin;
import com.sonata.Reoisitory.DoctorLoginRepoisitory;

@RestController
@RequestMapping("doctor")
public class DoctorLoginController {

	@Autowired
	private DoctorLoginRepoisitory docLogRepo;

	@GetMapping("/show")
	public List<DoctorLogin> showAll() {
		return docLogRepo.findAll();
	}

	@PostMapping("/add")
	public DoctorLogin add(@RequestBody DoctorLogin dl) {
		return docLogRepo.save(dl);
	}

	@PostMapping("/getpassword")
	public String getPassword(@RequestBody String s) {
		return docLogRepo.getPass(s);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DoctorLogin> delete(@PathVariable Long id) {
		docLogRepo.deleteById(id);
		return ResponseEntity.status(200).build();
	}

}
