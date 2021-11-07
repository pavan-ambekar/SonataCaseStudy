package com.sonata.Dao;

import java.util.List;

import com.sonata.mainClasses.Diseases;

public interface DiseasesDao {
	public int add(Object object);

	public List<Diseases> getDis();

	public int delete(Object object);

	public int update(Object object);
}
