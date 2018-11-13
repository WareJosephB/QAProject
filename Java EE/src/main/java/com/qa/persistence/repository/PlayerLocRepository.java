package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Player;
import com.qa.util.JSONUtil;

@Alternative
public class PlayerLocRepository implements PlayerRepositoriable {
	
	HashMap<Integer, Player> players = new HashMap<Integer, Player>();

	@Inject
	private JSONUtil util;
	
	private static int ID = 1;
	
	public String getAll() {
		Player[] thePlayers = players.entrySet().toArray(new Player[0]);
		return util.getJSONForObject(thePlayers);
	}

	public String add(String player) {
		Player newPlayer = util.getObjectForJSON(player, Player.class);
		players.put(ID, newPlayer);
		return "{\"message\": \"Player added successfully.\"}";
	}

	public String delete(int id) {
		if (players.get(id) != null) {
			players.remove(id);
			return "{\"message\": \"Player deleted successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	public String get(int id) {
		if (players.get(id) != null) {
			return util.getJSONForObject(players.get(id));
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	@Override
	public String changeName(int id, String name) {
		Player player = players.get(id);
		if (player != null) {
			player.setName(name);
			return "{\"message\": \"Player updated successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

}
