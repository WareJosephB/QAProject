package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Corporation;
import com.qa.persistence.repository.CorporationRepositoriable;
import com.qa.util.JSONUtil;

public class CorporationsService implements Servicable {

	@Inject
	private CorporationRepositoriable repo;
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String entity) {
		Corporation corporation = util.getObjectForJSON(entity, Corporation.class);
		return repo.add(corporation);
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
