package com.nt.test;

import com.nt.commands.BNKService;
import com.nt.factory.BNKServiceFactory;

public class ProxyDesignTest {

	public static void main(String[] args) {
		BNKService service=null;
		try {
			service=BNKServiceFactory.getInstance(true);
			System.out.println(service.getClass());
			System.out.println(service.widraw(12345,2000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");
		
		try {
			service=BNKServiceFactory.getInstance(true);
			System.out.println(service.getClass());
			System.out.println(service.widraw(52345,12000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");

		try {
			service=BNKServiceFactory.getInstance(false);
			System.out.println(service.getClass());
			System.out.println(service.widraw(123456,25000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");

		try {
			service=BNKServiceFactory.getInstance(false);
			System.out.println(service.getClass());
			System.out.println(service.widraw(1234985,200055));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");

	}

}
