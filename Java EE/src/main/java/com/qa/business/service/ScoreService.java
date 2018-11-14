package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ScoreRepositoriable;

public class ScoreService implements Servicable {

	@Inject
	private ScoreRepositoriable repo;

	public String getAll() {
		return repo.getAll();
	}

	public String add(String score) {
		return repo.add(score);
	}

	public String delete(Long id) {
		return repo.delete(id);
	}

	public String get(Long id) {
		return repo.get(id);
	}

	public String update(Long id, String entity) {
		return "{\"message\": \"Scores cannot be edited.\"}";
	}
}
