package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class UpdateTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p1=null;
		try {
			ses=HibernateUtil.getSession();
			p1=new Product();
			p1=ses.get(Product.class, 103);
			/*if(p1!=null) {
				tx=ses.beginTransaction();
				p1.setPrice(35000);
				tx.commit();
				System.out.println("record updated");
			}
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("record nod updated");
			e.printStackTrace();
		}*/
	//====================================
	/*	p1=ses.get(Product.class, 102);
				if(p1!=null) {
					p1.setQty(4);
					ses.flush();
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
			p1=ses.load(Product.class, 105);
			System.out.println(p1.getPid()+" "+p1.getPname()+" "+p1.getPrice()+" "+p1.getQty());
			try {
			Thread.sleep(30000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			ses.refresh(p1);//it gives recnt value changed in db it reflect immediately
			System.out.println(p1.getPid()+" "+p1.getPname()+" "+p1.getPrice()+" "+p1.getQty());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();


	}

}
