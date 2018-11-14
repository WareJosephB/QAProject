package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.GameRepositoriable;

public class GameService implements Servicable {

	@Inject
	private GameRepositoriable repo;

	public String getAll() {
		return repo.getAll();
	}

	public String add(String game) {
		return repo.add(game);
	}

	public String delete(Long id) {
		return repo.delete(id);
	}

	public String get(Long id) {
		return repo.get(id);
	}

	public String update(Long id, String entity) {
		return repo.update(id, entity);
	}

}
