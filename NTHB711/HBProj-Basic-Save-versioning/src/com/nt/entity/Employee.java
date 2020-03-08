package com.nt.entity;

public final class Employee {

	private int eno;
	private String ename;
	private String desg;
	private float salary;
	private int versioning;
	public Employee() {
		System.out.println("employee 0-param constructor");
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getVersioning() {
		return versioning;
	}
	public void setVersioning(int versioning) {
		this.versioning = versioning;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + "]";
	}
	

}
