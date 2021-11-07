package com.sonata.main;

import java.sql.Date;
import java.sql.Time;

import com.sonata.daoImpl.DiseasesDaoImpl;
import com.sonata.daoImpl.DoctorDaoImpl;
import com.sonata.daoImpl.DoctorLoginDaoImpl;
import com.sonata.daoImpl.PatientDaoImpl;
import com.sonata.daoImpl.PatientFeedbackDaoImpl;
import com.sonata.daoImpl.PatientLoginDaoImpl;
import com.sonata.daoImpl.PrescriptionDaoImpl;
import com.sonata.daoImpl.SlotDaoImpl;
import com.sonata.mainClasses.Diseases;
import com.sonata.mainClasses.Doctor;
import com.sonata.mainClasses.DoctorLogin;
import com.sonata.mainClasses.Patient;
import com.sonata.mainClasses.PatientFeedback;
import com.sonata.mainClasses.PatientLogin;
import com.sonata.mainClasses.Prescription;
import com.sonata.mainClasses.Slot;

public class TestBean {

	public static void main(String[] args) {
		//Adding Doc
//		DoctorDaoImpl docDao = new DoctorDaoImpl();
//		Doctor d1 = new Doctor();
//		d1.setDrID(124);
//		d1.setDrName("AROW");
//		d1.setSpeclization("MBBS");
//		d1.setPhoneNumber("7887788778");
//		d1.seteMail("dfhj@gml.com");
//		int row = docDao.add(d1);
//		System.out.println(row);
		
		//Adding DocLogin
//		DoctorLoginDaoImpl docLogDao = new DoctorLoginDaoImpl();
//		DoctorLogin dl1 = new DoctorLogin();
//		dl1.setDrID(124);
//		dl1.setPassword("hjhg7887*&");
//		int x = docLogDao.add(dl1);
//		System.out.println(x);
		
		//Adding Pat
//		PatientDaoImpl patDao = new PatientDaoImpl();
//		Patient p1 = new Patient();
//		p1.setPatID(147);
//		p1.setName("Shilpa");
//		p1.seteMail("ghh@hh.com");
//		p1.setPhoneNumber("9876545678");
//		p1.setAge(24);
//		p1.setBloodGroup("A+");
//		p1.setSex("F");
//		int row = patDao.add(p1);
//		System.out.println(row);
		
		//Adding PatLogin
//		PatientLoginDaoImpl patLogDao = new PatientLoginDaoImpl();
//		PatientLogin pl1 = new PatientLogin();
//		pl1.setPatID(147);
//		pl1.setPassword("vgbhnjdvg6");
//		int x = patLogDao.add(pl1);
//		System.out.println(x);
		
		//Adding Dis
//		DiseasesDaoImpl DisDao = new DiseasesDaoImpl();
//		Diseases dis1 = new Diseases();
//		dis1.setDisID(1);
//		dis1.setDisName("EYE BLUR");
//		int x = DisDao.add(dis1);
//		System.out.println(x);
		
		
		// Adding Feedback
//		PatientFeedbackDaoImpl pFBDao = new PatientFeedbackDaoImpl();
//		PatientFeedback fb1 = new PatientFeedback();
//		long millis=System.currentTimeMillis();  
//		fb1.setFeedbackID(01);
//		fb1.setDrID(124);
//		fb1.setPatID(147);
//		fb1.setDate(new Date(millis));
//		fb1.setFeedback("Nice Work");
//		int x = pFBDao.add(fb1);
//		System.out.println(x);
		
		// Adding Slot
//		SlotDaoImpl slotDao = new SlotDaoImpl();
//		Slot s1 = new Slot();
//		long millis=System.currentTimeMillis();  
//		s1.setSlotID(01);
//		s1.setDrID(124);
//		s1.setPatID(147);
//		s1.setDisID(01);
//		s1.setDate(new Date(millis));
//		s1.setStartTime(new Time(millis));
//		s1.setEndTime(new Time(millis + 10000));
//		int x = slotDao.add(s1);
//		System.out.println(x);
		
		// add presc
		PrescriptionDaoImpl presDao = new PrescriptionDaoImpl();
		Prescription p1 = new Prescription();
		p1.setSlotID(01);
		p1.setPrescription("Have Home Food");
		int x = presDao.add(p1);
		System.out.println(x);
		
		
	}

}
