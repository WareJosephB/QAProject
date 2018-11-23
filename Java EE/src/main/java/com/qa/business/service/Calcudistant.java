package com.qa.business.service;

import javax.enterprise.inject.Default;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;
import com.qa.persistence.repository.PlayerDBRepository;

@Default
public class Calcudistant implements Calculable {

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
				average += ELOchange(player.getELO(), PlayerDBRepository.getPlayer(score.getPlayerID()).getELO(), S,
						weighting);
			}

		}
		return average;

	}

	public void UpdateAfterGame(Game game) {
		double[] ELOs = new double[game.returnNumPlayers()];
		int i = 0;
		while (i < game.returnNumPlayers()) {
			ELOs[i] = updateScore(PlayerDBRepository.getPlayer(game.returnScores().get(i).getPlayerID()), game);

			ELOs[i] = updateScore(PlayerDBRepository.getPlayer(game.returnScores().get(i).getPlayerID()), game);
			i++;
		}
		i = 0;
		while (i < game.returnNumPlayers()) {
			PlayerDBRepository.getPlayer(game.returnScores().get(i).getPlayerID()).updateELO(ELOs[i]);
			i++;
		}

	}

	public double updateScore(Player player, Game game) {
		player.setNumberPlayed(player.getNumberPlayed() + 1);
		return updateAverageChangeWeighted(player, game);

	}

	@Override
	public double simpleWin(Player winner, double ELO) {
		winner.playGame();
		return ELOchange(winner.getELO(), ELO, 1d, 16d);
	}

	@Override
	public double simpleLost(double ELO, Player loser) {
		loser.playGame();
		return ELOchange(loser.getELO(), ELO, 0d, 16d);
	}
}
