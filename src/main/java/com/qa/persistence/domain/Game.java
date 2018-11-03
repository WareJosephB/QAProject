package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	public Game() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean P;
	private boolean C;
	private int generations;
	private Score[] scores;

	public boolean returnP() {
		return this.P;
	}

	public boolean returnC() {
		return this.C;
	}

	public int returnGenerations() {
		return this.generations;
	}

	public Score[] returnScores() {
		return this.scores;
	}
	
	public int returnNumPlayers() {
		return this.scores.length;
	}

}
