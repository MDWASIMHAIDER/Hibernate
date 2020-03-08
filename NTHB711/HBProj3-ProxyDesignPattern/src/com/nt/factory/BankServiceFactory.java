package com.nt.factory;

import com.nt.command.BankService;
import com.nt.command.BankServiceImpl;
import com.nt.proxy.BankServiceProxy;

public class BankServiceFactory {

	
	public static BankService getInstance(boolean rbiMonotoring) {
	    BankService service;
		if(rbiMonotoring) {
			return service=new BankServiceProxy();
		}
		else {
			return service=new BankServiceImpl();
		}
	}
}
