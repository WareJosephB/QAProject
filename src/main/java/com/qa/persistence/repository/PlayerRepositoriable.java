package com.qa.persistence.repository;

public interface PlayerRepositoriable {
	String getAll();

	String add(String player);

	String delete(int id);

	String get(int id);

}
