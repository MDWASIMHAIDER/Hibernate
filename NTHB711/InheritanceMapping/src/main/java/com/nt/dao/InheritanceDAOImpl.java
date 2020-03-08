package com.nt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class InheritanceDAOImpl implements InheritanceDAO {

	public String saveData() throws Exception {
		Session ses=null;
		Employee emp=null;
		Customer cust=null;
		Person per=null;
		Transaction tx=null;
		boolean flag=false;
		String resMsg=null;
		ses=HibernateUtil.getSession();
		try {
			per=new Person();
			per.setId(2001);
			per.setName("rahul");
			per.setCompany("odless");
			
			emp=new Employee();
			emp.setCompany("AutoMobile");
			emp.setId(3001);
			emp.setName("wasim");
			emp.setDesg("sr-soft");
			emp.setSalary(25000);
			
			cust=new Customer();
			cust.setName("bharat");
			cust.setBillAmount(213.0f);
			cust.setAddress("bihar");
			cust.setCompany("food");
			//ses.save(emp);
			//ses.save(per);
			ses.save(cust);
			tx=ses.beginTransaction();
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				resMsg="object saved successfully";
			}
			else {
				tx.rollback();
				resMsg="object not saved";
			}
		}
		
		return resMsg;
	}

	public List<Employee> loadDataUsingEmployee() throws Exception {
		Session ses=null;
		List<Employee>list=null;
		Query query=null;
		ses=HibernateUtil.getSession();
		try {
			query=ses.createQuery("from Employee");
			list=query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Customer> loadDataUsingCustomer() throws Exception {
		Session ses=null;
		List<Customer>list=null;
		Query query=null;
		ses=HibernateUtil.getSession();
		try {
			query=ses.createQuery("from Customer");
			list=query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
