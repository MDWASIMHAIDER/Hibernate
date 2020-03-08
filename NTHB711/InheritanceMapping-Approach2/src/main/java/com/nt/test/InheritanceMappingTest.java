package com.nt.test;

import java.util.List;

import com.nt.dao.InheritanceDAO;
import com.nt.dao.InheritanceDAOImpl;
import com.nt.entity.Employee;


public class InheritanceMappingTest {

	public static void main(String[] args) throws Exception {
		InheritanceDAO dao=null;
		dao=new InheritanceDAOImpl();
		//System.out.println(dao.saveData());
		List<Employee>list=null;
		dao.loadDataUsingEmployee();
		list=dao.loadDataUsingEmployee();
		list.forEach(emp->{
			System.out.println(emp);
		});
	}
}
