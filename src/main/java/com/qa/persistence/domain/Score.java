package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score {
	
	private Score() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Player player;
	private int score;
	private int place;

	public double getELO() {
		return this.player.getELO();
	}

	public Player getPlayer() {
		return this.player;
	}

	public int getScore() {
		return this.score;
	}

	public Score(int place, Player player, int score) {
		this.place = place;
		this.player = player;
		this.score = score;
	}

	public int getPlace() {
		return this.place;
	}



}
