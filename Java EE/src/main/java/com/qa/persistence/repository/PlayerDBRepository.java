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
		String id = "unknown";
		manager.persist(newPlayer);
		Query q = manager.createQuery("SELECT a FROM Player a ORDER BY playID DESC");
		Player latestPlayer = (Player) q.getResultList().get(0);
		if (latestPlayer.equals(newPlayer)) {
			id = String.valueOf(latestPlayer.getID());
		}
		return "{\"message\": \"Player added successfully. ID number is " + id + ".\"}";
	}

	@Transactional(REQUIRED)
	public String delete(Long id) {
		if (manager.find(Player.class, id) != null) {
			manager.remove(manager.find(Player.class, id));
			return "{\"message\": \"Player deleted successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		return "["+util.getJSONForObject(manager.find(Player.class, id))+"]";
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

	@Override
	public String update(Long id, String entity) {
		Player player1 = manager.find(Player.class, id);
		Player player2 = util.getObjectForJSON(entity, Player.class);
		if (player1 != null) {
			player1.setName(player2.getName());
			return "{\"message\": \"Player updated successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}

	}
}
