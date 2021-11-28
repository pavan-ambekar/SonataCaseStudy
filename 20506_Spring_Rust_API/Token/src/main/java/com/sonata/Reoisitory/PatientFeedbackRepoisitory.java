package com.sonata.Reoisitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonata.Model.PatientFeedback;
import com.sonata.Model.Slot;

@Repository
public interface PatientFeedbackRepoisitory extends JpaRepository<PatientFeedback, Long> {
	
	List<PatientFeedback> findBySlot(Slot slot);
	
	@Query(value = "SELECT p.* FROM patient_feedback p LEFT JOIN Slot s ON p.solt_id = s.slotid WHERE s.dr_id = :id ORDER BY s.date DESC", nativeQuery = true)
	List<PatientFeedback> findByDoc(Long id);

	@Query(value = "SELECT p.* FROM patient_feedback p LEFT JOIN Slot s ON p.solt_id = s.slotid WHERE s.pat_id = :id ORDER BY s.date DESC", nativeQuery = true)
	List<PatientFeedback> findByPat(Long id);
}
