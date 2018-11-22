package com.qa.persistence.repository;

import com.qa.persistence.domain.Prelude;

public interface PreludeRepositoriable {

	String getAll();

	String add(Prelude prelude);

	String delete(Long id);

	String get(Long id);

}
