package com.nt.proxy;

import com.nt.commands.BNKService;

public class BNKServiceProxy implements BNKService {

	@Override
	public String widraw(int acno, float amt) {
		System.out.println("BNKServiceProxy.widraw()-proxy obj");
		return "widrawing "+amt+" from AC"+acno;
	}

}
