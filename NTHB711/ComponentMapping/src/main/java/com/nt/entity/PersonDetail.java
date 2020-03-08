package com.nt.entity;

import lombok.Data;

@Data
public class PersonDetail {
	private int pid;
	private String pname;
	private int age;
	private Address addrs;
}
