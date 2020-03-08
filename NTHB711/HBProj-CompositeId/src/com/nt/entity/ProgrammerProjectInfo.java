package com.nt.entity;

import lombok.Data;

@Data
public class ProgrammerProjectInfo {
	private int programmer_id;
	private int proj_id;
	private String progrmr_name;
	private String proj_name;
	private float salary;
}
