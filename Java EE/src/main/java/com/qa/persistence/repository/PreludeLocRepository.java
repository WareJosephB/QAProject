package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Prelude;
import com.qa.util.JSONUtil;
@Alternative
public class PreludeLocRepository implements PreludeRepositoriable{
	HashMap<Long, Prelude> preludes = new HashMap<Long, Prelude>();

	@Inject
	private JSONUtil util;

	private static long ID = 1;

	@Override
	public String getAll() {
		Prelude[] thePrelude = preludes.entrySet().toArray(new Prelude[0]);
		return util.getJSONForObject(thePrelude);
	}

	@Override
	public String add(Prelude prelude) {
		preludes.put(ID, prelude);
		return "{\"message\": \"Prelude added successfully. ID number is " + ID + "\"}";
	}

	@Override
	public String delete(Long id) {
		if (preludes.get(id) != null) {
			preludes.remove(id);
			return "{\"message\": \"Prelude deleted successfully.\"}";
		} else {
			return "{\"message\": \"Prelude not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		if (preludes.get(id) != null) {
			return util.getJSONForObject(preludes.get(id));
		} else {
			return "{\"message\": \"Prelude not found.\"}";
		}
	}
}
