package com.nt.dao;

public interface UserDAO {
	public void saveData();
	public void loadDataUsingParent();
	public void saveNewDataToExistingParent();
	public void  deleteDataUsingParentByUserId(int userId);
	public void deleleAllChildsOfAParentByUserId(int userId);
	public void  deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(int userId);
}
