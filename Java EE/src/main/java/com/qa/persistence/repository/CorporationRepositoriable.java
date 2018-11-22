package com.qa.persistence.repository;

import com.qa.persistence.domain.Corporation;

public interface CorporationRepositoriable {
	
	String getAll();

	String add(Corporation corporation);

	String delete(Long id);

	String get(Long id);

}
