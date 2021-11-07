package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.sonata.Dao.PatientLoginDao;
import com.sonata.mainClasses.PatientLogin;

public class PatientLoginDaoImpl implements PatientLoginDao {
	int row = 0;
	DbConnection db = new DbConnection();
	PatientLogin PatLogin = null;

	@Override
	public int add(Object object) {
		try {
			PatLogin = (PatientLogin) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addPatientLogin(?,?)}");
			cs.setInt(1, PatLogin.getPatID());
			cs.setString(2, PatLogin.getPassword());
			row = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return row;
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
