package com.sonata.Reoisitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonata.Model.Doctor;
import com.sonata.Model.Patient;
import com.sonata.Model.Slot;

@Repository
public interface SlotRepoisitory extends JpaRepository<Slot, Long> {

	List<Slot> findByDoctor(Doctor doctor);

	List<Slot> findByPatient(Patient patient);

	List<Slot> findByDoctorAndDate(Doctor doctor, Date date);

	List<Slot> findByPatientAndDate(Patient patient, Date date);

}
