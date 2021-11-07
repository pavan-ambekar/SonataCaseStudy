package com.sonata.Dao;

import java.util.List;

import com.sonata.mainClasses.Slot;



public interface SlotDao {
	public int add(Object object);

	public List<Slot> getSlot();

	public int delete(Object object);

	public int update(Object object);
}
