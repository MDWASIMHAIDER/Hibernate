package com.nt.service;

import com.nt.dao.ProjectDAO;
import com.nt.dao.ProjectDAOImpl;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;

public class ProjectManagementServiceImpl implements ProjectManagementService {
	ProjectDAO dao;
	public ProjectManagementServiceImpl() {
		dao=new ProjectDAOImpl();
	}
	@Override
	public ProjectDTO searchProjectById(int pid) {
			ProjectDTO dto=null;
			Project proj=null;
			dto=new ProjectDTO();
			proj=dao.getProjectById(pid);
			dto.setProjId(proj.getProjId());
			dto.setDomain(proj.getDomain());
			dto.setProjName(proj.getProjName());
			dto.setSdp(proj.getSdp());
			dto.setTeamSize(proj.getTeamSize());
			dto.setEdcp(proj.getEdcp());
			System.out.println("serviceimpl return dto");
		return dto;
	}

}
