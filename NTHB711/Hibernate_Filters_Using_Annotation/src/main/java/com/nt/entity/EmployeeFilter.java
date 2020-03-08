package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEEFILTER")
@FilterDef(name="HB_FILTER",parameters= {@ParamDef(name="min",type="int"),@ParamDef(name="max",type="int")})
@Filter(name="HB_FILTER",condition="id>=:min and id<=:max")
public class EmployeeFilter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String fname;
	private String lname;
	private String email;
}
