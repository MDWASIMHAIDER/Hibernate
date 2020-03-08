package com.nt.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	private String houseNo;
	private String street;
	private String area;
	private int pin;
}
