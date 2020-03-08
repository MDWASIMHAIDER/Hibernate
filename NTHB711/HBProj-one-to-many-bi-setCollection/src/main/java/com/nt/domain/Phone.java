package com.nt.domain;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Phone {
	private long phoneNumber;
	private String numbertype;
	private String provider;
	private User user;
	@Override
	public String toString() {
		return "Phone [phone1=" + phoneNumber + ", numbertype=" + numbertype + ", provider=" + provider + ", userSet="
				+ user + "]";
	}
	
	
	
}
