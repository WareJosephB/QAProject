package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Score;
import com.qa.util.JSONUtil;

@Alternative
public class ScoreLocRepository implements ScoreRepositoriable {

	HashMap<Integer, Score> scores = new HashMap<Integer, Score>();

	@Inject
	private JSONUtil util;
	
	private static int ID = 1;
	
	public String getAll() {
		Score[] theScores = scores.entrySet().toArray(new Score[0]);
		return util.getJSONForObject(theScores);
	}

	public String add(String score) {
		Score newScore = util.getObjectForJSON(score, Score.class);
		scores.put(ID, newScore);
		return "{\"message\": \"Score added successfully.\"}";
	}

	public String delete(int id) {
		if (scores.get(id) != null) {
			scores.remove(id);
			return "{\"message\": \"Score deleted successfully.\"}";
		} else {
			return "{\"message\": \"Score not found.\"}";
		}
	}

	public String get(int id) {
		if (scores.get(id) != null) {
			return util.getJSONForObject(scores.get(id));
		} else {
			return "{\"message\": \"Score not found.\"}";
		}
	}

}
