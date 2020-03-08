package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class UpdateTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p1=null;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//using commint() method
			/*p1=new Product();
			p1.setPid(102);
			p1.setPname("daimond");
			p1.setPrice(120000);
			p1.setQty(2);
			ses.update(p1);
			tx.commit();
			System.out.println("record updated");
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("record not updated");
			e.printStackTrace();
		}*/
			//===========================================
			//using flush() method
			p1=new Product();
			p1.setPid(102);
			p1.setPname("daimond");
			p1.setPrice(220000);
			p1.setQty(1);
			ses.update(p1);
			ses.flush();
			System.out.println("record updated");
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("record not updated");
			e.printStackTrace();
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
