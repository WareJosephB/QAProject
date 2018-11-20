// package com.qa.test;
//
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;
//
// import com.qa.business.service.Calculocal;
// import com.qa.persistence.domain.Game;
// import com.qa.persistence.domain.Player;
// import com.qa.persistence.domain.Score;
// import com.qa.util.JSONUtil;
//
// public class runner {
//
// private runner() {
// }
//
// public static void main(String[] args) {
//
// final JSONUtil util = new JSONUtil();
//
// Player ben = new Player("Ben");
// Player joseph = new Player("Joseph");
// Player vinul = new Player("Vinul");
// Player kyle = new Player("Kyle");
// Player andy = new Player("Andy");
// Player malcolm = new Player("Malcolm");
// Player jon = new Player("Jon");
// Player john = new Player("John");
//
// Score score1 = new Score(1, joseph, 127);
// System.out.println(util.getJSONForObject(score1));
// Score score2 = new Score(2, ben, 114);
// Game game1 = new Game(new Score[] { score1, score2 });
// System.out.println(util.getJSONForObject(game1));

// calculator.UpdateAfterGame(game1);
//
// Score score3 = new Score(1, joseph, 73);
// Score score4 = new Score(2, ben, 68);
// Score score5 = new Score(3, vinul, 47);
// Game game2 = new Game(new Score[] { score3, score4, score5 });
// calculator.UpdateAfterGame(game2);
//
// Score score6 = new Score(1, ben, 60);
// Score score7 = new Score(2, kyle, 53);
// Score score8 = new Score(3, joseph, 50);
// Score score9 = new Score(4, andy, 43);
// Score score10 = new Score(5, malcolm, 39);
// Game game3 = new Game(new Score[] { score6, score7, score8, score9, score10
// });
// calculator.UpdateAfterGame(game3);
//
//
// Score score11 = new Score(1, joseph, 65);
// Score score12 = new Score(2, ben, 65);
// Score score13 = new Score(3, jon, 51);
// Score score14 = new Score(4, malcolm, 50);
// Score score15 = new Score(5, vinul, 48);
// Game game4 = new Game(new Score[] { score11, score12, score13, score14,
// score15 });
// calculator.UpdateAfterGame(game4);
//
// Score score16 = new Score(1, joseph, 84);
// Score score17 = new Score(2, ben, 83);
// Score score18 = new Score(3, andy, 71);
// Game game5 = new Game(new Score[] { score16, score17, score18 });
// calculator.UpdateAfterGame(game5);
//
// Score score19 = new Score(2, joseph, 65);
// Score score20 = new Score(1, ben, 70);
// Score score22 = new Score(3, john, 52);
// Score score23 = new Score(5, malcolm, 38);
// Game game6 = new Game(new Score[] { score19, score20, score22, score23 });
// calculator.UpdateAfterGame(game6);
//
// Score score24 = new Score(2, ben, 136);
// Score score25 = new Score(1, joseph, 162);
// Game game7 = new Game(new Score[] {score24, score25});
// calculator.UpdateAfterGame(game7);
//
// Score score26 = new Score(1, malcolm, 75);
// Score score27 = new Score(2, ben, 71);
// Score score28 = new Score(3, john, 63);
// Score score29 = new Score(4, joseph, 62);
// Game game8 = new Game(new Score[] {score26, score27, score28, score29});
// calculator.UpdateAfterGame(game8);

// List<Player> playerList =Arrays.asList(andy, ben, joseph, vinul, malcolm,
// john, jon, kyle);
// Collections.sort(playerList, Comparator.comparing(i -> -i.getELO()));
// for (Player player : playerList) {
// System.out.println(player);
// }
// }
// }
// }
