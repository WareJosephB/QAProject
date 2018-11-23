package com.qa.persistence.repository;

import com.qa.persistence.domain.Score;

public interface ScoreRepositoriable {

	String getAll();

	String add(Score score);

	String delete(Long id);

	String get(Long id);

}
