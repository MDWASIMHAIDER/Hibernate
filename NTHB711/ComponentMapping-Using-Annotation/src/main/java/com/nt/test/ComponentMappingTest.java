package com.nt.test;

import java.util.List;

import com.nt.dao.PersomDetailDaoImpl;
import com.nt.dao.PersonDetailDAO;
import com.nt.entity.PersonDetail;

public class ComponentMappingTest {
	public static void main(String[] args) {
	 PersonDetailDAO dao=null;
	 dao=new PersomDetailDaoImpl();
	 dao.saveData();
	 List<PersonDetail>list=null,list1=null;
	
	 /*list=dao.loadDataByStreet();
	list.forEach(p->{
		System.out.println(p);
	});*/
	
	 list1=dao.getAllDetail();
	list1.forEach(p1->{
		System.out.println(p1);
	});
}
}
