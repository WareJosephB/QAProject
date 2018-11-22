package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Awards;
import com.qa.persistence.repository.AwardsRepositoriable;
import com.qa.util.JSONUtil;

public class AwardsService implements Servicable {

	@Inject
	private AwardsRepositoriable repo;
	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String entity) {
		Awards awards = util.getObjectForJSON(entity, Awards.class);
		return repo.add(awards);
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
		return "";
	}

}
