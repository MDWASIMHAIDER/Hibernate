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
		Query query=null;
		User user=null;
		Phone phone1=null,phone2=null;
		Set<Phone>phoneset=null;
		int count=0;
		boolean flag=false;
		Transaction tx=null;
		ses=HibernateUtil.getSession();
		user=new User();
		//user.setUserId(2001);
		user.setUname("rahul");
		user.setAddress("tikamanjhi");
		
		phone1=new Phone();
		phone1.setPhone1(555555555l);
		phone1.setNumbertype("love");
		phone1.setProvider("vergin");
		
		phone2=new Phone();
		phone2.setPhone1(666666666l);
		phone2.setNumbertype("personal");
		phone2.setProvider("voda");
		
		phoneset=new HashSet();
		phoneset.add(phone1);
		phoneset.add(phone2);
		user.setPhone(phoneset);
		
		try {
			  //begin Tx
				tx=ses.beginTransaction();
				 ses.save(user);
				 flag=true;
			}//try
			catch(HibernateException he) {
				flag=false;
				he.printStackTrace();
			}
			catch(Exception e) {
				flag=false;
				e.printStackTrace();
			}
			finally {
				if(flag) {
					tx.commit();
					System.out.println("Parent to child objs are saved");
				}
				else {
					tx.rollback();
					System.out.println("Parent to child objs are not saved");
				}
				//close objs
				HibernateUtil.closeSession(ses);
			}//finally

	}

	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<User>userlist=null;
		int count=0;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from User");
		userlist=query.list();
		userlist.forEach(usr->{
			System.out.println(usr);
			Set<Phone>phoneset=null;
			phoneset=usr.getPhone();
			phoneset.forEach(ph->{
				System.out.println(ph);
			});
		});
	}

	@Override
	public void deleteDataUsingParentByUserId(int userId) {
		Session ses=HibernateUtil.getSession();
		Query query=null;
		Transaction tx=null;
		List<User>list=null;
		boolean flag=false;
		try {
		query=ses.createQuery("from User where userId=:id");
		query.setParameter("id", userId);
		list=query.list();
		tx=ses.beginTransaction();
		list.forEach(usr->{
			ses.delete(usr);
			
		});
		flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("obj deleted");
			}
			else{
				tx.rollback();
				System.out.println("obj not deleted");
			}
		}
		HibernateUtil.closeSession(ses);
		
		
	}

	@Override
	public void deleleAllChildsOfAParentByUserId(int userId) {
		Session ses=null;
		User user=null;
		Set<Phone>phoneset=null;
		Transaction tx=null;
		Query query=null;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		try {
			tx=ses.beginTransaction();
			user=ses.load(User.class,userId);
			phoneset=user.getPhone();
			phoneset.clear();
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println("child deleted");
				tx.commit();
			}
			else {
				System.out.println("child not deleted");
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
		}
		
	}

	@Override
	public void deleteOneChildfromCollectionOfChildsBelogingToAParentByUserId(int userId) {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		Set<Phone>phoneset=null;
		Phone phone=null;
		boolean flag=false;
		ses=HibernateUtil.getSession();
		user=ses.get(User.class,userId);
		phoneset=user.getPhone();
		phone=ses.get(Phone.class,555555555L);
		try {
			tx=ses.beginTransaction();
			phoneset.remove(phone);
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("specific child deleted");
			}
			else {
				tx.rollback();
				System.out.println("specific child not deleted");
			}
		}
		HibernateUtil.closeSession(ses);
		
	}

	@Override
	public void saveNewDataToExistingParent() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		User user=null;
		Transaction tx=null;
		user=ses.get(User.class,1);
		Set<Phone>setPhone=user.getPhone();
		Phone ph=new Phone();
		ph.setPhone1(333333333L);
		ph.setNumbertype("night");
		ph.setProvider("airtel");
		try {
			tx=ses.beginTransaction();
			setPhone.add(ph);
			tx.commit();
			System.out.println("new child added");
		}
		catch(Exception e) {
			tx.rollback();
			System.out.println("child not added");
		}
		
	}

}
