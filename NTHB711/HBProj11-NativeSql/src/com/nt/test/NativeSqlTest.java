package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class NativeSqlTest {

	public static void main(String[] args) {
		Session ses=null;
		List<Object[]>list1=null;
		List<Employee>list=null;
		ses=HibernateUtil.getSession();
		NativeQuery query=null;
		query=ses.getNamedNativeQuery("GET_EMP_BY_DESG");
		query.setParameter("desg1","manager");
		query.setParameter("desg2","Bank-po");
		query.addEntity(Employee.class);
		list=query.list();
		list.forEach(li->{
			
				System.out.println(li);
			
		});
		
	}

}
