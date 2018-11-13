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

import com.qa.persistence.domain.Score;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ScoreDBRepository implements ScoreRepositoriable {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAll() {
		Query q = manager.createQuery("Select a FROM Score a");
		List<Score> scores = q.getResultList();
		return util.getJSONForObject(scores);
	}

	@Transactional(REQUIRED)
	public String add(String score) {
		Score newScore = util.getObjectForJSON(score, Score.class);
		manager.persist(newScore);
		return "{\"message\": \"Score added successfully.\"}";
	}

	@Transactional(REQUIRED)
	public String delete(int id) {
		if(manager.find(Score.class, id) != null) {
			manager.remove(id);
			return "{\"message\": \"Score deleted successfully.\"}";
		} else {
			return "{\"message\": \"Score not found.\"}";
		}
	}

	public String get(int id) {
		return util.getJSONForObject(manager.find(Score.class, id));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
