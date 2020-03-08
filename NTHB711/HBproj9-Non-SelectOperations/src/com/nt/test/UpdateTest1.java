package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class UpdateTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p1=null;
		try {
			ses=HibernateUtil.getSession();
			p1=new Product();
			p1=ses.get(Product.class, 103);
			if(p1!=null) {
				tx=ses.beginTransaction();
				ses.update(p1);
				tx.commit();
				System.out.println("record updated");
			}
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("record nod updated");
			e.printStackTrace();
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();

	}

}
