package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class ProgrammerPojectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		ProgrammerProjectInfo info=null;
		SessionFactory factory=null;
		boolean flag=false;
		try {
			//ses=HibernateUtil.getSession();
			Configuration cfg=new Configuration();
			cfg.configure("com/nt/confg/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
			ses=factory.openSession();
			
			tx=ses.beginTransaction();
			info=new ProgrammerProjectInfo();
			info.setProgrammer_id(101);
			info.setProj_id(1001);
			info.setProgrmr_name("wasim");
			info.setProj_name("fabication sale");
			info.setSalary(80000);
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
				System.out.println("object saved successfully");
			}
			else {
				tx.rollback();
				System.out.println("object not saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
			

	}

}
