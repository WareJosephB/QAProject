package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Prelude;
import com.qa.persistence.repository.PreludeRepositoriable;
import com.qa.util.JSONUtil;

public class PreludeService implements Servicable {

	@Inject
	private PreludeRepositoriable repo;
	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String entity) {
		Prelude prelude = util.getObjectForJSON(entity, Prelude.class);
		return repo.add(prelude);
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
