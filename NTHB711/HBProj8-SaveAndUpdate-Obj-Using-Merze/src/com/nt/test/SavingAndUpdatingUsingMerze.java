package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.StudentDetail;
import com.nt.utility.HibernateUtil;

public class SavingAndUpdatingUsingMerze {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		StudentDetail st1,st2=null;
		ses=HibernateUtil.getSession();
		tx=ses.beginTransaction();
		st1=new StudentDetail();
		st1.setsRoll(113);
		st1.setsAddress("patna");
		st1.setsContact(88733323l);
		st1.setsName("rajkumariya");
		//====================================================
		/*StudentDetail st2=(StudentDetail)ses.merge(st1);
		//System.out.println(st2);
		//StudentDetail st=ses.load(StudentDetail.class, 110);
		st2.setsName("neeraz");
		ses.update(st2);
		System.out.println(st2.getsAddress()+" "+st2.getsName()+" "+st2.getsRoll()+" "+st1.hashCode()+" "+st2.hashCode());
		*/		
		//===================================================
		st2=new StudentDetail();
		st2.setsRoll(113);
		st2.setsName("rahul");
		st2.setsContact(700420453l);
		st2.setsAddress("kolkata");
		ses.save(st1);//here both save and update working on same 
		ses.update(st2);//criteria value so they get exception 
		                //nonuniqueobj exception
		StudentDetail st=(StudentDetail)ses.merge(st2);//merze st2 changes with st1 and return same obj
		//System.out.println(st.getsName()+" "+st.getsRoll()+" "+st.getsAddress()+" "+st.getsContact());
		tx.commit();

	}

}
