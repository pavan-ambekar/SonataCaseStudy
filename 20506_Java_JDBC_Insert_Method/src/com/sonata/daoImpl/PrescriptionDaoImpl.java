package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.sonata.Dao.PrescriptionDao;
import com.sonata.mainClasses.Prescription;

public class PrescriptionDaoImpl implements PrescriptionDao {
	int row = 0;
	DbConnection db = new DbConnection();
	Prescription prescription = null;

	@Override
	public int add(Object object) {
		try {
			prescription = (Prescription) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addPrescription(?,?)}");
			cs.setInt(1, prescription.getSlotID());
			cs.setString(2, prescription.getPrescription());
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

}
