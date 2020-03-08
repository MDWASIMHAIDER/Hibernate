package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory factory;
	static {
		try {
		Configuration cfg=new Configuration();
		//cfg.addResource("com/nt/confg/ProductSupplier.hbm.xml");
		//cfg.configure("com/nt/confg/hibernate.cfg.xml");
		cfg.addFile("src/com/nt/confg/ProductSupplier.hbm.xml");
		//src to find hbm.xml file in class path
		factory=cfg.buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
			ses=factory.openSession();
			
		}
		return ses;
	} 
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}
