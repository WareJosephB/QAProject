package com.qa.persistence.repository;

public interface PreludeRepositoriable {

	String getAll();

	String add(String game);

	String delete(Long id);

	String get(Long id);

}
