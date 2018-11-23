package com.qa.business.service;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;

public interface Calculable {

	void UpdateAfterGame(Game game);

	double updateScore(Player player, Game game);

	double updateAverageChangeWeighted(Player player, Game game);

	double ELOchange(double ELOPlayer, double ELOOpponent, double result, double weighting);

	double simpleWin(Player winner, double ELO);
	
	double simpleLost(double ELO, Player loser);
}
