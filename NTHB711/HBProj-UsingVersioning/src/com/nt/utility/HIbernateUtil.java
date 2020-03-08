package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernateUtil {
	/*static SessionFactory factory;
	
	static {
		try {
		Configuration cfg=new Configuration();
		System.out.println("before configure");
		cfg.configure("com/nt/confg/hibernate.cfg.xml");
		System.out.println("after configure");
		factory=cfg.buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("static block");
		}
	}
	public static Session getSession() {
		Session ses=null;
		System.out.println("getSesion()");
		if(factory!=null)
			ses=factory.openSession();
		if(ses==null)
		System.out.println("opensession()");
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
*/
	
	
	//'''''''''''''''''''''''''''''''''''''
	static SessionFactory factory;
	static{
		try {
			Configuration cfg=null;
			cfg=new Configuration();
			cfg.configure("com/nt/confg/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("static catch");
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
		if(ses!=null) {
			ses.close();
		}
	}
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}

	}
