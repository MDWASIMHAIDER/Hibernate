package com.nt.entity;

import java.io.Serializable;


public class ProgramInfo  implements Serializable{
	
	private String progrmr_name;
	private String proj_name;
	private float salary;
	private ProgramInfoID inf;
	public String getProgrmr_name() {
		return progrmr_name;
	}
	public void setProgrmr_name(String progrmr_name) {
		this.progrmr_name = progrmr_name;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public ProgramInfoID getInf() {
		return inf;
	}
	public void setInf(ProgramInfoID inf) {
		this.inf = inf;
	}
	
	}
