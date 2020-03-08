package com.nt.dao;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.domain.Phone;
import com.nt.domain.User;
import com.nt.utillity.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	public void saveData() {
		Session ses=null;
		Phone phone1=null,phone2=null;
		User user=null;
		boolean flag=false;
		Transaction tx=null;
		
		user=new User();
		user.setUname("wasim");
		//user.setUserId(1001);
		user.setAddress("bhagalpur");
		
		phone1=new Phone();
		phone1.setNumbertype("personal");
		phone1.setPhoneNumber(98756435l);
		phone1.setProvider("jio");
		phone1.setUser(user);
		
		phone2=new Phone();
		phone2.setNumbertype("office");
		phone2.setPhoneNumber(77777777l);
		phone2.setProvider("airtel");
		phone2.setUser(user);
		
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			ses.save(phone1);
			ses.save(phone2);
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("child to parent objs are saved");
		}
			else {
				tx.rollback();
				System.out.println("objs are not saved");
			}
			}
		
		
		
		
	}

	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<Phone>phonelist=null;
		int count=0;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from Phone");
		phonelist=query.list();
		phonelist.forEach(usr->{
			System.out.println(usr);
			User phoneset=null;
			phoneset=usr.getUser();
			//phoneset.forEach(ph->{
				System.out.println(phoneset);//because only one parent is associated to many childs 
			//});
		});
	}

	@Override
	public void addNewPhoneToExistingUser(int userid) {
		Session ses=null;
		User user=null;
		Phone phone=null;
		Transaction tx=null;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		user=ses.load(User.class, userid);
		phone=new Phone();
		phone.setNumbertype("love");
		phone.setPhoneNumber(1111111100L);
		phone.setProvider("docomo");
		phone.setUser(user);
		try {
			tx=ses.beginTransaction();
			ses.save(phone);
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("new child added to existing parent");
			}
			else {
				tx.rollback();
				System.out.println("new cild not added");
			}
		}
		
	}

	@Override
	public void deleteChildObjWithoutDeletingParentUsingHQL(long num) {
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		ses=HibernateUtil.getSession();
		query=ses.createQuery("delete from Phone where phoneNumber=:no");
		query.setParameter("no",num);
		try {
			tx=ses.beginTransaction();
			int res=query.executeUpdate();
			System.out.println("before commit");
			tx.commit();
			System.out.println("given child deleted");
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("given child not deleted");
		}
	}

	
}
