package com.qa.persistence.repository;

import com.qa.persistence.domain.Colony;

public interface ColonyRepositoriable {

	String getAll();

	String add(Colony colony);

	String delete(Long id);

	String get(Long id);

}
