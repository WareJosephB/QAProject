package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Score {

	public Score() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scoreid")
	private long id;
	@ManyToOne
	@JoinColumn(name="playerid")
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
