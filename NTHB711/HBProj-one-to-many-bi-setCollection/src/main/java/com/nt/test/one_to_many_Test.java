package com.nt.test;

import com.nt.dao.UserDAO;
import com.nt.dao.UserDAOImpl;

public class one_to_many_Test {

	public static void main(String[] args) {
		UserDAO dao=null;
		dao=new UserDAOImpl();
		//dao.saveDataUsingChild();
		//dao.saveDataUsingParent();
		//dao.loadDataUsingParent();
		dao.loadDataUsingChild();
	}

}
