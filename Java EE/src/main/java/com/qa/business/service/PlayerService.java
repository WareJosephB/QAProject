package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Player;
import com.qa.persistence.repository.PlayerRepositoriable;
import com.qa.util.JSONUtil;

public class PlayerService implements Servicable {

	@Inject
	private PlayerRepositoriable repo;
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String entity) {
		Player player = util.getObjectForJSON(entity, Player.class);
		return repo.add(player);
	}

	@Override
	public String delete(Long id) {
		return repo.delete(id);
	}

	@Override
	public String get(Long id) {
		return repo.get(id);
	}

	@Override
	public String update(Long id, String entity) {
		Player player = util.getObjectForJSON(entity, Player.class);
		return repo.update(id, player);
	}

}
