package com.qa.persistence.repository;

import com.qa.persistence.domain.Awards;

public interface AwardsRepositoriable {

	String add(Awards awards);

	String delete(Long id);

	String get(Long id);

	String getAll();

}
