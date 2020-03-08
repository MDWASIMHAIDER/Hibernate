package com.nt.test;


import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SavingTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		Employee emp=null;
		boolean flag=false;
		cfg=new Configuration();
		cfg.configure("com/nt/confg/Employee.cfg.xml");
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		emp=new Employee();
		emp.setName("haider ali");
		emp.setEno(2044);
		emp.setDesg("programmer");
		emp.setSalary(150000);
		try {
			tx=(Transaction) ses.beginTransaction();
			ses.save(emp);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			 //perform Tx Mgmt
			 if(flag) {
				 tx.commit();
				 System.out.println("Object is saved");
			 }
			 else {
				 tx.rollback();
				 System.out.println("Object is rolleback");
			 }
			 //close HB ses,SessionFactory objs
			 ses.close();
			 factory.close();
		 }//finally 
		
	}

}
