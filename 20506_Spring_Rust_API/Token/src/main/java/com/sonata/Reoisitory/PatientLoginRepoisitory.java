package com.sonata.Reoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonata.Model.PatientLogin;

@Repository
public interface PatientLoginRepoisitory extends JpaRepository<PatientLogin, Long> {
	
	@Query(value = "SELECT pl.password FROM patient_login pl LEFT JOIN patient p ON p.patid = pl.pat_id WHERE p.e_mail = :email", nativeQuery = true)
	String getPass(String email);

}
