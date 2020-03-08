package com.nt.test;

import com.nt.dao.UserDAO;
import com.nt.dao.UserDAOImpl;

public class One_To_One_Test {

	public static void main(String[] args) {
		UserDAO dao=null;
		dao=new UserDAOImpl();
		//dao.saveData();
		//dao.loadDataUsingParent();
		//dao.deleteDataUsingParentByUserId(3);
		//dao.deleleAllChildsOfAParentByUserId(4);
		//dao.deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(5);
		dao.saveNewDataToExistingParent();
	}

}
