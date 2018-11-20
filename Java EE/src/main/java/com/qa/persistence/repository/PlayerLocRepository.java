package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;
import com.qa.util.JSONUtil;

@Alternative
public class PlayerLocRepository implements PlayerRepositoriable {

	private static HashMap<Long, Player> players = new HashMap<Long, Player>();

	@Inject
	private JSONUtil util;

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
	public String add(String player) {
		Player newPlayer = util.getObjectForJSON(player, Player.class);
		players.put(ID, newPlayer);
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
	public String changeName(Long id, String name) {
		Player player = players.get(id);
		if (player != null) {
			player.setName(name);
			return "{\"message\": \"Player updated successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	@Override
	public String update(Long id, String entity) {
		Player player1 = players.get(id);
		Player player2 = util.getObjectForJSON(entity, Player.class);
		if (player1 != null) {
			player1.setName(player2.getName());
			return "{\"message\": \"Player updated successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}

	}

}
