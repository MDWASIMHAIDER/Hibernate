package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Vechile;
import com.nt.utility.HibernateUtil;

public class CriteriaApiTest {

	public static void main(String[] args) {
		Session ses=null;
		List<Vechile>list=null;
		ses=HibernateUtil.getSession();
		Criteria criteria=null;
		Criterion cond=null,cond1=null,cond2=null,andCond=null,orCond=null;
		criteria=ses.createCriteria(Vechile.class);
		cond1=Restrictions.in("company", "tata","honda","bajaj");
		cond2=Restrictions.ilike("type", "four-wheeler");
		cond=Restrictions.between("price", 750000.0f,1800000.0f);
		andCond=Restrictions.and(cond, cond1);
		criteria.add(andCond);
		orCond=Restrictions.or(andCond, cond2);
		criteria.add(orCond);
		list=criteria.list();
		list.forEach(v->{
			System.out.println(v);
		});
	}

}
