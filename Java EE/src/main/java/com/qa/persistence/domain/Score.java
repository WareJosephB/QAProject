package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Score {

	public Score() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scoreid")
	private long id;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "playerid")
	private Player player;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "preludeid")
	private List<Prelude> preludes;
	private int score;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "colonyid")
	private List<Colony> colonies;
	private int place;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "corpid")
	private Corporation corporation;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "awardid")
	private List<Awards> awardsWon;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "awardid")
	private List<Awards> awardsSecond;

	public List<Awards> getAwardsWon() {
		return awardsWon;
	}

	public void setAwardsWon(List<Awards> awardsWon) {
		this.awardsWon = awardsWon;
	}

	public List<Awards> getAwardsSecond() {
		return awardsSecond;
	}

	public void setAwardsSecond(List<Awards> awardsSecond) {
		this.awardsSecond = awardsSecond;
	}

	public List<Prelude> getPreludes() {
		return preludes;
	}

	public void setPreludes(List<Prelude> preludes) {
		this.preludes = preludes;
	}

	public List<Colony> getColonies() {
		return colonies;
	}

	public void setColonies(List<Colony> colonies) {
		this.colonies = colonies;
	}

	public long getId() {
		return this.id;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}

	public Score(int place, Player player, int score) {
		this.place = place;
		this.player = player;
		this.score = score;
	}

	public long getID() {
		return this.id;
	}

	public long getPlayerID() {
		return this.player.getID();
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public Corporation getCorporation() {
		return corporation;
	}

	public void setCorporation(Corporation corporation) {
		this.corporation = corporation;
	}

}
