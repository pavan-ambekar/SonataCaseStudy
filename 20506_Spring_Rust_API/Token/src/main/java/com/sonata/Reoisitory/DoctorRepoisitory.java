package com.sonata.Reoisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sonata.Model.Doctor;

@Repository
public interface DoctorRepoisitory extends JpaRepository<Doctor, Long> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE doctor SET dr_name = :name, phone_number=:pNumber, speclization=:spec  WHERE drid = :id", nativeQuery = true)
	int updateDeails(Long id, String name, String pNumber, String spec);
}
