/*package com.nt.test;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args){
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		Employee emp=null;
		boolean flag=false;
		//BootStrap HIbernate
		cfg=new Configuration();
		//locate and read cfg file mapping file
		cfg.configure("com/nt/confg/hibernate.cfg.xml");
		System.out.println("after configure");
		//build session factoryy
		factory=cfg.buildSessionFactory();
		System.out.println("after builsession");
		//open session
		ses=factory.openSession();
		emp=new Employee();
		emp.setEno(101);
		emp.setEname("wasim");
		emp.setDesg("manager");
		emp.setSalary(900000);
		System.out.println("after val set");
		try {
			tx=(Transaction) ses.beginTransaction();
			//System.out.println(ses.getProperties());
			ses.save(emp);
			System.out.println("after save");
			flag=true;
		}
		catch(Exception e) {
			System.out.println("excp bolock");
			flag=false;
		}
	
		finally {
		if(flag) {
			try {
			tx.commit();
			System.out.println("object is saved");
			}catch(Exception e) {}
		}
		else {
			try {
				System.out.println("rollback block");
			tx.rollback();
			System.out.println("object is rollback");
			}catch(Exception e) {
				
			}
		}
		
		//ses.close();
		//factory.close();
	}

	}
}

*/
package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

import com.nt.entity.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		 Configuration cfg=null;
		 SessionFactory factory=null;
		 Session ses=null;
		 Employee emp=null;
		 Transaction tx=null;
		 boolean flag=false;
		//BootStrap Hibernate 
		 cfg=new Configuration();
		 
		 //Locate and read cfg file,mapping files
		 cfg.configure("/com/nt/confg/hibernate.cfg.xml");
		 
		 //build SessionFactory
		 //factory=cfg.buildSessionFactory();
		
		 //another way of creating seesionfactory
		 StandardServiceRegistry regis=new StandardServiceRegistryBuilder().configure("/com/nt/confg/hibernate.cfg.xml").build();
		 factory=cfg.buildSessionFactory(regis);
		 //Open Session
		 ses=factory.openSession();
		 //create Entity class obj with Data
		 emp=new Employee();
		// emp.setEno(1029);
		 emp.setEname("rani");
		 emp.setDesg("jr-eng"); emp.setSalary(55000);
		 try {
			 //begin Transaction
			 tx=ses.beginTransaction();
			 
			 //save object
			Object obj=ses.save(emp);//where obj recieves the identity value like 1016 setEno() serialize
			 System.out.println(obj);
			                                                                          
			 //ses.get()
			 /* emp=(Employee)ses.get(Employee.class, 1016);//typecast is optional
			 System.out.println(emp);*/
			 
			 //ses.load()
			// emp=ses.load(Employee.class,201);
			 //System.out.println(emp);
			 //its also save the obj
			// ses.persist(emp);//where in persist method it cant return anything back to the client void
			 flag=true;
		 }//try
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
	}//main
}//class
