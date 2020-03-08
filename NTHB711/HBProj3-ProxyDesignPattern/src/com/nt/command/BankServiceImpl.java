package com.nt.command;

public class BankServiceImpl implements BankService {

	@Override
	public String widrawal(int acno, float amt) {
		System.out.println("BankServiceImpl.withdraw() (real obj)");
		return "widrawal "+amt+" done by acno "+acno;
	}

}
