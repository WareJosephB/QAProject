package com.qa.persistence.repository;

public interface PlayerRepositoriable {
	String getAll();

	String add(String player);

	String delete(Long id);

	String get(Long id);
	
	String changeName(Long id, String name);

	String update(Long id, String entity);

}
