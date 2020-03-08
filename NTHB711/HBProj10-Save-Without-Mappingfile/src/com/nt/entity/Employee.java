package com.nt.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="EMPLOYEE_DETAIL")
public final class Employee {

	//@Id
	//@Column(name="EID")
	private int eno;
	
	//@Column(name="ENAME")
	private String ename;
	
	//@Column(name="DESG")
	private String desg;
	
	//@Column(name="salary")
	private float salary;
	public Employee() {
		System.out.println("employee 0-param constructor");
	}
	@Id
	@Column(name="EID")
	@Type(type="int")
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	@Column(name="ENAME")
	@Type(type="string")
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Column(name="DESG")
	@Type(type="string")
	public String getDesg() {
		return desg;
	}
	
	public void setDesg(String desg) {
		this.desg = desg;
	}
	@Column(name="SALARY")
	@Type(type="float")
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + "]";
	}
	

}
