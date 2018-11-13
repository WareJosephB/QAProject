package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Game;
import com.qa.util.JSONUtil;

@Alternative
public class GameLocRepository implements GameRepositoriable {

	HashMap<Integer, Game> games = new HashMap<Integer, Game>();

	@Inject
	private JSONUtil util;
	
	private static int ID = 1;
	
	public String getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String add(String game) {
		Game newGame = util.getObjectForJSON(game, Game.class);
		games.put(ID, newGame);
		return "{\"message\": \"Game added successfully.\"}";
	}

	public String delete(int id) {
		if (games.get(id) != null) {
			games.remove(id);
			return "{\"message\": \"Game deleted successfully.\"}";
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

	public String get(int id) {
		if (games.get(id) != null) {
			return util.getJSONForObject(games.get(id));
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

}
