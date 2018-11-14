package com.qa.business.service;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;

public class calculator {

	private static double ELOchange(double ELOPlayer, double ELOOpponent, double result, double weighting) { // Calculate
																												// change
																												// in
																												// ELO
																												// for
		// player A
		// due to
		// winning (s = 1), drawing (=0.5),
		// losing
		// (=0)
		// against player B, with weighting K.
		double temp = Math.pow(10, (ELOOpponent - ELOPlayer) / 400);
		double expected = Math.pow(1 + temp, -1);
		return weighting * (result - expected);
	}


	private static double updateAverageChangeWeighted(Player player, Game game) { // Finds change for "average ELO
																					// change
																					// method", weighted

		double average = 0;
		int Score = 0;
		double weighting = 32 / game.returnNumPlayers();

		for (Score score : game.returnScores()) {
			if (player.equals(score.getPlayer())) {
				Score = score.getScore();
			}
		}

		for (Score score : game.returnScores()) {
			if (!player.equals(score.getPlayer())) {
				double S;
				if (score.getScore() < Score) {
					S = 1;
				} else if (score.getScore() == Score) {
					S = 0.5;
				} else {
					S = 0;
				}
				average += ELOchange(player.getELO(), score.getPlayer().getELO(), S, weighting);
			}

		}
		return average;

	}



	public static void UpdateAfterGame(Game game) {
		double[] ELOs = new double[game.returnNumPlayers()];
		int i = 0;
		while (i < game.returnNumPlayers()) {
			ELOs[i] = updateScore(game.returnScores().get(i).getPlayer(), game);
			i++;
		}
		i = 0;
		while (i < game.returnNumPlayers()) {
			game.returnScores().get(i).getPlayer().updateELO(ELOs[i]);
			i++;
		}

	}

	private static double updateScore(Player player, Game game) { 
		player.setNumberPlayed(player.getNumberPlayed()+1);
		return updateAverageChangeWeighted(player, game);

	}

}
