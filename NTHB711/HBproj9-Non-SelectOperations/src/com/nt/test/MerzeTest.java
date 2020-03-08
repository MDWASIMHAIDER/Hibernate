package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class MerzeTest {
	public static void main(String[] args) {
		Session ses=null;
		Product p=null,p1=null;;
		Transaction tx=null;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			p=new Product();
			p.setPid(105);
			p.setPname("laptop");
			p.setPrice(450000);
			p.setQty(2);
			p1=(Product)ses.merge(p);//here obj data inserted/updated because of merze()
			System.out.println(p1.getPid()+" "+p1.getPname()+" "+p1.getPrice()+" "+p1.getQty());
			tx.commit();
			System.out.println("object inseted/updated");
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("object not inserted/updated");
			e.printStackTrace();
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}
}
