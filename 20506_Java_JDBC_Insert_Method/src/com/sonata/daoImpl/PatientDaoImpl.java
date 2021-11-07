package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import com.sonata.Dao.PatientDao;
import com.sonata.mainClasses.Patient;

public class PatientDaoImpl implements PatientDao {
	int row = 0;
	DbConnection db = new DbConnection();
	Patient pat = null;
	
	@Override
	public int add(Object object) {
		try {
			pat = (Patient) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addPatient(?,?,?,?,?,?,?)}");
			cs.setInt(1, pat.getPatID());
			cs.setString(2, pat.getName());
			cs.setInt(3, pat.getAge());
			cs.setString(4, pat.getSex());
			cs.setString(5, pat.geteMail());
			cs.setString(6, pat.getPhoneNumber());
			cs.setString(7, pat.getBloodGroup());
			row = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Patient> getPat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
