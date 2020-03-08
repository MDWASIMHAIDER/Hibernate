package com.nt.factory;

import com.nt.commands.BNKService;
import com.nt.commands.BNKServiceImpl;
import com.nt.proxy.BNKServiceProxy;

public class BNKServiceFactory {

	static BNKService service;
	public static BNKService getInstance(boolean rbiMonitoring) {
		if(rbiMonitoring) {
			service=new BNKServiceImpl();
		}
		else {
			service=new BNKServiceProxy();
		}
		return service;
	}

}
