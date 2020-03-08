package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Airtel;
import com.nt.utility.HibernateUtil;

public class TimeStampingTest {

	public static void main(String[] args) {	
		Session ses=null;
		Transaction tx=null;
		Airtel airtel=null,airtel1=null;
		boolean flag=false;
		try {
			ses=HibernateUtil.getSession();
			airtel=new Airtel();
			airtel.setCustId(1003);
			airtel.setCustName("wasim haider");
			airtel.setCallertune("idea tune");
			airtel.setMobile(9887856456l);
			ses.save(airtel);
			tx=ses.beginTransaction();
			//airtel1=ses.load(Airtel.class, 1001);
			//airtel1.setCallertune("idea tune");
			//airtel1.setCustName("wasim haider");
			
			//ses.update(airtel1);
			flag=true;
		}//try
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}//catch
		finally {
			if(flag) {
				tx.commit();
				System.out.println("count is" +airtel.getlastUpdate());
				System.out.println("record saved");
			}//if
			else {
				System.out.println("rocord not save");
				tx.rollback();
			}
		}//finally
			
	}

}
