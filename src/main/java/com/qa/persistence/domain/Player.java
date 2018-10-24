package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	public Player(String name) {
		
		this.ELOW = 1500;
		this.ELOP = 1500;
		this.ELOC = 1500;
		this.ELOPC = 1500;
		this.ELO_C = 1500;
		this.ELO_P = 1500;
		this.ELO_PC = 1500;
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double ELOW;
	private double ELOP;
	private double ELOC;
	private double ELO_P;
	private double ELO_C;
	private double ELOPC;
	private double ELO_PC;
	private String name;

	public double[] returnELOs() {

		double[] k = { this.ELOW, this.ELOC, this.ELOP, this.ELOPC, this.ELO_C, this.ELO_P, this.ELO_PC };
		return k;
	}

	public String returnName() {
		return this.name;
	}

	public double returnELOW() {
		return this.ELOW;
	}

	public double returnELOP() {
		return this.ELOP;
	}

	public double returnELOC() {
		return this.ELOC;
	}

	public double returnELOPC() {
		return this.ELOPC;
	}

	public double returnELO_P() {
		return this.ELO_P;
	}

	public double returnELO_C() {
		return this.ELO_C;
	}

	public double returnELO_PC() {
		return this.ELO_PC;
	}
	
	public void updateELO(double[] ELOs) {
		this.ELOW = ELOs[0];
		this.ELOP = ELOs[1];
		this.ELOC = ELOs[2];
		this.ELOPC = ELOs[3];
		this.ELO_P = ELOs[4];
		this.ELO_C = ELOs[5];
		this.ELO_PC = ELOs[6];
	}
	
	

}
