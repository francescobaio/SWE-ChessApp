package testing;

import static org.junit.jupiter.api.Assertions.*;
import domain_model.*;
import business_logic.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

	private static PlayerController playerController;
	private static Player player;
	private static Tournament tournament;
	private static Referee referee;
	private static RefereeController refereeController;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {

		player = new Player("Francesco", "Beccarini", null, null, 2130, 21, "CM", "ITA");
		playerController = new PlayerController(player);
		tournament = new Tournament("Campionato Provinciale Rieti", "RI", "Lazio", "31/08/2022", "06/09/2022", "90+30",
				9, "Fabrizio Falsi", "Erminio Castaldi");
		referee = new Referee("Fabrizio", "Falsi", null, null, tournament, "AN");
		refereeController = new RefereeController(referee);

	}

	@Test
	public void testSubscribe() {

		playerController.subscribeTournament(tournament);
		assertEquals(tournament, player.getSubscribedTournaments().get(0));
		assertEquals(player, tournament.getListOfPlayers().get(0));

		playerController.unsubscribeTournament(tournament);
		assertEquals(0, player.getSubscribedTournaments().size());
		assertEquals(0, tournament.getListOfPlayers().size());

	}

	@Test
	public void testShowCurrentTournament() {

		playerController.subscribeTournament(tournament);
		refereeController.startTournament();
		assertNotNull(playerController.showCurrentTournament());
		playerController.unsubscribeTournament(tournament);

	}

}
