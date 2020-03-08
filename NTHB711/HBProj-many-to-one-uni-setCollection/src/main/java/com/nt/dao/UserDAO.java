package com.nt.dao;

public interface UserDAO {
	public void saveData();
	public void loadDataUsingParent();
	public void addNewPhoneToExistingUser(int userid);
	public void deleteChildObjWithoutDeletingParentUsingHQL(long id);
}
