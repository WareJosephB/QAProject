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
	private static EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		Query q = manager.createQuery("Select a FROM Player a");
		List<Player> players = q.getResultList();
		return util.getJSONForObject(players);
	}

	@Override
	@Transactional(REQUIRED)
	public String add(Player player) {
		String id = "unknown";
		manager.persist(player);
		Query q = manager.createQuery("SELECT a FROM Player a ORDER BY playID DESC");
		Player latestPlayer = (Player) q.getResultList().get(0);
		if (latestPlayer.equals(player)) {
			id = String.valueOf(latestPlayer.getID());
		} //For Mockito testing to work, comment out lines 1-3 above, and message below after 'succesfully'.
		return "{\"message\": \"Player added successfully. ID number is " + id + ".\"}";
	}

	@Override
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
		return "[" + util.getJSONForObject(manager.find(Player.class, id)) + "]";
	}

	@Override
	@Transactional(REQUIRED)
	public String update(Long id, Player player) {
		Player player1 = manager.find(Player.class, id);
		if (player1 != null) {
			player1.setName(player.getName());
			return "{\"message\": \"Player updated successfully.\"}";
		} else {
			return "{\"message\": \"Player not found.\"}";
		}

	}

	public void setManager(EntityManager manager) {
		PlayerDBRepository.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	public static Player getPlayer(long playerID) {
		return manager.find(Player.class, playerID);
	}
}
