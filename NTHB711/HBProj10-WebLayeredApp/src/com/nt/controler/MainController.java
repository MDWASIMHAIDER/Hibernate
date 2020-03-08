package com.nt.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.ProjectDTO;
import com.nt.service.ProjectManagementService;
import com.nt.service.ProjectManagementServiceImpl;


public class MainController extends HttpServlet {
	private ProjectManagementService service=null;

	@Override
	public void init() throws ServletException {
		service=new ProjectManagementServiceImpl();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pid=0;
		ProjectDTO dto=null;
		RequestDispatcher rd=null;
		pid=Integer.parseInt(req.getParameter("pid"));
		dto=service.searchProjectById(pid);
		System.out.println("controller get dto obj");
		req.setAttribute("pdetails", dto);
		rd=req.getRequestDispatcher("/result.jsp");
		rd.forward(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

	@Override
	public void destroy() {
		service=null;
	}
	
	
	
}
