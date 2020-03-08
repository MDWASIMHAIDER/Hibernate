package com.nt.dao;

public interface UserDAO {
	public void saveData();
	public void  deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(int userId);
}
