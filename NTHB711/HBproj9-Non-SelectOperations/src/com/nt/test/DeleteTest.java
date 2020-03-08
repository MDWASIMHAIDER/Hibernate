package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class DeleteTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		ses=HibernateUtil.getSession();
		p=new Product();
		//p=ses.load(Product.class, 102);
		p.setPid(102);
		try {
		tx=ses.beginTransaction();
		ses.delete(p);
		tx.commit();
		System.out.println("object not deleted");
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("object not deleted");
		}
		//ses.flush();

	}

}
