package com.nt.entity;

public class StudentDetail {
	private String sName;
	private int sRoll;
	private String sAddress;
	private long sContact;
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsRoll() {
		return sRoll;
	}
	public void setsRoll(int sRoll) {
		this.sRoll = sRoll;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public long getsContact() {
		return sContact;
	}
	public void setsContact(long sContact) {
		this.sContact = sContact;
	}
}
