package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.StudentDetail;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		StudentDetail st=null;
		boolean b=false;
		Transaction tx=null;
		cfg=new Configuration();
		cfg.configure("com/nt/confg/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		ses=factory.openSession();
		st=new StudentDetail();
		st.setsRoll(102);
		st.setsName("wasim haider");
		st.setsAddress("khanjar");
		st.setsContact(9473442689l);
		tx=ses.beginTransaction();
		try {
		ses.saveOrUpdate(st);
		b=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(b) {
				tx.commit();
			}
			else {
				tx.rollback();
			}
		}
		

	}

}
