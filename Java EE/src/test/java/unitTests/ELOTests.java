package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.persistence.domain.Game;
import com.qa.persistence.domain.Player;
import com.qa.persistence.domain.Score;
import com.qa.business.service.Calculocal;
import com.qa.business.service.Calcudistant;
import com.qa.business.service.Calculable;

public class ELOTests {

	private static Player player1;
	private static Player player2;

	private static Score score1 = new Score(1, player1, 100);
	private static Score score2 = new Score(2, player2, 50);
	private static List<Score> scores1;

	private Game game1 = new Game(scores1);

	private Calculable localc = new Calculocal();
	private Calculable discal = new Calcudistant();

	@BeforeClass
	public static void setUp() {
		player1 = new Player("Joseph", 1);
		player2 = new Player("Ben", 2);
		scores1 = new ArrayList<Score>();
		scores1.add(score1);
		scores1.add(score2);
	}

	@Before
	public void reset() {
		player1.updateELO(1500 - player1.getELO());
		player2.updateELO(1500 - player2.getELO());

	}

	@Test
	public void testMatch() {
		assertEquals(localc.ELOchange(1500, 1500, 1, 16), discal.ELOchange(1500, 1500, 1, 16), 0.001);
		assertEquals(localc.ELOchange(1500, 1500, 0.5, 16), discal.ELOchange(1500, 1500, 0.5, 16), 0.001);
		assertEquals(localc.ELOchange(1500, 1750, 0.5, 16), discal.ELOchange(1500, 1750, 0.5, 16), 0.001);
		assertEquals(localc.ELOchange(1500, 1750, 1, 16), discal.ELOchange(1500, 1750, 1, 16), 0.001);
		assertEquals(localc.ELOchange(1750, 1500, 1, 16), discal.ELOchange(1750, 1500, 1, 16), 0.001);
		assertEquals(localc.ELOchange(1750, 1500, 0.5, 16), discal.ELOchange(1750, 1500, 0.5, 16), 0.001);
		assertEquals(localc.ELOchange(1500, 1500, 0, 16), discal.ELOchange(1500, 1500, 0, 16), 0.001);
		assertEquals(localc.ELOchange(1750, 1500, 0, 16), discal.ELOchange(1750, 1500, 0, 16), 0.001);
		assertEquals(localc.ELOchange(1500, 1750, 0, 16), discal.ELOchange(1500, 1750, 0, 16), 0.001);
	}

	@Test
	public void testPlayerFunctions() {
		assertEquals(1500, player1.getELO(), 0.001);
		assertEquals(1500, player2.getELO(), 0.001);
		assertEquals("Ben", player2.getName());
		assertEquals(0, player2.getNumberPlayed());
		player1.updateELO(5);
		assertEquals(1505, player1.getELO(), 0.001);

	}

	@Test
	public void testAfterGameLocal() {
		localc.UpdateAfterGame(game1);
		assertEquals(1508, player1.getELO(), 0.001);
		assertEquals(1492, player2.getELO(), 0.001);
	}

	@Test
	public void testAfterGameDistant() {
		discal.UpdateAfterGame(game1);
		assertEquals(1508, player1.getELO(), 0.001);
		assertEquals(1492, player2.getELO(), 0.001);
	}

}
