package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import com.sonata.Dao.DiseasesDao;
import com.sonata.mainClasses.Diseases;

public class DiseasesDaoImpl implements DiseasesDao {
	int row = 0;
	DbConnection db = new DbConnection();
	Diseases dis = null;

	@Override
	public int add(Object object) {
		try {
			dis = (Diseases) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addDiseases(?,?)}");
			cs.setInt(1, dis.getDisID());
			cs.setString(2, dis.getDisName());
			row = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Diseases> getDis() {
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
