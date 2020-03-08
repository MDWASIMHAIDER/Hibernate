package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class UpdateProblemForMerze {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Product p=null,p1=null,p2=null;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			//=============
			p=new Product();
			p.setPid(107);
			p.setPname("cup");
			p.setPrice(25);
			p.setQty(12);
			//==================
			p1=new Product();
			/*p1.setPid(107);
			p1.setPname("cup");
			p1.setPrice(25);
			p1.setQty(10);*/
			//===============
			ses.save(p);
			p1.setPid(107);
			p1.setPname("cup");
			p1.setPrice(25);
			p1.setQty(10);
			ses.update(p1);
			//p2=(Product)ses.merge(p1);
			//System.out.println(p2);
			tx.commit();
			System.out.println(p.hashCode()+" "+p1.hashCode()+" "+p2.hashCode());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
