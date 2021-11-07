package com.sonata.Reoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sonata.Model.Patient;

@Repository
public interface PatientReoisitory extends JpaRepository<Patient, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE patient SET age = :age, blood_group = :bloodGroup, name = :name, phone_number = :phoneNumber, sex = :sex  WHERE patid = :id", nativeQuery = true)
	int updateDeails(Long id, int age, String bloodGroup, String name, String phoneNumber, String sex);

}
