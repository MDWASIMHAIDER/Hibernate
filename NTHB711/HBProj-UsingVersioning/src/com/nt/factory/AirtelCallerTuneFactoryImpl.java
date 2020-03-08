package com.nt.factory;

import com.nt.dao.AirtelCallerTuneDAO;
import com.nt.dao.AirtelCallerTuneDAOImpl;

public class AirtelCallerTuneFactoryImpl implements AirtelCallerTuneFactory {

	@Override
	public AirtelCallerTuneDAO getInstance() {
		AirtelCallerTuneDAO dao=new AirtelCallerTuneDAOImpl();
		return dao;
	}

}
