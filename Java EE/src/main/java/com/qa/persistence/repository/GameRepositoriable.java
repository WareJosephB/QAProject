package com.qa.persistence.repository;

public interface GameRepositoriable {

	String getAll();

	String add(String game);

	String delete(int id);

	String get(int id);
	
	String updateGame(int id, String game);

}
