package com.nt.domain;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private int userId;
	private String uname;
	private String address;
	private Map<String,Phone>phone;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", addrs=" + address + "]";
	}
	
	
}
