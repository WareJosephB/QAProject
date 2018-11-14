package com.qa.persistence.repository;

public interface ScoreRepositoriable {

	String getAll();

	String add(String score);

	String delete(Long id);

	String get(Long id);

}
