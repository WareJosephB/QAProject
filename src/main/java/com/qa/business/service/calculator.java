package com.qa.business.service;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;

public class calculator {

	private static double ELOchange(double pA, double pB, double actual, double k) { // Calculate change in ELO for
																						// player A
		// due to
		// winning (s = 1), drawing (=0.5),
		// losing
		// (=0)
		// against player B with weighting K.
		double temp = Math.pow(10, (pA - pB) / 400);
		double expected = Math.pow(1 + temp, -1);
		return k * (actual - expected);
	}

	private static double getAverage(Player player, Game game) { // Gets array of average ELOs for each field of players
																	// in
		// game

		double average = 0;

		for (Score score : game.returnScores()) {
			if (!score.getPlayer().equals(player))
				average += score.getPlayer().getELO();
		}
		average = average / game.returnNumPlayers();

		return average;
	}

	private static double getAverageS(Player player, Game game) { // Finds "average win" for a player in a game

		double S = 0;
		int H = game.returnNumPlayers() - 1;
		int I = 0;

		for (Score score : game.returnScores()) {
			if (player.equals(score.getPlayer())) {
				I = score.getScore();
			}
		}
		for (Score score : game.returnScores()) {
			if (!player.equals(score.getPlayer())) {
				if (score.getScore() > I) {
					S += 1;
				} else if (score.getScore() == I) {
					S += 0.5;
				}
			}
		}
		return S / H;
	}

	private static double updateAverageELOUnWeighted(Player player, Game game) { // Finds change for "average player,
																					// average game"
		// method,
		// weighting K = 32

		double S = getAverageS(player, game);
		double K = 16;
		double pB = getAverage(player, game);
		return ELOchange(player.getELO(), pB, S, K);

	}

	private static double updateAverageELOWeighted(Player player, Game game) { // Finds change for "average player,
																				// average game"
		// method,
// weighting K = 32

		double S = getAverageS(player, game);
		double K = 32 / game.returnNumPlayers();
		double pB = getAverage(player, game);
		return ELOchange(player.getELO(), pB, S, K);

	}

	/*-
	 *  BELOW is the code to update the player for an 'average player, average win' method.
	 */

	private static double updateAverageChangeUnWeighted(Player player, Game game) { // Finds change for "average ELO
																					// change
		// method",
		// weighting 16

		double average = 0;
		int Score = 0;
		double weighting = 16;

		for (Score score : game.returnScores()) {
			if (player.equals(score.getPlayer())) {
				Score = score.getScore();
			}
		}

		for (Score score : game.returnScores()) {
			if (player.equals(score.getPlayer())) {
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
		return average / game.returnNumPlayers();

	}

	private static double updateAverageChangeWeighted(Player player, Game game) { // Finds change for "average ELO
																					// change
																					// method",
		// weighting 16

		double average = 0;
		int Score = 0;
		double weighting = 32 / game.returnNumPlayers();

		for (Score score : game.returnScores()) {
			if (player.equals(score.getPlayer())) {
				Score = score.getScore();
			}
		}

		for (Score score : game.returnScores()) {
			if (player.equals(score.getPlayer())) {
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
		return average / game.returnNumPlayers();

	}

	private static double updateSME(Player player, Game game) {
		double average = 0;
		int Place = 0;

		for (Score score : game.returnScores()) {
			if (player.equals(score.getPlayer())) {
				Place = score.getPlace();
			}
		}

		if (1 != Place) {
			for (Score score : game.returnScores()) {
				if (score.getPlace() == Place - 1) {
					average += ELOchange(player.getELO(), score.getPlayer().getELO(), 0d, 16d);
				}
			}
		}
		if (game.returnNumPlayers() != Place) {
			for (Score score : game.returnScores()) {
				if (score.getPlace() == Place + 1) {
					average += ELOchange(player.getELO(), score.getPlayer().getELO(), 1d, 16d);
				}
			}
		}

		return average;
	}

	private static double updateScoreBasedUnweighted(Player player, Game game) {
		double weighting = 16;
		double S = 0;
		double _S = 0;
		for (Score score : game.returnScores()) {
			if (score.getPlayer().equals(player)) {
				S = score.getScore();
			}
			_S += score.getScore();
		}
		return ELOchange(player.getELO(), getAverage(player, game), S / _S, weighting);

	}

	private static double updateScoreBasedweighted(Player player, Game game) {
		double weighting = 32 / game.returnNumPlayers();
		double S = 0;
		double _S = 0;
		for (Score score : game.returnScores()) {
			if (score.getPlayer().equals(player)) {
				S = score.getScore();
			}
			_S += score.getScore();
		}
		return ELOchange(player.getELO(), getAverage(player, game), S / _S, weighting);

	}

	private static double updateScoreBasedweightedWeightedBonus(Player player, Game game) {
		double weighting = 32 / game.returnNumPlayers();
		double S = 0;
		double _S = 0;
		for (Score score : game.returnScores()) {
			if (score.getPlayer().equals(player)) {
				S = score.getScore();
				if (score.getPlace() == 1) {
					S += 20;
				} else {
					S -= 20 / (game.returnNumPlayers() - 1);
				}

			}
			_S += score.getScore();
		}
		return ELOchange(player.getELO(), getAverage(player, game), S / _S, weighting);

	}

	private static double updateScoreBasedweightedUnWeightedBonus(Player player, Game game) {
		double weighting = 32 / game.returnNumPlayers();
		double S = 0;
		double _S = 0;
		for (Score score : game.returnScores()) {
			if (score.getPlayer().equals(player)) {
				S = score.getScore();
				if (score.getPlace() == 1) {
					S += 20;
				} else {
					S -= 5;
				}

			}
			_S += score.getScore();
		}
		return ELOchange(player.getELO(), getAverage(player, game), S / _S, weighting);

	}

	public static void UpdateAfterGame(Game game) {
		double[] ELOs = new double[game.returnNumPlayers()];
		int i = 0;
		while (i < game.returnNumPlayers()) {
			ELOs[i] = updateScore(game.returnScores()[i].getPlayer(), game);
			i++;
		}
		i = 0;
		while (i < game.returnNumPlayers()) {
			game.returnScores()[i].getPlayer().updateELO(ELOs[i]);
			i++;
		}

	}

	private static double updateScore(Player player, Game game) { // All of the different methods
//		updateScoreBasedweightedUnWeightedBonus(player, game);
//		updateScoreBasedweightedWeightedBonus(player, game);
//		updateScoreBasedweighted(player, game);
//		updateScoreBasedUnweighted(player, game);
//		updateSME(player, game);
//		updateAverageChangeWeighted(player, game);
//		updateAverageChangeUnWeighted(player, game);
//		updateAverageELOUnWeighted(player, game);
//		updateAverageELOWeighted(player, game);
		return updateScoreBasedweightedUnWeightedBonus(player, game);
	}

}
