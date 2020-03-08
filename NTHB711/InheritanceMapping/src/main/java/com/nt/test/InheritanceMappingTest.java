package com.nt.test;

import java.util.List;

import com.nt.dao.InheritanceDAO;
import com.nt.dao.InheritanceDAOImpl;
import com.nt.entity.Customer;
import com.nt.entity.Employee;


public class InheritanceMappingTest {

	public static void main(String[] args) {
		InheritanceDAO dao=null;
		List<Employee>list=null;
		List<Customer>list1=null;
		try {
			dao=new InheritanceDAOImpl();
		//System.out.println(dao.saveData());
		list=dao.loadDataUsingEmployee();
		list.forEach(p->{
			System.out.println(p.getCompany()+" "+p.getId()+" "+p.getName()+" "+p.getDesg()+" "+p.getName()+" "+p.getSalary());
		});
		
		System.out.println("=================================");
		
		list1=dao.loadDataUsingCustomer();
		list1.forEach(c->{
			System.out.println(c.getId()+" "+c.getName()+" "+c.getCompany()+" "+c.getAddress()+" "+c.getBillAmount());
		});
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
