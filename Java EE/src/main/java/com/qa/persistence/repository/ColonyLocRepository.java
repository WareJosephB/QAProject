package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Colony;
import com.qa.util.JSONUtil;

@Alternative
public class ColonyLocRepository implements ColonyRepositoriable{
	
	HashMap<Long, Colony> colonys = new HashMap<Long, Colony>();

	@Inject
	private JSONUtil util;

	private static long ID = 1;

	@Override
	public String getAll() {
		Colony[] theColony = colonys.entrySet().toArray(new Colony[0]);
		return util.getJSONForObject(theColony);
	}

	@Override
	public String add(Colony colony) {
		colonys.put(ID, colony);
		return "{\"message\": \"Colony added successfully. ID number is " + ID + "\"}";
	}

	@Override
	public String delete(Long id) {
		if (colonys.get(id) != null) {
			colonys.remove(id);
			return "{\"message\": \"Colony deleted successfully.\"}";
		} else {
			return "{\"message\": \"Colony not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		if (colonys.get(id) != null) {
			return util.getJSONForObject(colonys.get(id));
		} else {
			return "{\"message\": \"Colony not found.\"}";
		}
	}
	
}
