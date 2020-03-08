package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		ses=HibernateUtil.getSession();
		if(ses!=null){System.out.println("ses initialized");}
		else {
			System.out.println("ses not initialized");
		}
		try {
			
			policy=ses.load(InsurancePolicy.class,1002);
			//System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+" "+policy.getCompany()+" "+policy.getInitialAmount());
			//this is then further use of real obj so then it hit the  database
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("object not found");
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
