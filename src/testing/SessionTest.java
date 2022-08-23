package testing;

import static org.junit.jupiter.api.Assertions.*;
import business_logic.*;
import domain_model.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 public class SessionTest {
	
	private static PlayerController playerController;
	private static TournamentManagerController tournamentManagerController;
	private static RefereeController refereeController;
	private static UserController userController;
	private static Session session;
	private static User user;
	private static GlobalTournamentCatalog tournamentCatalog;
	private static ManagerTournamentCatalog managerTournamentCatalog;
	
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		tournamentCatalog = new GlobalTournamentCatalog();
		session =  new Session();
		user =  new User("Mario","Rossi",tournamentCatalog,session);
		userController = new UserController(user);
		managerTournamentCatalog = new ManagerTournamentCatalog(tournamentCatalog);
		
	}

	

	@Test
	public void loginPlayerTest() {
		
		Object[] userParams = {"Mario","Rossi",tournamentCatalog,session,1850,21,"1N","ITA"};
		userController.signUp(userParams,UserType.Player,"marietto01", "BobbyFischer21");
		assertNotNull(session.getUserMap().get("marietto01"));
		assertNotNull(session.getAccounts().get("marietto01"));
		assertEquals("BobbyFischer21",session.getAccounts().get("marietto01"));
		
		Player p =  (Player) userController.login("marietto01", "BobbyFischer21");
		playerController  = new PlayerController(p);
		assertNotNull(p);
		
		
		playerController.deleteAccount("marietto01", "BobbyFischer21");
		assertNull(session.getAccounts().get("marietto01"));
		assertNull(session.getUserMap().get("marietto01"));
		
				
	}
	
	@Test
	public void loginTournamentManagerTest() {
		
		Object[] userParams = {"Erminio","Castaldi",tournamentCatalog,session,"3921854934",managerTournamentCatalog};
		userController.signUp(userParams,UserType.TournamentManager,"erminio39", "GarryKasparov82");
		assertNotNull(session.getUserMap().get("erminio39"));
		assertNotNull(session.getAccounts().get("erminio39"));
		assertEquals("GarryKasparov82",session.getAccounts().get("erminio39"));
		
		TournamentManager m = (TournamentManager) userController.login("erminio39", "GarryKasparov82");
		tournamentManagerController  = new TournamentManagerController(m);
		assertNotNull(m);
		
		
		tournamentManagerController.deleteAccount("erminio39", "GarryKasparov82");
		assertNull(session.getAccounts().get("erminio39"));
		assertNull(session.getUserMap().get("erminio39"));
		
				
	}

	
	@Test
	public void loginRefereeTest() {
		
		Object[] userParams = {"Fabrizio","Falsi",tournamentCatalog,session,null,"NA"};
		userController.signUp(userParams,UserType.Referee,"fabrizio65", "MagnusCarlsen57");
		assertNotNull(session.getUserMap().get("fabrizio65"));
		assertNotNull(session.getAccounts().get("fabrizio65"));
		assertEquals("MagnusCarlsen57",session.getAccounts().get("fabrizio65"));
		
		Referee r = (Referee) userController.login("fabrizio65", "MagnusCarlsen57");
		refereeController  = new RefereeController(r);
		assertNotNull(r);
		
		
		refereeController.deleteAccount("fabrizio65", "MagnusCarlsen57");
		assertNull(session.getAccounts().get("fabrizio65"));
		assertNull(session.getUserMap().get("fabrizio65"));
		
				
	}


}
