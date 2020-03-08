package com.nt.test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class GetObjectTest {

	public static void main(String[] args){
		Transaction tx=null;
		Session ses=null;
		InsurancePolicy policy=null;
		ses=HibernateUtil.getSession();
		try {
		policy=ses.get(InsurancePolicy.class, 1003);//for second approach 1003
		if(policy!=null) {
		System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getCompany()+" "+policy.getTenure()+" "+policy.getInitialAmount());
		System.out.println(policy.getClass());
		}
		else {
			System.out.println("record not found");
		}
		//second apprroach for deleting obj
		/*if(policy!=null) {
			policy.setPolicyId(1003);
			try {
				tx=ses.beginTransaction();
				ses.delete(policy);
				tx.commit();
				System.out.println("record deleted");
			}
			catch(Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
		}
		else {
			System.out.println("record not found");
		}*/
		//record deleting code
		policy.setPolicyId(1002);
		tx=ses.beginTransaction();
		ses.delete(policy);
		System.out.println("object related records are deleted");
		tx.commit();
		
		//updating the record
		/*policy.setPolicyId(1002);
		policy.setInitialAmount(28000);
		policy.setCompany("jeevan");
		policy.setPolicyName("lifecare");
		policy.setTenure(14);
		tx=ses.beginTransaction();
		ses.update(policy);
		tx.commit();*/
		
		//updating approach2
		/*if(policy!=null) {
			policy.setInitialAmount(1100);
			ses.beginTransaction();
			ses.update(policy);
			tx.commit();
		}
		*/
		
		//updating approach 3 here no need of ses.update()
		if(policy!=null){
			try {
				tx=ses.beginTransaction();
				policy.setTenure(30);
				tx.commit();
				System.out.println("modification saved");
			}
			catch(Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		else {
			System.out.println("record not found to update");
		}
		}
		catch(Exception e){
			//tx.rollback();
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
