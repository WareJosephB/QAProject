package com.qa.persistence.repository;

public interface ScoreRepositoriable {

	String getAll();

	String add(String score);

	String delete(int id);

	String get(int id);

}
