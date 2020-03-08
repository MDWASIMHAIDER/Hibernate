package com.nt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Address;
import com.nt.entity.PersonDetail;
import com.nt.utility.HibernateUtil;

public class PersomDetailDaoImpl implements PersonDetailDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		PersonDetail pd=null;
		Address addrs1=null;
		ses=HibernateUtil.getSession();
		boolean flag=false;
		try {
		addrs1=new Address();
		addrs1.setArea("bgp");
		addrs1.setHouseNo("14-B1");
		addrs1.setPin(6552);
		addrs1.setStreet("ms lane");
		
		pd=new PersonDetail();
		pd.setAge(25);
		pd.setAddrs(addrs1);
		pd.setPname("gaurav");
		
		ses.save(pd);
		tx=ses.beginTransaction();
		flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object saved successfully");
			}
			else {
				tx.rollback();
				System.out.println("object not saved");
			}
		}
	
		
	}

	@Override
	public List<PersonDetail> loadDataByStreet() {
		Session ses=null;
		Query query=null;
		List<PersonDetail>list=null;
		String street="cp";
		ses=HibernateUtil.getSession();
		try {
			query=ses.createQuery("from PersonDetail where addrs.street=:cp");
			query.setParameter("cp",street);
			list=query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PersonDetail> getAllDetail() {
		Session ses=null;
		List<PersonDetail>list=null;
		Query query=null;
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from PersonDetail");
		list=query.getResultList();
		return list;
	}

}
