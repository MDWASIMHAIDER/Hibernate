package com.nt.test;



import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nt.entity.Vechile;
import com.nt.utility.HibernateUtil;

public class JPA_Criteri_Test {
	public static void main(String[] args) {
		Session ses=null;
		CriteriaBuilder builder=null;
		Root<Vechile>root=null;
		Query query=null;
		List<Vechile>list=null;
		CriteriaQuery<Vechile>ctQuery=null;
		ParameterExpression<Integer>param1=null;
		ParameterExpression<Integer>param2=null;
		Predicate pdc1=null,pdc2=null,pdc3=null;
		Order order=null;
		ses=HibernateUtil.getSession();
		/*try {
			builder=ses.getCriteriaBuilder();
			ctQuery=builder.createQuery(Vechile.class);
			root=ctQuery.from(Vechile.class);
			ctQuery.select(root);
			query=ses.createQuery(ctQuery);
			list=query.getResultList();
			list.forEach(v->{
				System.out.println(v);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		try {
			builder=ses.getCriteriaBuilder();
			ctQuery=builder.createQuery(Vechile.class);
			root=ctQuery.from(Vechile.class);
			ctQuery.select(root);
			param1=builder.parameter(Integer.class);
			param2=builder.parameter(Integer.class);
			//define predicate obj
			pdc1=builder.ge(root.get("vid"),param1);
			pdc2=builder.le(root.get("vid"),param2);
			pdc3=builder.and(pdc1,pdc2);
			//add predicate obj
			ctQuery.where(pdc3);
			//get order obj
			order=builder.asc(root.get("model"));
			ctQuery.orderBy(order);
			query=ses.createQuery(ctQuery);
			query.setParameter(param1, 1002);
			query.setParameter(param2, 1004);
			list=query.getResultList();
			list.forEach(v->{
				System.out.println(v);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
