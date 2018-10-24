package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Player player;
	private int score;

	public String getName() {
		return this.player.returnName();
	}
	
	public Player getPlayer() {
		return this.player;
	}

	public int getScore() {
		return this.score;
	}

	public Score(Player player, int score) {
		this.player = player;
		this.score = score;
	}

}
