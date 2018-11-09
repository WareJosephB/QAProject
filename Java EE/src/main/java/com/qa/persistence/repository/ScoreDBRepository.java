package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ScoreDBRepository implements ScoreRepositoriable {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(REQUIRED)
	public String add(String score) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(REQUIRED)
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
