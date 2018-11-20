package com.qa.persistence.repository;

public interface AwardsRepositoriable {

	String add(String award);

	String delete(Long id);

	String get(Long id);

	String getAll();

}
