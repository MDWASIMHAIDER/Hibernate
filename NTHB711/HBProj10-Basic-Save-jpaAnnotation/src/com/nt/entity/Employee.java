package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="EMPLOYEE_DETAIL")
public final class Employee {

	@Type(type="int")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int eid;
	private String ename;
	private String desg;
	private float salary;
	public Employee() {
		System.out.println("employee 0-param constructor");
	}
	public int getEid() {
		return eid;
	}
	
	
	public void setEid(int eid) {
		this.eid = eid;
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
	@Override
	public String toString() {
		return "Employee [eno=" + eid + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + "]";
	}
	

}
