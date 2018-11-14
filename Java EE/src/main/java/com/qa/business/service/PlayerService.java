package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.PlayerRepositoriable;

public class PlayerService implements Servicable {

	@Inject
	private PlayerRepositoriable repo;

	public String getAll() {
		return repo.getAll();
	}

	public String add(String player) {
		return repo.add(player);
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
