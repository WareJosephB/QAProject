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

	@Override
	public String getAll() {
		Query q = manager.createQuery("Select a FROM Score a");
		List<Score> scores = q.getResultList();
		return util.getJSONForObject(scores);
	}

	@Override
	@Transactional(REQUIRED)
	public String add(String score) {
		Score newScore = util.getObjectForJSON(score, Score.class);
		String id = "unknown";
		manager.persist(newScore);
		Query q = manager.createQuery("SELECT a FROM Score a ORDER BY scoreID DESC");
		Score latestScore = (Score) q.getResultList().get(0);
		if (latestScore.equals(newScore)) {
			id = String.valueOf(latestScore.getID());
		}
		return "{\"message\": \"Score added successfully. ID number is " + id + ".\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String delete(Long id) {
		if (manager.find(Score.class, id) != null) {
			manager.remove(id);
			return "{\"message\": \"Score deleted successfully.\"}";
		} else {
			return "{\"message\": \"Score not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		return util.getJSONForObject(manager.find(Score.class, id));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
