package com.sonata.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import com.sonata.Dao.SlotDao;
import com.sonata.mainClasses.Slot;

public class SlotDaoImpl implements SlotDao {
	int row = 0;
	DbConnection db = new DbConnection();
	Slot slot = null;

	@Override
	public int add(Object object) {
		try {
			slot = (Slot) object;
			CallableStatement cs = db.getConnection().prepareCall("{Call addSlot(?,?,?,?,?,?,?)}");
			cs.setInt(1, slot.getSlotID());
			cs.setInt(2, slot.getDrID());
			cs.setInt(3, slot.getPatID());
			cs.setInt(4, slot.getDisID());
			cs.setDate(5, slot.getDate());
			cs.setTime(6,slot.getStartTime());
			cs.setTime(7,slot.getEndTime());
			row = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Slot> getSlot() {
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
