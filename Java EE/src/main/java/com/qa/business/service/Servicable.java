package com.qa.business.service;

public interface Servicable {

	String getAll();

	String add(String entity);

	String delete(Long id);

	String get(Long id);
	
	String update(Long id, String entity);

}
