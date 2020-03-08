package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.nt.entity.EmployeeFilter;
import com.nt.utility.HibernateUtil;

public class HibernateNativeSqlFilterTest {

	public static void main(String[] args) {
		Session ses=null;
		List<EmployeeFilter>list=null;
		Query query=null;
		Filter filter=null;
		ses=HibernateUtil.getSession();
		filter=ses.enableFilter("HB_FILTER");
		filter.setParameter("min",1002);
		filter.setParameter("max", 1003);
		query=ses.createSQLQuery("select *from employeefilter");
		((NativeQuery) query).addEntity(EmployeeFilter.class);
		list=query.list();
		list.forEach(e->{
			System.out.println(e.getId()+" "+e.getFname()+" "+e.getLname()+" "+e.getEmail());
		});
		//here filters not applied because of rules filter not applied on native sql 
	}

}
