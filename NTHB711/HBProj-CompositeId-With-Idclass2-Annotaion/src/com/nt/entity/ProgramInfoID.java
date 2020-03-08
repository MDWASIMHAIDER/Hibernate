package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data//for auto generate setter getter etc
@Embeddable//here this tells that is is going to embed in doamin class
public class ProgramInfoID implements Serializable{//serializable is mandatory
	private int programmer_id;
	private int proj_id;
	
}
