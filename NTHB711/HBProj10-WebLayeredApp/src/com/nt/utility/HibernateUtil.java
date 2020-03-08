/*package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private  static  ThreadLocal<Session> threadLocal=new ThreadLocal();	
	
	static {
		Configuration cfg=null;
		try {
		 //Boot strap Hibernate
			cfg=new Configuration();
		    cfg.configure("/com/nt/confg/hibernate.cfg.xml");
		    System.out.println("cfg.configure()");
		 //create SessionFactory
			
			System.out.println("buildsessionfactory");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	static {
		try {
		Configuration cfg=null;
		cfg=new Configuration();
		cfg.configure("com/nt/confg/hibernate.cfg.xml");
		System.out.println("configure");
		factory=cfg.buildSessionFactory();
		if(factory!=null)
			System.out.println("factory got value");
		}
		catch(Exception e) {
			System.out.println("static try exception");
			e.printStackTrace();
		}
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
			if(threadlocal.get()==null) {
				ses=factory.openSession();
				threadlocal.set(ses);
			}
			ses=threadlocal.get();
		}
		return ses;
	}
	public   static  Session  getSession() {
		Session ses=null;
		//System.out.println("getsession()");
		if(factory!=null) {
			System.out.println("getsession()");
			if(threadLocal.get()==null) {
				System.out.println("threadlocal cond");
				ses=factory.openSession();
				threadLocal.set(ses);
			}
			ses=threadLocal.get();
			if(ses==null)
				System.out.println("sese got from threadlocal");
		}
		return ses;
	}

	public static void closeSession() {
		Session ses=null;
		if(threadLocal.get()!=null) {
			ses=threadLocal.get();
			ses.close();
			threadLocal.remove();
		}
	}
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}	
*/
package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static  SessionFactory factory;
	private  static  ThreadLocal<Session> threadLocal=new ThreadLocal();
	
	static {
		
		try {
			Configuration cfg=null;
		 //Boot strap Hibernate
			cfg=new Configuration();
		    cfg.configure("/com/nt/confg/hibernate.cfg.xml");
		 //create SessionFactory
		    System.out.println("after config in static block");
			factory=cfg.buildSessionFactory();
			System.out.println("after buildsessionfactory");
			if(factory!=null) {
				System.out.println("after builssessionf");
			}
		}
		catch(Exception e) {
			System.out.println("static exception");
			e.printStackTrace();
		}
	}//static
	
	//create Session obj on 1 per thread basis (one per related persitence operations)
	public   static  Session  getSession() {
		 Session ses=null;
		if(factory!=null) {
			if(threadLocal.get()==null) {
				ses=factory.openSession();
				threadLocal.set(ses);
				System.out.println("getsession if()");
			}
			ses=threadLocal.get();
		}
		System.out.println("before return");
		return ses;
	}
	
	//close Session
	public   static  void  closeSession() {
		Session ses=null;
		if(threadLocal.get()!=null) {
			ses=threadLocal.get();
			ses.close();
			threadLocal.remove();
		}
	}
	
	public  static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
 
}
