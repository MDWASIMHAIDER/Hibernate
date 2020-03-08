package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProgramInfo;
import com.nt.entity.ProgramInfoID;
import com.nt.utillity.HibernateUtil;

public class ProgramInfoTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ProgramInfo info=null;
		ProgramInfoID id1=null,idval=null;;
		
		try {
			ses=HibernateUtil.getSession();
			tx=ses.beginTransaction();
			id1=new ProgramInfoID();
			id1.setProgrammer_id(105);
			id1.setProj_id(1006);
			info=new ProgramInfo();
			info.setInf(id1);
			info.setProgrmr_name("prince");
			info.setProj_name("bank");
			info.setSalary(120000);
			idval=(ProgramInfoID)ses.save(info);
			System.out.println("composite pk id "+idval.getProgrammer_id());
			flag=true;
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("object is saved");
			}
			else {
				tx.rollback();
				System.out.println("object not saved");
			}
			ses.close();
		}

	}

}
