package com.qa.persistence.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	public Player() {
		
	}

	private int numberPlayed;

	public Player(String name) {

		this.ELO = 1500;
		this.name = name;
		this.setNumberPlayed(0);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "playid")
	private long id;
	private double ELO;
	private String name;

	public double getELO() {
		return this.ELO;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void updateELO(double ELO) {
		this.ELO += ELO;
	}

	public String toString() {
		DecimalFormat form = new DecimalFormat("#.00");
		form.setRoundingMode(RoundingMode.DOWN);
		return this.getName() + ": " + String.valueOf(form.format(this.getELO())) + " from " + String.valueOf(this.getNumberPlayed());
	}

	public int getNumberPlayed() {
		return numberPlayed;
	}

	public void setNumberPlayed(int numberPlayed) {
		this.numberPlayed = numberPlayed;
	}

}
