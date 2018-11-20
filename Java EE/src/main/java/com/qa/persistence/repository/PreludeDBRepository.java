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
import com.qa.persistence.domain.Prelude;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class PreludeDBRepository implements PreludeRepositoriable {
	@PersistenceContext(unitName = "primary")
	private static EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAll() {
		Query q = manager.createQuery("Select a FROM Prelude a");
		List<Awards> awards = q.getResultList();
		return util.getJSONForObject(awards);
	}

	@Override
	@Transactional(REQUIRED)
	public String add(String prelude) {
		manager.persist(util.getObjectForJSON(prelude, Prelude.class));
		return "";
	}

	@Override
	@Transactional(REQUIRED)
	public String delete(Long id) {
		if (manager.find(Prelude.class, id) != null) {
			manager.remove(manager.find(Prelude.class, id));
		}
		return "";
	}

	@Override
	public String get(Long id) {
		return "[" + util.getJSONForObject(manager.find(Prelude.class, id)) + "]";
	}
}
