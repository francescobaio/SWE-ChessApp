package testing;

import static org.junit.jupiter.api.Assertions.*;
import business_logic.*;
import domain_model.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TournamentManagerTest {

	private static TournamentManagerController tournamentManagerController;
	private static TournamentManager tournamentManager;
	private static ManagerTournamentCatalog managerTournamentCatalog;
	private static GlobalTournamentCatalog tournamentCatalog;
	private static Player p1, p2;
	private static Tournament t1, t2;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {

		tournamentCatalog = new GlobalTournamentCatalog();
		managerTournamentCatalog = new ManagerTournamentCatalog(tournamentCatalog);
		p1 = new Player("Francesco", "Beccarini", tournamentCatalog, null, 2130, 21, "CM", "ITA");
		p2 = new Player("Cristiano", "Berrettoni", tournamentCatalog, null, 1759, 21, "2N", "ITA");

		tournamentManager = new TournamentManager("Erminio", "Castaldi", tournamentCatalog, null, "3928154921",
				managerTournamentCatalog);
		tournamentManagerController = new TournamentManagerController(tournamentManager);
		t1 = new Tournament("Campionato Provinciale Roma", "RM", "Lazio", "11/05/2021", "16/05/2021", "90+30", 7,
				"Mario Rossi", "Gino Bianchi");
		managerTournamentCatalog.addTournament(t1);
		t1.addPlayer(p1);
		t2 = new Tournament("Campionato Provinciale Virtebo", "VI", "Lazio", "11/05/2021", "16/05/2021", "90+30", 7,
				"Luigi Verdi", "Eugenio Latorre");
		managerTournamentCatalog.addTournament(t2);
	}

	@Test
	public void testCreateTournament() throws Exception {

		Tournament t = tournamentManagerController.createTournament("Campionato Provinciale Rieti", "RI", "Lazio",
				"31/08/2022", "06/09/2022", "90+30", 9, "Fabrizio Falsi", "Erminio Castaldi");

		assertNotNull(t);
		assertTrue(managerTournamentCatalog.getManagerTournaments().contains(t));
		assertTrue(p1.showTournaments().contains("Campionato Provinciale Rieti"));
		assertEquals(t, p1.showTournamentDetails("Campionato Provinciale Rieti"));

	}

	@Test
	public void testDeleteTournament() {

		tournamentManagerController.removeTournament(t1);
		assertFalse(managerTournamentCatalog.getManagerTournaments().contains(t1));
		assertFalse(p1.showTournaments().contains("Campionato Provinciale Roma"));

	}

	@Test
	public void testAddPlayer() {

		tournamentManagerController.addPlayer(t2, p2);
		assertTrue(t2.getListOfPlayers().contains(p2));
		assertTrue(p2.getSubscribedTournaments().contains(t2));

	}

	@Test
	public void testRemovePlayer() {

		tournamentManagerController.removePlayer(t2, p1);
		assertFalse(t2.getListOfPlayers().contains(p1));
		assertFalse(p1.getSubscribedTournaments().contains(t2));

	}

	@Test
	public void testEditInformation() {

		tournamentManagerController.editInformation(t1, "startingDate", "10/05/2021");
		assertTrue(t1.getStartingDate().equals("10/05/2021"));
		tournamentManagerController.editInformation(t1, "numOfRounds", 9);
		assertEquals(9, t1.getNumOfRounds());

	}

}
