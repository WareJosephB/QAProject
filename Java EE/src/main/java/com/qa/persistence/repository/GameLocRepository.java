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
		Game[] theGames = games.entrySet().toArray(new Game[0]);
		return util.getJSONForObject(theGames);
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

	@Override
	public String updateGame(int id, String game) {
		Game game1 = games.get(id);
		Game game2 = util.getObjectForJSON(game, Game.class);
		if (game1 != null) {
			game1.changeAddons(game2.returnP(), game1.returnC(), game2.returnP());
			game1.changeGenerations(game2.returnGenerations());
			game1.changeScores(game2.returnScores());
			return "{\"message\": \"Game updated successfully.\"}";
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}
	
}
