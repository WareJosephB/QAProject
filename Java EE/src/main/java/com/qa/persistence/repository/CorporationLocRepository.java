package com.qa.persistence.repository;

import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Corporation;
import com.qa.util.JSONUtil;

@Alternative
public class CorporationLocRepository implements CorporationRepositoriable{

	HashMap<Long, Corporation> corporations = new HashMap<Long, Corporation>();

	@Inject
	private JSONUtil util;

	private static long ID = 1;

	@Override
	public String getAll() {
		Corporation[] theCorporation = corporations.entrySet().toArray(new Corporation[0]);
		return util.getJSONForObject(theCorporation);
	}

	@Override
	public String add(String Corporation) {
		Corporation newCorporation = util.getObjectForJSON(Corporation, Corporation.class);
		corporations.put(ID, newCorporation);
		return "{\"message\": \"Corporation added successfully. ID number is " + ID + "\"}";
	}

	@Override
	public String delete(Long id) {
		if (corporations.get(id) != null) {
			corporations.remove(id);
			return "{\"message\": \"Corporation deleted successfully.\"}";
		} else {
			return "{\"message\": \"Corporation not found.\"}";
		}
	}

	@Override
	public String get(Long id) {
		if (corporations.get(id) != null) {
			return util.getJSONForObject(corporations.get(id));
		} else {
			return "{\"message\": \"Corporation not found.\"}";
		}
	}

}
