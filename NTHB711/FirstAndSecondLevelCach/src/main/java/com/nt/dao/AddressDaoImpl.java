package com.nt.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Address;
import com.nt.utility.HibernateUtil;
import com.sun.org.apache.xml.internal.resolver.readers.XCatalogReader;

public class AddressDaoImpl implements AddressDao {

	@Override
	public void saveData(){
		Session ses=null;
		Transaction tx=null;
		Address address=null;
		ses=HibernateUtil.getSession();
		
		boolean flag=false;
		address=new Address();
		try {
			address.setArea("Khanjarpur");
			address.setHouseNo(126);
			address.setPin(812001);
			address.setStreet("Tilkamanjhi");
			ses.save(address);
			tx=(Transaction) ses.beginTransaction();
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(tx!=null) {
				tx.commit();
				System.out.println("object saved");
			}
			else {
				tx.rollback();
				System.out.println("not saved");
			}
		}
		
	}
	
	public void getAddressData() {
		Session ses2=null,ses1=null;
		Transaction tx1=null,tx2=null;
		ses2=HibernateUtil.getSession();
		ses1=HibernateUtil.getSession();
		Address address = ses1.get(Address.class, 1);
		tx1=ses1.beginTransaction();
		tx1.commit();
		ses1.close();
		Address address1 = ses2.get(Address.class, 1);
		tx2=ses2.beginTransaction();
		tx2.commit();
		ses2.close();
		System.out.println(address);
		System.out.println(address1);
		//return address;
	}

}
