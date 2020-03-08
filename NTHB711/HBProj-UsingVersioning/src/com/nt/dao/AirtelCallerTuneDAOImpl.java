package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.AirtelCallerTune;
import com.nt.utility.HIbernateUtil;

public class AirtelCallerTuneDAOImpl implements AirtelCallerTuneDAO {

	Session ses;
	Transaction tx;
	AirtelCallerTune tune;
	boolean flag=false;
	@Override
	public void saveObject() {
		
		
		try {
			System.out.println("b getsession");
		ses=HIbernateUtil.getSession();
		if(ses==null)
		System.out.println("af getsession");
		tune=new AirtelCallerTune();
		tune.setCustId(1001);
	    tune.setCustName("wasim");
	    tune.setMobileNo(9473442689l);
	    tune.setCallerTune("whre nw");
	    tx=ses.beginTransaction();
	    if(tx==null)
	    	System.out.println("tx nill");
	    ses.save(tune);
	    flag=true;
		}//try
		catch(Exception e) {
			flag=false;
			System.out.println("catch");
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
		}
		HIbernateUtil.closeSession(ses);

	}

	@Override
	public AirtelCallerTune loadAndUpdate() {
		Session ses=null;
		HIbernateUtil.getSession();
		AirtelCallerTune tune=null;
		tune=new AirtelCallerTune();
		tune=ses.load(AirtelCallerTune.class, 1001);
		HIbernateUtil.closeSession(ses);
		return tune;
	}
}
