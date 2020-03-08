package com.nt.entity;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;



public class Airtel {
	private int custId;
	private String custName;
	private long mobile;
	private String callertune;
	private Timestamp lastUpdate;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public String getCallertune() {
		return callertune;
	}
	public void setCallertune(String callertune) {
		this.callertune = callertune;
	}
	public Timestamp getlastUpdate() {
		return lastUpdate;
	}
	public void setlastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
/*@Entity
@Table(name="AIRTEL")
public class Airtel {
	private int custId;
	private String custName;
	private long mobile;
	private String callertune;
	private int updatecount;
	
	@Id
	@Column(name="CUSTID",length=4)
	@Type(type="int")
	//@GeneratedValue(strategy = GenerationType.AUTO)//it works for sequence creation
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	@Column(name="CUSTNAME",length=15)
	@Type(type="string")
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(name="MOBILE", length=12)
	@Type(type="long")
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	@Column(name="CALLERTUNE",length=15)
	@Type(type="string")
	public String getCallertune() {
		return callertune;
	}
	public void setCallertune(String callertune) {
		this.callertune = callertune;
	}
	@Version
	public int getUpdatecount() {
		return updatecount;
	}
	public void setUpdatecount(int updatecount) {
		this.updatecount = updatecount;
	}

}*/
