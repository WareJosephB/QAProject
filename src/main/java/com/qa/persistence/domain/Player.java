package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	public Player(String name) {
		
		this.ELO = 1500;
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double ELO;
	private String name;

	public double getELO() {
		return this.ELO;
	}

	public String getName() {
		return this.name;
	}
	
	public void updateELO(double ELO) {
		this.ELO += ELO;
	}


	

}
