package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.business.service.Calculable;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;
import com.qa.persistence.domain.SimpleGame;
import com.qa.util.JSONUtil;

@Alternative
public class PlayerLocRepository implements PlayerRepositoriable {

	private static HashMap<Long, Player> players = new HashMap<Long, Player>();

	@Inject
	private JSONUtil util;

	@Inject
	private static Calculable calc;

	private static long ID = 1;

	public static ArrayList<Player> getPlayers(ArrayList<Score> scores) {
		ArrayList<Player> gamePlayers = new ArrayList<Player>();
		for (Score score : scores) {
			gamePlayers.add(players.get(score.getPlayerID()));
		}
		return gamePlayers;
	}

	@Override
	public String getAll() {
		Player[] thePlayers = players.entrySet().toArray(new Player[0]);
		return util.getJSONForObject(thePlayers);
	}

	@Override
	public String add(Player player) {
		players.put(ID, player);
		return "{\"message\": \"Player added successfully. ID number is " + ID + "\"}";
	}

	@Override
	public String delete(Long id) {
		if (players.get(id) != null) {
			players.remove(id);
			return "{\"message\": \"Player deleted successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		if (players.get(id) != null) {
			return util.getJSONForObject(players.get(id));
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	public static Player getPlayer(Long id) {
		return players.get(id);
	}

	@Override
	public String update(Long id, Player player) {
		Player player1 = players.get(id);
		if (player1 != null) {
			player1.setName(player.getName());
			return "{\"message\": \"Player updated successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}

	}

	public static String update(SimpleGame simpleGame) {
		calc.simpleELO(players.get(simpleGame.getPlayer1()), players.get(simpleGame.getPlayer2()));
		return "{\"message\": \"ELOs updated.\"}";
	}

}
