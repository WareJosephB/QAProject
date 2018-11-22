package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.business.service.Calculable;
import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.SimpleGame;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class GameDBRepository implements GameRepositoriable {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Inject
	private Calculable calc;

	@Override
	public String getAll() {
		Query q = manager.createQuery("Select a FROM Game a");
		List<Game> games = q.getResultList();
		return util.getJSONForObject(games);
	}

	@Override
	@Transactional(REQUIRED)
	public String add(Game game) {
		String id = "unknown";
		manager.merge(game);
		Query q = manager.createQuery("SELECT a FROM Game a ORDER BY playID DESC");
		Game latestGame = (Game) q.getResultList().get(0);
		if (latestGame.equals(game)) {
			id = String.valueOf(latestGame.getID());
		}
		return "{\"message\": \"Game added successfully. ID number is " + id + ".\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String delete(Long id) {
		if (manager.find(Game.class, id) != null) {
			manager.remove(id);
			return "{\"message\": \"Game deleted successfully.\"}";
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		return "[" + util.getJSONForObject(manager.find(Game.class, id)) + "]";
	}

	@Transactional(REQUIRED)
	@Override
	public String update(Long id, Game game) {
		Game game1 = manager.find(Game.class, id);
		if (game1 != null) {
//			game1.changeAddons(game.returnP(), game1.returnC(), game2.returnP());
//			game1.changeGenerations(game.returnGenerations());
			return "{\"message\": \"Game updated successfully.\"}";
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String update(SimpleGame simpleGame) {
		Player player1 = manager.find(Player.class, simpleGame.getPlayer1());
		Player player2 = manager.find(Player.class, simpleGame.getPlayer2());
		calc.simpleELO(player1, player2);
		return "{\"message\": \"ELOs updated.\"}";
	}

}
