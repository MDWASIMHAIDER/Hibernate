package com.nt.commands;

public class BNKServiceImpl implements BNKService {

	@Override
	public String widraw(int acno, float amt) {
		System.out.println("Bank service impl widraw()-real obj");
		return "widrawing "+amt+" is taken by AC "+acno;
	}

}
