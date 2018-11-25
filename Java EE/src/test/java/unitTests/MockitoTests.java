package unitTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Player;
import com.qa.persistence.repository.PlayerDBRepository;
import com.qa.util.JSONUtil;


@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {
	
	@InjectMocks
	private PlayerDBRepository playerepo;
	
	@Mock
	private EntityManager manager;
	private JSONUtil util;
	@Mock
	private Query q;
	@Mock
	private ArrayList<Player> returned;
	
	private static final String MOCK_USER = "{\"name\" : \"name\", \"numberPlayed\": 0, \"ELO\" : 1500, \"playid\" : 1}";
	private static final String MOCK_USERNAME = "name";
	
	@Before
	public void setup() {
		playerepo.setManager(manager);
		util = new JSONUtil();
	}

	@Test
	public void addUserTest() {
//		Mockito.when(manager.createQuery("SELECT a FROM Player a ORDER BY playID DESC")).thenReturn(q);
//		Mockito.when(q.getResultList().get(0)).thenReturn(returned);
//		Mockito.when(returned.get(0)).thenReturn(util.getObjectForJSON(MOCK_USER, Player.class));
		assertEquals("{\"message\": \"Player added successfully.}" , playerepo.add(util.getObjectForJSON(MOCK_USER, Player.class)));
		//Works with commented out lines commented out- due to looking for the most recent Player to take the id of, mocking was proving unhelpful.
	}
	
	
	@Test
	public void deleteUserTest() {
		Mockito.when(manager.find(Player.class, 1l)).thenReturn(new Player(MOCK_USERNAME));
		Mockito.when(manager.find(Player.class, null)).thenReturn(null);
		
		assertEquals("{\"message\": \"Player deleted successfully.\"}", playerepo.delete(1l));
		assertEquals("{\"message\": \"Player not found.\"}", playerepo.delete(null));
	}

}