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

import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class PlayerDBRepository implements PlayerRepositoriable {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAll() {
		Query q = manager.createQuery("Select a FROM Player a");
		List<Player> players = q.getResultList();
		return util.getJSONForObject(players);
	}

	@Transactional(REQUIRED)
	public String add(String player) {
		Player newPlayer = util.getObjectForJSON(player, Player.class);
		manager.persist(newPlayer);
		return "{\"message\": \"Player added successfully.\"}";
	}

	@Transactional(REQUIRED)
	public String delete(int id) {
		if(manager.find(Player.class, id) != null) {
			manager.remove(id);
			return "{\"message\": \"Player deleted successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	public String get(int id) {
		return util.getJSONForObject(manager.find(Player.class, id));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
