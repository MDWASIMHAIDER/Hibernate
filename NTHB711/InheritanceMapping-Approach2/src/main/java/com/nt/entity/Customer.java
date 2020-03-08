package com.nt.entity;

import lombok.Data;

@Data
public class Customer extends Person {
	private String address;
	private float billAmount;@Override
	
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+address+" "+billAmount;
	}
	
}
