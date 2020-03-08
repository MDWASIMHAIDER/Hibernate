package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class DeleteTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		try{
			ses=HibernateUtil.getSession();
			p=new Product();
			tx=ses.beginTransaction();
			p=ses.load(Product.class, 103);
			if(p!=null) {
				try {
					ses.delete(p);
					tx.commit();
					System.out.println("object deleted");
				}
				catch(Exception e) {
					tx.rollback();
					System.out.println("object  not deleted");
					e.printStackTrace();
				}
			}
			else {
				System.out.println("object not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
