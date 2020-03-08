package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class ProjectDAOImpl implements ProjectDAO{

	@Override
	public Project getProjectById(int pid) {
		Session ses=null;
		Project proj=null;
		ses=HibernateUtil.getSession();
		//ses1=HibernateUtil.getSession();
		//System.out.println(ses1.hashCode()+" "+ses1.hashCode());
		if(ses!=null)
		System.out.println("before ses check");
		
		System.out.println(pid+" daoimpl before get()");
		proj=ses.get(Project.class, pid);
		return proj;
	}

}
