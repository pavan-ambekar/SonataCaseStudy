package com.sonata.Reoisitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sonata.Model.Doctor;
import com.sonata.Model.Patient;
import com.sonata.Model.PatientFeedback;

@Repository
public interface PatientFeedbackRepoisitory extends JpaRepository<PatientFeedback, Long> {
	List<PatientFeedback> findByDoctor(Doctor doctor);
	List<PatientFeedback> findByPatient(Patient patient);
	@Modifying
	@Transactional
	@Query(value = "UPDATE patient_feedback SET feedback = :feedback WHERE feedbackid = :id", nativeQuery = true)
	int updatefb(Long id, String feedback);
}
