package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.entity.EmployeeFilter;
import com.nt.utility.HibernateUtil;

public class HibernateFilterTest {

	public static void main(String[] args) {
		Session ses=null;
		List<EmployeeFilter>list=null;
		Filter filter=null;
		Query query=null;
		ses=HibernateUtil.getSession();
		filter=ses.enableFilter("HB_FILTER");
		filter.setParameter("min", 1003);
		filter.setParameter("max", 1005);
		query=ses.createQuery("from EmployeeFilter");
		list=query.list();
		System.out.println("Enable time "+list);
		ses.disableFilter("HB_FILTER");
		list=query.list();
		System.out.println("===============================");
		list.forEach(e->{
			System.out.println(e.getId()+" "+e.getFname()+" "+e.getLname()+" "+e.getEmail());
		});
		//System.out.println("After diable "+list);
		

	}

}
