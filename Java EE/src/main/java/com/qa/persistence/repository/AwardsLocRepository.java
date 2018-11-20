package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Awards;
import com.qa.util.JSONUtil;

@Alternative
public class AwardsLocRepository implements AwardsRepositoriable {

	HashMap<Long, Awards> awards = new HashMap<Long, Awards>();

	@Inject
	private JSONUtil util;

	private static long ID = 1;

	@Override
	public String getAll() {
		Awards[] theAwards = awards.entrySet().toArray(new Awards[0]);
		return util.getJSONForObject(theAwards);
	}

	@Override
	public String add(String Awards) {
		Awards newAwards = util.getObjectForJSON(Awards, Awards.class);
		awards.put(ID, newAwards);
		return "{\"message\": \"Awards added successfully. ID number is " + ID + "\"}";
	}

	@Override
	public String delete(Long id) {
		if (awards.get(id) != null) {
			awards.remove(id);
			return "{\"message\": \"Awards deleted successfully.\"}";
		} else {
			return "{\"message\": \"Awards not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		if (awards.get(id) != null) {
			return util.getJSONForObject(awards.get(id));
		} else {
			return "{\"message\": \"Awards not found.\"}";
		}
	}

}
