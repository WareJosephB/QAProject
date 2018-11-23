package com.qa.persistence.repository;

import com.qa.persistence.domain.Player;

public interface PlayerRepositoriable {
	
	String getAll();

	String add(Player player);

	String delete(Long id);

	String get(Long id);

	String update(Long id, Player player);

}
