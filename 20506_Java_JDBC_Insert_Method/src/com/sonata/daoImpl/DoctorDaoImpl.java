package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import com.sonata.Dao.DoctorDao;
import com.sonata.mainClasses.Doctor;

public class DoctorDaoImpl implements DoctorDao {
	int row = 0;
	DbConnection db = new DbConnection();
	Doctor doc = null;

	@Override
	public int add(Object object) {
		try {
			doc = (Doctor) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addDoctor(?,?,?,?,?)}");
			cs.setInt(1, doc.getDrID());
			cs.setString(2, doc.getDrName());
			cs.setString(3, doc.getSpeclization());
			cs.setString(4, doc.geteMail());
			cs.setString(5, doc.getPhoneNumber());
			row = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Doctor> getDoc() {
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
