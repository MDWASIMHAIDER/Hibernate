package com.nt.dao;

public interface UserDAO {
	public void saveDataUsingChild();
	public void saveDataUsingParent();
	public void loadDataUsingParent();
	public void loadDataUsingChild();
	/*public void addNewPhoneToExistingUser(int userid);
	public void deleteChildObjWithoutDeletingParentUsingHQL(long id);
*/
	}
