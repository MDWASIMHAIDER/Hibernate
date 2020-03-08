package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProductSupplier;
import com.nt.utility.HibernateUtil;

public class ProductSupplierTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		ProductSupplier ps=null;
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			ps=new ProductSupplier();
			ps.setPid(1103);
			ps.setPname("Sofa");
			ps.setPrice(15000);
			ps.setQty(1);
			ses.save(ps);
			ses.flush();//withot this also saving is possible
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
