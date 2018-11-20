package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AwardsRepositoriable;

public class AwardsService implements Servicable{

	@Inject
	private AwardsRepositoriable repo;
	
	@Override
	public String getAll() {
		return repo.getAll();
	}

	@Override
	public String add(String entity) {
		return repo.add(entity);
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
