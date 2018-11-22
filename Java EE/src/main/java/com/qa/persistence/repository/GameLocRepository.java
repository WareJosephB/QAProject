package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.SimpleGame;
import com.qa.util.JSONUtil;

@Alternative
public class GameLocRepository implements GameRepositoriable {

	HashMap<Long, Game> games = new HashMap<Long, Game>();

	@Inject
	private JSONUtil util;

	private static long ID = 1;

	@Override
	public String getAll() {
		Game[] theGames = games.entrySet().toArray(new Game[0]);
		return util.getJSONForObject(theGames);
	}

	@Override
	public String add(Game game) {
		games.put(ID, game);
		return "{\"message\": \"Game added successfully. ID number is " + ID + "\"}";
	}

	@Override
	public String delete(Long id) {
		if (games.get(id) != null) {
			games.remove(id);
			return "{\"message\": \"Game deleted successfully.\"}";
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		if (games.get(id) != null) {
			return util.getJSONForObject(games.get(id));
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

	@Override
	public String update(Long id, Game game) {
		Game game1 = games.get(id);
		if (game1 != null) {
			// game1.changeAddons(game.returnP(), game1.returnC(), game2.returnP());
			// game1.changeGenerations(game.returnGenerations());
			return "{\"message\": \"Game updated successfully.\"}";
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

	@Override
	public String update(SimpleGame simpleGame) {
		return PlayerLocRepository.update(simpleGame);

	}

}
