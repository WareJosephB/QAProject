package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ScoreRepositoriable;

public class ScoreService implements Servicable {

	@Inject
	private ScoreRepositoriable repo;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String score) {
		return repo.add(score);
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
		return "{\"message\": \"Scores cannot be edited.\"}";
	}
}
