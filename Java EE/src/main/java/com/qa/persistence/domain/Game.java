package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	public Game(Score[] scores) {
		this.scores = scores;
	}
	
	public Game(int map, boolean P, boolean C, boolean V, int generations, Score[] scores) {
		this.scores = scores;
		this.map = map;
		this.P = P;
		this.C = C;
		this.V = V;
		this.generations = generations;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean P;
	private boolean C;
	private boolean V;
	private int generations;
	private Score[] scores;
	private int map;

	public boolean returnP() {
		return this.P;
	}

	public boolean returnC() {
		return this.C;
	}

	public boolean returnV() {
		return this.V;
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

	public void changeAddons(boolean P, boolean C, boolean V) {
		this.P = P;
		this.C = C;
		this.V = V;
	}

	public void changeMap(int map) {
		this.map = map;
	}
	
	public void changeScores(Score[] scores) {
		this.scores = scores;
	}

	public void changeGenerations(int generations) {
		this.generations = generations;
	}

	public int getMap() {
		return map;
	}


}
