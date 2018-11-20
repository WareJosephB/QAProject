package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Awards;
import com.qa.persistence.domain.Colony;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ColonyDBRepositoriable implements ColonyRepositoriable {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		Query q = manager.createQuery("Select a FROM Colony a");
		List<Awards> colonies = q.getResultList();
		return util.getJSONForObject(colonies);
	}

	@Override
	@Transactional(REQUIRED)
	public String add(String colony) {
		manager.persist(util.getObjectForJSON(colony, Colony.class));
		return "";
	}

	@Override
	@Transactional(REQUIRED)
	public String delete(Long id) {
		if (manager.find(Colony.class, id) != null) {
			manager.remove(manager.find(Awards.class, id));
		}
		return "";
	}

	@Override
	public String get(Long id) {
		return "[" + util.getJSONForObject(manager.find(Colony.class, id)) + "]";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
