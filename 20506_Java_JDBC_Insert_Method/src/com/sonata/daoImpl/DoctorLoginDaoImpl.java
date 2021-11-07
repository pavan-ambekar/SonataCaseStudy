package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.sonata.Dao.DoctorLoginDao;
import com.sonata.mainClasses.DoctorLogin;

public class DoctorLoginDaoImpl implements DoctorLoginDao {
	int row = 0;
	DbConnection db = new DbConnection();
	DoctorLogin DocLogin = null;

	@Override
	public int add(Object object) {
		try {
			DocLogin = (DoctorLogin) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addDoctorLogin(?,?)}");
			cs.setInt(1, DocLogin.getDrID());
			cs.setString(2, DocLogin.getPassword());
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
