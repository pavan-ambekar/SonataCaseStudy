package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import com.sonata.Dao.PatientFeedbackDao;
import com.sonata.mainClasses.PatientFeedback;

public class PatientFeedbackDaoImpl implements PatientFeedbackDao {
	int row = 0;
	DbConnection db = new DbConnection();
	PatientFeedback patFB = null;

	@Override
	public int add(Object object) {
		try {
			patFB = (PatientFeedback) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addPaitentFeedback(?,?,?,?,?)}");
			cs.setInt(1, patFB.getFeedbackID());
			cs.setInt(2, patFB.getDrID());
			cs.setInt(3, patFB.getPatID());
			cs.setString(4, patFB.getFeedback());
			cs.setDate(5, patFB.getDate());
			row = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<PatientFeedback> getFeedback() {
		// TODO Auto-generated method stub
		return null;
	}

}
