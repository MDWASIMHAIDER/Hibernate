package com.nt.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.nt.utility.HibernateUtil;

public class SessionManagementListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request Destroyed");
		HibernateUtil.closeSession();
	}
	
}
