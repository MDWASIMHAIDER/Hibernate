package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.EmployeeFilter;
import com.nt.utility.HibernateUtil;

public class HibernateQBCFilterTest {
	public static void main(String[] args) {
		
		Session ses=null;
		List<EmployeeFilter>list=null;
		Filter filter=null;
		Criteria criteria=null;
		ses=HibernateUtil.getSession();
		filter=ses.enableFilter("HB_FILTER");
		filter.setParameter("min", 1003);
		filter.setParameter("max", 1005);
		criteria=ses.createCriteria(EmployeeFilter.class);
		list=criteria.list();
		list.forEach(e->{
			System.out.println(e.getId()+" "+e.getFname()+" "+e.getLname()+" "+e.getEmail());
		});
		ses.disableFilter("HB_FILTER");
		//to get specific result
		criteria.add(Restrictions.like("fname", "md%"));
		System.out.println("==============================");
		list=criteria.list();
		list.forEach(e->{
			System.out.println(e.getId()+" "+e.getFname()+" "+e.getLname()+" "+e.getEmail());
		});
	}
}
