package com.nt.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee extends Person {
	private String desg;
	private float salary;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+desg+" "+salary;
	}
}
