package com.sonata.Dao;

import java.util.List;

import com.sonata.mainClasses.Patient;

public interface PatientDao {
	public int add(Object object);

	public List<Patient> getPat();

	public int delete(Object object);

	public int update(Object object);
}
