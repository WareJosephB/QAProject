package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Game {

	public Game() {

	}

	public Game(List<Score> scores) {
		this.scores = scores;
	}

	public Game(int map, boolean P, boolean C, boolean V, int generations, List<Score> scores) {
		this.scores = scores;
		this.map = map;
		this.P = P;
		this.C = C;
		this.V = V;
		this.generations = generations;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gameid")
	private long id;

	private boolean P;
	private boolean C;
	private boolean V;
	private int generations;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ElementCollection(targetClass = Score.class)
	@OrderColumn
	private List<Score> scores;
	private int map;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ElementCollection(targetClass = Colony.class)
	@OrderColumn
	private List<Colony> colonies;

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

	public List<Score> returnScores() {
		return this.scores;
	}

	public int returnNumPlayers() {
		return this.scores.size();
	}

	public void changeAddons(boolean P, boolean C, boolean V) {
		this.P = P;
		this.C = C;
		this.V = V;
	}

	public void changeMap(int map) {
		this.map = map;
	}

	public void changeScores(List<Score> scores) {
		this.scores = scores;
	}

	public void changeGenerations(int generations) {
		this.generations = generations;
	}

	public int getMap() {
		return map;
	}

	public long getID() {
		return this.id;
	}

	public void removeScore(Score score) {
		this.scores.remove(score);
	}

	public void addScore(Score score) {
		this.scores.add(score);
	}

}
