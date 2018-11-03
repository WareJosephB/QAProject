package com.qa.test;

import com.qa.business.service.calculator;
import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;

public class runner {
	
	private runner() {}

	public static void main(String[] args) {
		
		Player ben = new Player("Ben");
		Player joseph = new Player("Joseph");
		Player vinul = new Player("Vinul");
		Player kyle = new Player("Kyle");
		Player andy = new Player("Andy");
		Player malcolm = new Player("Malcolm");
		Player jon = new Player("Jon");

		Score score1 = new Score(1, joseph, 127);
		Score score2 = new Score(2, ben, 114);
		Game game1 = new Game(new Score[] { score1, score2 });
		calculator.UpdateAfterGame(game1);

		System.out.println(ben);
		System.out.println(joseph);
		System.out.println("---");

		Score score3 = new Score(1, joseph, 73);
		Score score4 = new Score(2, ben, 68);
		Score score5 = new Score(3, vinul, 47);
		Game game2 = new Game(new Score[] { score3, score4, score5 });

		calculator.UpdateAfterGame(game2);

		System.out.println(ben);
		System.out.println(vinul);
		System.out.println(joseph);
		System.out.println("---");

		Score score6 = new Score(1, ben, 60);
		Score score7 = new Score(2, kyle, 53);
		Score score8 = new Score(3, joseph, 50);
		Score score9 = new Score(4, andy, 43);
		Score score10 = new Score(5, malcolm, 39);
		Game game3 = new Game(new Score[] { score6, score7, score8, score9, score10 });

		calculator.UpdateAfterGame(game3);

		System.out.println(ben);
		System.out.println(kyle);
		System.out.println(joseph);
		System.out.println(andy);
		System.out.println(malcolm);
		System.out.println("---");

		Score score11 = new Score(1, joseph, 65);
		Score score12 = new Score(2, ben, 65);
		Score score13 = new Score(3, jon, 51);
		Score score14 = new Score(4, malcolm, 50);
		Score score15 = new Score(5, vinul, 48);
		Game game4 = new Game(new Score[] { score11, score12, score13, score14, score15 });

		calculator.UpdateAfterGame(game4);

		System.out.println(ben);
		System.out.println(vinul);
		System.out.println(joseph);
		System.out.println(jon);
		System.out.println(malcolm);
		System.out.println("---");

		Score score16 = new Score(1, joseph, 84);
		Score score17 = new Score(2, ben, 83);
		Score score18 = new Score(3, andy, 71);
		Game game5 = new Game(new Score[] { score16, score17, score18 });

		calculator.UpdateAfterGame(game5);

		System.out.println(ben);
		System.out.println(joseph);
		System.out.println(andy);
		System.out.println("---");

	}

}
