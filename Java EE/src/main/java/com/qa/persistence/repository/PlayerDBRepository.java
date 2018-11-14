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
	public String delete(Long id) {
		if(manager.find(Player.class, id) != null) {
			manager.remove(manager.find(Player.class, id));
			return "{\"message\": \"Player deleted successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		return util.getJSONForObject(manager.find(Player.class, id));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String changeName(Long id, String name) {
		Player player = manager.find(Player.class, id);
		if (player != null) {
			player.setName(name);
			return "{\"message\": \"Player update succesfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

}
