package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vechile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vid;
	private String type;
	private String model;
	private String company;
	private float price;
	
}
