package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Colony;
import com.qa.persistence.repository.ColonyRepositoriable;
import com.qa.util.JSONUtil;

public class ColonyService implements Servicable {

	@Inject
	private ColonyRepositoriable repo;
	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String entity) {
		Colony colony = util.getObjectForJSON(entity, Colony.class);
		return repo.add(colony);
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
