package com.nt.entity;

import java.io.Serializable;




public class ProgramInfoID implements Serializable{
	private int programmer_id;
	private int proj_id;
	public int getProgrammer_id() {
		return programmer_id;
	}
	public void setProgrammer_id(int programmer_id) {
		this.programmer_id = programmer_id;
	}
	public int getProj_id() {
		return proj_id;
	}
	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}
}
