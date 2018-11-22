package com.qa.business.service;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;
import com.qa.persistence.repository.PlayerLocRepository;

@Alternative
public class Calculocal implements Calculable {

	public double ELOchange(double ELOPlayer, double ELOOpponent, double result, double weighting) {
		double temp = Math.pow(10, (ELOOpponent - ELOPlayer) / 400);
		double expected = Math.pow(1 + temp, -1);
		return weighting * (result - expected);
	}

	public double updateAverageChangeWeighted(Player player, Game game) {
		double average = 0;
		int Score = 0;
		double weighting = 32 / game.returnNumPlayers();

		for (Score score : game.returnScores()) {
			if (player.getID() == score.getPlayerID()) {
				Score = score.getScore();
			}
		}

		for (Score score : game.returnScores()) {
			if (!(player.getID() == score.getPlayerID())) {
				double S;
				if (score.getScore() < Score) {
					S = 1;
				} else if (score.getScore() == Score) {
					S = 0.5;
				} else {
					S = 0;
				}
				average += ELOchange(player.getELO(), PlayerLocRepository.getPlayer(score.getPlayerID()).getELO(), S,
						weighting);
			}

		}
		return average;

	}

	public void UpdateAfterGame(Game game) {
		double[] ELOs = new double[game.returnNumPlayers()];
		int i = 0;
		while (i < game.returnNumPlayers()) {
			ELOs[i] = updateScore(PlayerLocRepository.getPlayer(game.returnScores().get(i).getPlayerID()), game);

			ELOs[i] = updateScore(PlayerLocRepository.getPlayer(game.returnScores().get(i).getPlayerID()), game);
			i++;
		}
		i = 0;
		while (i < game.returnNumPlayers()) {
			PlayerLocRepository.getPlayer(game.returnScores().get(i).getPlayerID()).updateELO(ELOs[i]);
			i++;
		}

	}

	public double updateScore(Player player, Game game) {
		player.setNumberPlayed(player.getNumberPlayed() + 1);
		return updateAverageChangeWeighted(player, game);

	}

	@Override
	public void simpleELO(Player winner, Player loser) {
		double temp = winner.getELO();
		winner.playGame();
		loser.playGame();
		winner.setELO(ELOchange(winner.getELO(), loser.getELO(), 1d, 16d));
		loser.setELO(ELOchange(loser.getELO(), temp, 0d, 16d));
	}
}
