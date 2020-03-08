package com.nt.dao;

import java.util.List;

import com.nt.entity.Customer;
import com.nt.entity.Employee;

public interface InheritanceDAO {
	public String saveData()throws Exception;
	public List<Employee>loadDataUsingEmployee()throws Exception;
	public List<Customer>loadDataUsingCustomer()throws Exception;
}
