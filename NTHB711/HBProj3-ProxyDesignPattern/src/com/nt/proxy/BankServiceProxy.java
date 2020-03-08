package com.nt.proxy;

import com.nt.command.BankService;
import com.nt.command.BankServiceImpl;

public class BankServiceProxy implements BankService {

	BankService service;
	public BankServiceProxy() {
		service=new BankServiceImpl();
	}
	@Override
	public String widrawal(int acno, float amt) {
		System.out.println("BankServiceFactory widrawal()-proxy");
		String result=null;
		if(amt<=200000) {
			result=service.widrawal(acno, amt);
		}
		else 
			throw new IllegalArgumentException("200000 is more go and get the permission");
		return result;
	}

}
