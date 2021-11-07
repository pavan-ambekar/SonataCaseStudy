package com.sonata.Reoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonata.Model.DoctorLogin;

@Repository
public interface DoctorLoginRepoisitory extends JpaRepository<DoctorLogin, Long> {
	
	@Query(
			value = "SELECT dl.password FROM doctor_login dl LEFT JOIN doctor d ON d.drid = dl.dr_id WHERE d.e_mail = :email",
			nativeQuery = true
			
			)
	String getPass(String email);
	

}
