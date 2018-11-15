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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

@Entity
public class Score {

	public Score() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scoreid")
	private long id;
	@ManyToOne
	@JoinColumn(name = "playerid")
	private Player player;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ElementCollection(targetClass = Prelude.class)
	@OrderColumn
	private List<Prelude> preludes;
	private int score;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ElementCollection(targetClass = Colony.class)
	@OrderColumn
	private List<Colony> colonies;

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
		this.player = player;
		this.score = score;
	}

	public long getID() {
		return this.id;
	}

}
