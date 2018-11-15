package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Score;
import com.qa.util.JSONUtil;

@Alternative
public class ScoreLocRepository implements ScoreRepositoriable {

	HashMap<Long, Score> scores = new HashMap<Long, Score>();

	@Inject
	private JSONUtil util;
	
	private static long ID = 1;
	
	@Override
	public String getAll() {
		Score[] theScores = scores.entrySet().toArray(new Score[0]);
		return util.getJSONForObject(theScores);
	}

	@Override
	public String add(String score) {
		Score newScore = util.getObjectForJSON(score, Score.class);
		scores.put(ID, newScore);
		return "{\"message\": \"Score added successfully. ID number is "+ID+"\"}";
	}

	@Override
	public String delete(Long id) {
		if (scores.get(id) != null) {
			scores.remove(id);
			return "{\"message\": \"Score deleted successfully.\"}";
		} else {
			return "{\"message\": \"Score not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		if (scores.get(id) != null) {
			return util.getJSONForObject(scores.get(id));
		} else {
			return "{\"message\": \"Score not found.\"}";
		}
	}

}
