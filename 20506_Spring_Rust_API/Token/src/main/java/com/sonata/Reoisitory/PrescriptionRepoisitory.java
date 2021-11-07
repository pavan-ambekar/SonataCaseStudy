package com.sonata.Reoisitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonata.Model.Prescription;

@Repository
public interface PrescriptionRepoisitory extends JpaRepository<Prescription, Long> {
	
	@Query(
			value = "SELECT p.* FROM prescription p LEFT JOIN Slot s ON p.solt_id = s.slotid WHERE s.dr_id = :id ORDER BY s.date DESC",
			nativeQuery = true
			)
	List<Prescription> findByDoc(Long id);
	
	@Query(
			value = "SELECT p.* FROM prescription p LEFT JOIN Slot s ON p.solt_id = s.slotid WHERE s.pat_id = :id ORDER BY s.date DESC",
			nativeQuery = true
			)
	List<Prescription> findByPat(Long id);
	
	@Query(
			value = "SELECT p.* FROM prescription p LEFT JOIN Slot s ON p.solt_id = s.slotid WHERE s.pat_id = :id AND s.date = :date ORDER BY s.start_time",
			nativeQuery = true
			)
	List<Prescription> findByPatAndDate(Long id, Date date);
	
	@Query(
			value = "SELECT p.* FROM prescription p LEFT JOIN Slot s ON p.solt_id = s.slotid WHERE s.dr_id = :id AND s.date = :date ORDER BY s.start_time",
			nativeQuery = true
			)
	List<Prescription> findByDocAndDate(Long id, Date date);
	
	

}
