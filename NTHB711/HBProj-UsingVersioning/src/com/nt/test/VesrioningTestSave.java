package com.nt.test;

import com.nt.dao.AirtelCallerTuneDAO;
import com.nt.factory.AirtelCallerTuneFactory;
import com.nt.factory.AirtelCallerTuneFactoryImpl;

public class VesrioningTestSave {
	public static void main(String[] args) {
		AirtelCallerTuneFactory factory=null;
		factory=new AirtelCallerTuneFactoryImpl();
			
		AirtelCallerTuneDAO dao=factory.getInstance();
		dao.saveObject();
	}
}
