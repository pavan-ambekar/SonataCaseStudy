package com.sonata.Dao;

import java.util.List;

import com.sonata.mainClasses.Doctor;

public interface DoctorDao {
	public int add(Object object);

	public List<Doctor> getDoc();

	public int delete(Object object);

	public int update(Object object);
}
