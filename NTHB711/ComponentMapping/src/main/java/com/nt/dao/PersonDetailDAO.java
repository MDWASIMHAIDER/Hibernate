package com.nt.dao;

import java.util.List;

import com.nt.entity.PersonDetail;

public interface PersonDetailDAO{
	public void saveData(); 
	public List<PersonDetail> loadDataByStreet();
	public List<PersonDetail> getAllDetail();
}
