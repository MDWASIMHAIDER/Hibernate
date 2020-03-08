package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null;
		int idval=0;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			p=new Product();
			p.setPid(106);
			p.setPname("glass");
			p.setPrice(200);
			p.setQty(6);
			ses.saveOrUpdate(p);
			tx.commit();
			System.out.println("object updated/save");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
