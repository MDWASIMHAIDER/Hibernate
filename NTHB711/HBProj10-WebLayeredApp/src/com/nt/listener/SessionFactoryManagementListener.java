package com.nt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.utility.HibernateUtil;

public class SessionFactoryManagementListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context Destroyed");
		HibernateUtil.closeSessionFactory();
	}

}
