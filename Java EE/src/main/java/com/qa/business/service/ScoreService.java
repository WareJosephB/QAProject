package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Score;
import com.qa.persistence.repository.ScoreRepositoriable;
import com.qa.util.JSONUtil;

public class ScoreService implements Servicable {

	@Inject
	private ScoreRepositoriable repo;
	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String entity) {
		Score score = util.getObjectForJSON(entity, Score.class);
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
