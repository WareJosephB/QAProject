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

	public String delete(int id) {
		return repo.delete(id);
	}

	public String get(int id) {
		return repo.delete(id);
	}

}
