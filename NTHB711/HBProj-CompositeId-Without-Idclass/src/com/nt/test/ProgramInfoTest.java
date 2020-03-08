package com.nt.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.ProgramInfo;
import com.nt.utillity.HibernateUtil;

public class ProgramInfoTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ProgramInfo info=null;
		try {
			/*cfg=new Configuration();
			cfg.configure("com/nt/confg/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
			ses=factory.openSession();*/
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			info=new ProgramInfo();
			info.setProgrammer_id(101);
			info.setProj_id(1004);
			info.setProgrmr_name("suraj");
			info.setProj_name("mechinary");
			info.setSalary(150000);
			ses.save(info);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is saved");
			}
			else {
				tx.rollback();
				System.out.println("object not saved");
			}
			ses.close();
		}

	}

}
