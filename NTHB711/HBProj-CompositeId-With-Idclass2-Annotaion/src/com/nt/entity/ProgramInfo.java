package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="PROGRAMMERS_PROJECT")
public class ProgramInfo  implements Serializable{
	@Column(name="PROGRMR_NAME")
	@Type(type="string")
	private String progrmr_name;
	
	@Column(name="PROJ_NAME")
	@Type(type="string")
	private String proj_name;
	
	@Column(name="SALARY")
	@Type(type="float")
	private float salary;
	
	@EmbeddedId//here this property attached to the int this domain 
	private ProgramInfoID inf;
	
	}
