package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.PlayerRepositoriable;

public class PlayerService implements Servicable {

	@Inject
	private PlayerRepositoriable repo;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String player) {
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
		return repo.update(id, entity);
	}

}
