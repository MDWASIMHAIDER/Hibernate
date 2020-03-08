package com.nt.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private int userId;
	private String uname;
	private String address;
	private List<Phone>phone;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", addrs=" + address + "]";
	}
	
	
}
