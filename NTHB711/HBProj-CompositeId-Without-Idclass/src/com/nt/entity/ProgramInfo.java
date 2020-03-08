package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProgramInfo  implements Serializable{
	private int programmer_id;
	private int proj_id;
	private String progrmr_name;
	private String proj_name;
	private float salary;

	}
