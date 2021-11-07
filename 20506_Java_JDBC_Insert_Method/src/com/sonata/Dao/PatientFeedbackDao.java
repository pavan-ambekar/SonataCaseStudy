package com.sonata.Dao;

import java.util.List;

import com.sonata.mainClasses.PatientFeedback;

public interface PatientFeedbackDao {
	public int add(Object object);

	public List<PatientFeedback> getFeedback();
}
