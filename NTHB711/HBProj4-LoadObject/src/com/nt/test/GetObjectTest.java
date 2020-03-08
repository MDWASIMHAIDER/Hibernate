package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class GetObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null;
		ses=HibernateUtil.getSession();
		try {
			policy=ses.get(InsurancePolicy.class,1003);
			//System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+" "+policy.getCompany()+" "+policy.getInitialAmount());
		}
		catch(Exception e) {
			System.out.println("object not found");
			e.printStackTrace();
			
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
				
		}
		

	}

}
