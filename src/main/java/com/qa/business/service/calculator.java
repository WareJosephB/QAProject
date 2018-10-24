package com.qa.business.service;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;

public class calculator {

	private double ELOchange(double pA, double pB, double s, double k) {

		double F = Math.pow(10, (pA - pB) / 400);
		double E = Math.pow(1 + F, -1);
		return k * (s - E);
	}

	private double[] allELO(Player player, double[] player2, double s, double k, Game game) {

		double[] ELO1 = player.returnELOs();
		double[] ELO2 = player2;
		double[] changes = new double[7];
		changes[0] = ELOchange(ELO1[0], ELO2[0], s, k);

		if (game.returnP()) {
			changes[1] = ELOchange(ELO1[1], ELO2[1], s, k);
			changes[5] = 0;
			if (game.returnC()) {
				changes[3] = ELOchange(ELO1[3], ELO2[3], s, k);
			} else {
				changes[3] = 0;
			}
		} else {
			changes[1] = 0;
			changes[5] = ELOchange(ELO1[5], ELO2[5], s, k);
			if (!game.returnC()) {
				changes[6] = ELOchange(ELO1[6], ELO2[6], s, k);
			} else {
				changes[6] = 0;
			}
		}
		if (game.returnC()) {
			changes[2] = ELOchange(ELO1[2], ELO2[2], s, k);
			changes[4] = 0;
		} else {
			changes[2] = 0;
			changes[4] = ELOchange(ELO1[4], ELO2[4], s, k);
		}
		return changes;
	}

	private double[] getAverage(Player player, Game game) {

		double[] average = new double[7];
		double[] ave = new double[game.returnScores().length];
		int i = 0;

		while (i < ave.length) {
			for (Score score : game.returnScores()) {
				average[i] += score.getPlayer().returnELOs()[i];
			}
			average[i] = average[i] / game.returnScores().length;
		}
		return average;
	}

	private double getAverageS(Player player, Game game) {

		double S = 0;
		int H = game.returnScores().length - 1;
		int I = 0;

		for (Score score : game.returnScores()) {
			if (player.returnName().equals(score.getName())) {
				I = score.getScore();
			}
		}
		for (Score score : game.returnScores()) {
			if (!player.returnName().equals(score.getName())) {
				if (score.getScore() > I) {
					S += 1;
				} else if (score.getScore() == I) {
					S += 0.5;
				}
			}
		}
		return S / H;
	}

	private double[] AverageELO(Player player, Game game) {

		double S = getAverageS(player, game);
		int K = 32;
		double[] pBs = getAverage(player, game);
		return allELO(player, pBs, S, K, game);

	}

	public void updateAverageELO(Player player, Game game) {
		double[] G = AverageELO(player, game);
		double[] H = player.returnELOs();
		int i = 0;
		while (i < G.length) {
			H[i] += G[i];
		}
		player.updateELO(H);
	}

	private double[] afterAverageELO(Player player, Game game) {

		double[] average = { 0, 0, 0, 0, 0, 0, 0 };
		int Score = 0;

		for (Score score : game.returnScores()) {
			if (player.returnName().equals(score.getName())) {
				Score = score.getScore();
			}
		}
		if (Score == 0) {
			double[] average1 = { 1, 1 };
			return average1;
		}

		for (Score score : game.returnScores()) {
			double[] average1 = { 0, 0, 0, 0, 0, 0, 0 };
			if (player.returnName().equals(score.getName())) {
				double S;
				if (score.getScore() < Score) {
					S = 1;
				} else if (score.getScore() == Score) {
					S = 0.5;
				} else {
					S = 0;
				}
				average1 = allELO(player, score.getPlayer().returnELOs(), S, 16, game);
			}
			int i = 0;
			while (i < average1.length) {
				average[i] = average1[i];
				i++;
			}
		}
		int i = 0;
		while (i < average.length) {
			average[i] = average[i] / (game.returnScores().length - 1);
			i++;
		}
		return average;

	}

	public void updateAverageAfterELO(Player player, Game game) {
		double[] H = afterAverageELO(player, game);
		double[] I = { 0, 0, 0, 0, 0, 0, 0 };
		int i = 0;
		while (i < player.returnELOs().length) {
			I[i] += H[i];
			i++;

		}
		player.updateELO(I);

	}
	
//	public void updateSME(Player player, Game game) {
//			ORDER game.Scores, find player.name, ELO above - ELO below
//	}
	
	
	
	
	

}