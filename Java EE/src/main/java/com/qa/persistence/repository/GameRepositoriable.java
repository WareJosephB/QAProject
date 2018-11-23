package com.qa.persistence.repository;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.SimpleGame;

public interface GameRepositoriable {

	String getAll();

	String add(Game game);

	String delete(Long id);

	String get(Long id);

	String update(Long id, Game game);
	
	String update(SimpleGame simpleGame);

}
