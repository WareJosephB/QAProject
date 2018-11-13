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
		// TODO Auto-generated method stub
		return null;
	}

	public String add(String player) {
		Player newPlayer = util.getObjectForJSON(player, Player.class);
		players.put(ID, newPlayer);
		return "{\"message\": \"Player added successfully.\"}";
	}

	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
