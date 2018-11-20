package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Corporation;
import com.qa.util.JSONUtil;

public class CorporationDBRepository implements CorporationRepositoriable {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		Query q = manager.createQuery("Select a FROM Corporation a");
		List<Corporation> corporation = q.getResultList();
		return util.getJSONForObject(corporation);
	}

	@Override
	@Transactional(REQUIRED)
	public String add(String corporation) {
		manager.persist(util.getObjectForJSON(corporation, Corporation.class));
		return "";
	}

	@Override
	@Transactional(REQUIRED)
	public String delete(Long id) {
		if (manager.find(Corporation.class, id) != null) {
			manager.remove(manager.find(Corporation.class, id));
		}
		return "";
	}

	@Override
	public String get(Long id) {
		return "[" + util.getJSONForObject(manager.find(Corporation.class, id)) + "]";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
