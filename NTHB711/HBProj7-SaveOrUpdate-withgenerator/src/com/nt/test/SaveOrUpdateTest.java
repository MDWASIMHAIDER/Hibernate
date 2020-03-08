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
		st.setsRoll(110);//while not set then generate staleobjexception
		st.setsName("rani raja");//while unsave (val=criteria val) then it choose
		st.setsAddress("bgp noch");//max id val from database and use generator to 
		st.setsContact(8473442677l);//generate nextval and insert the record
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
