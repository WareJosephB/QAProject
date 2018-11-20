package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Game;
import com.qa.persistence.repository.GameRepositoriable;
import com.qa.util.JSONUtil;

public class GameService implements Servicable {

	@Inject
	private Calculable calc;
	@Inject
	private GameRepositoriable repo;

	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		return "";
		// return repo.getAll();
	}

	@Override
	public String add(String game) {
		calc.UpdateAfterGame(util.getObjectForJSON(game, Game.class));
		return repo.add(game);
	}

	@Override
	public String delete(Long id) {
		return "";
		// return repo.delete(id);
	}

	@Override
	public String get(Long id) {
		return repo.get(id);
	}

	@Override
	public String update(Long id, String entity) {
		return repo.update(id, entity);
	}

}
