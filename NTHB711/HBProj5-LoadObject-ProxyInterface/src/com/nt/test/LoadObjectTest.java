package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.IInsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		IInsurancePolicy policy=null;
		ses=HibernateUtil.getSession();
		try {
			policy=ses.load(IInsurancePolicy.class, 1001);
			//wjhile commenting the below line it perfor lazy loading 
			//eventhough doamin class is declared as final
			if(policy!=null) {
				System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getCompany()+" "+policy.getTenure()+" "+policy.getInitialAmount());
			}
			else {
				System.out.println("record not found");
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
