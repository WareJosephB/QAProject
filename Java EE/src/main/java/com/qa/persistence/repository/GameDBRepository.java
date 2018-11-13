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

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class GameDBRepository implements GameRepositoriable {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAll() {
		Query q = manager.createQuery("Select a FROM Game a");
		List<Player> games = q.getResultList();
		return util.getJSONForObject(games);
	}

	@Transactional(REQUIRED)
	public String add(String game) {
		Game newGame = util.getObjectForJSON(game, Game.class);
		manager.persist(newGame);
		return "{\"message\": \"Game added successfully.\"}";
	}

	@Transactional(REQUIRED)
	public String delete(int id) {
		if(manager.find(Game.class, id) != null) {
			manager.remove(id);
			return "{\"message\": \"Game deleted successfully.\"}";
		} else {
			return "{\"message\": \"Game not found.\"}";
		}
	}

	public String get(int id) {
		return util.getJSONForObject(manager.find(Game.class, id));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
