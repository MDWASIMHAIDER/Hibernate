package com.nt.test;

import com.nt.dao.UserDAO;
import com.nt.dao.UserDAOImpl;

public class One_To_many_Test {

	public static void main(String[] args) {
		UserDAO dao=null;
		dao=new UserDAOImpl();
		//dao.saveData();
		dao.deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(1);
	}

}
