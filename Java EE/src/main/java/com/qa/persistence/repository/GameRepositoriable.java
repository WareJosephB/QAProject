package com.qa.persistence.repository;

public interface GameRepositoriable {

	String getAll();

	String add(String game);

	String delete(Long id);

	String get(Long id);
	
	String updateGame(Long id, String game);

}
