package com.nt.test;

import com.nt.command.BankService;
import com.nt.factory.BankServiceFactory;

public class ProxyDesignPatternTest {

	public static void main(String[] args) {
		BankService service=null;
		try {
			service=BankServiceFactory.getInstance(true);
			System.out.println(service.getClass());
			System.out.println(service.widrawal(123456, 50000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");
		try {
			service=BankServiceFactory.getInstance(true);
			System.out.println(service.getClass());
			System.out.println(service.widrawal(654321, 30000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");
		try {
			service=BankServiceFactory.getInstance(false);
			System.out.println(service.getClass());
			System.out.println(service.widrawal(908765, 40000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");
		try {
			service=BankServiceFactory.getInstance(false);
			System.out.println(service.getClass());
			System.out.println(service.widrawal(634765, 20000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
