package com.nt.entity;

import lombok.Data;

@Data
public class Customer extends Person {
	private String address;
	private float billAmount;
}
