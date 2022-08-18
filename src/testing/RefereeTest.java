package testing;

import static org.junit.jupiter.api.Assertions.*;
import domain_model.*;
import business_logic.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

	private static Referee referee;
	private static RefereeController refereeController;
	private static Tournament t;
	private static Player p6;
	private static PlayerController pc6;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {

		t = new Tournament("Torneo sociale", "RI", "Lazio", "28/02/2022", "02/05/2022", "90+30", 5, "Fabrizio Falsi",
				"Erminio Castaldi");

		referee = new Referee("Fabrizio", "Falsi", null, null, t, "IA");
		refereeController = new RefereeController(referee);
		Player p1 = new Player("Leonardo", "Petrilli", null, null, 1922, 22, "1N", "ITA");
		PlayerController pc1 = new PlayerController(p1);
		Player p2 = new Player("Francesco", "Giovanzanti", null, null, 1792, 27, "1N", "ITA");
		PlayerController pc2 = new PlayerController(p2);
		Player p3 = new Player("Ivano", "Fioravanti", null, null, 1780, 61, "2N", "ITA");
		PlayerController pc3 = new PlayerController(p3);
		Player p4 = new Player("Filippo", "Melchiorre", null, null, 1675, 16, "2N", "ITA");
		PlayerController pc4 = new PlayerController(p4);
		Player p5 = new Player("Andrea", "Fiore", null, null, 1619, 29, "2N", "ITA");
		PlayerController pc5 = new PlayerController(p5);
		p6 = new Player("Massimo", "Bianchini", null, null, 1562, 70, "3N", "ITA");
		pc6 = new PlayerController(p6);
		Player p7 = new Player("Filippo", "Cavoli", null, null, 1440, 14, "NC", "ITA");
		PlayerController pc7 = new PlayerController(p7);
		Player p8 = new Player("Stefano", "Cavoli", null, null, 1337, 18, "NC", "ITA");
		PlayerController pc8 = new PlayerController(p8);
		Player p9 = new Player("Mario", "Giovanzanti", null, null, 1368, 65, "3N", "ITA");
		PlayerController pc9 = new PlayerController(p9);
		Player p10 = new Player("Lorenzo", "Caputi", null, null, 1391, 15, "NC", "ITA");
		PlayerController pc10 = new PlayerController(p10);
		Player p11 = new Player("Cristian", "Spadoni", null, null, 1440, 15, "NC", "ITA");
		PlayerController pc11 = new PlayerController(p11);
		Player p12 = new Player("Emanuele", "Marini", null, null, 1440, 13, "NC", "ITA");
		PlayerController pc12 = new PlayerController(p12);
		Player p13 = new Player("Erminio", "Castaldi", null, null, 1212, 82, "NC", "ITA");
		PlayerController pc13 = new PlayerController(p13);
		Player p14 = new Player("Filippo", "Sciarra", null, null, 999, 15, "NC", "ITA");
		PlayerController pc14 = new PlayerController(p14);
		Player p15 = new Player("Alejandro", "Gomez", null, null, 1440, 50, "NC", "ITA");
		PlayerController pc15 = new PlayerController(p15);
		Player p16 = new Player("Raffaele", "Gentile", null, null, 1311, 64, "NC", "ITA");
		PlayerController pc16 = new PlayerController(p16);

		pc1.subscribeTournament(t);
		pc2.subscribeTournament(t);
		pc3.subscribeTournament(t);
		pc4.subscribeTournament(t);
		pc5.subscribeTournament(t);
		pc6.subscribeTournament(t);
		pc7.subscribeTournament(t);
		pc8.subscribeTournament(t);
		pc9.subscribeTournament(t);
		pc10.subscribeTournament(t);
		pc11.subscribeTournament(t);
		pc12.subscribeTournament(t);
		pc13.subscribeTournament(t);
		pc14.subscribeTournament(t);
		pc15.subscribeTournament(t);
		pc16.subscribeTournament(t);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testTournament() {

		String[][] firstRoundStandings = { { "1", "1.0", "NC", "Lorenzo Caputi", "1391", "2180", "ITA", "1780.0" },
				{ "2", "1.0", "3N", "Mario Giovanzanti", "1368", "2075", "ITA", "1675.0" },
				{ "3", "1.0", "NC", "Stefano Cavoli", "1337", "2019", "ITA", "1619.0" },
				{ "4", "1.0", "1N", "Leonardo Petrilli", "1922", "1840", "ITA", "1440.0" },
				{ "5", "1.0", "1N", "Francesco Giovanzanti", "1792", "1840", "ITA", "1440.0" },
				{ "6", "1.0", "NC", "Erminio Castaldi", "1212", "1840", "ITA", "1440.0" },
				{ "7", "1.0", "3N", "Massimo Bianchini", "1562", "1711", "ITA", "1311.0" },
				{ "8", "1.0", "NC", "Cristian Spadoni", "1440", "1399", "ITA", "999.0" },
				{ "9", "0.0", "NC", "Emanuele Marini", "1440", "1522", "ITA", "1922.0" },
				{ "10", "0.0", "NC", "Alejandro Gomez", "1440", "1392", "ITA", "1792.0" },
				{ "11", "0.0", "NC", "Raffaele Gentile", "1311", "1162", "ITA", "1562.0" },
				{ "12", "0.0", "NC", "Filippo Sciarra", "999", "1040", "ITA", "1440.0" },
				{ "13", "0.0", "2N", "Ivano Fioravanti", "1780", "991", "ITA", "1391.0" },
				{ "14", "0.0", "2N", "Filippo Melchiorre", "1675", "968", "ITA", "1368.0" },
				{ "15", "0.0", "2N", "Andrea Fiore", "1619", "937", "ITA", "1337.0" },
				{ "16", "0.0", "NC", "Filippo Cavoli", "1440", "812", "ITA", "1212.0" } };

		String[][] secondRoundScoreboard = { { "1", "Lorenzo Caputi", "Francesco Giovanzanti", "-" },
				{ "2", "Erminio Castaldi", "Mario Giovanzanti", "-" },
				{ "3", "Stefano Cavoli", "Massimo Bianchini", "-" },
				{ "4", "Cristian Spadoni", "Leonardo Petrilli", "-" },
				{ "5", "Emanuele Marini", "Ivano Fioravanti", "-" },
				{ "6", "Filippo Melchiorre", "Alejandro Gomez", "-" }, { "7", "Andrea Fiore", "Raffaele Gentile", "-" },
				{ "8", "Filippo Cavoli", "Filippo Sciarra", "-" } };

		String[][] secondRoundStandings = { { "1", "2.0", "1N", "Leonardo Petrilli", "1922", "1840", "ITA", "1440.0" },
				{ "2", "2.0", "1N", "Francesco Giovanzanti", "1792", "1815", "ITA", "1415.5" },
				{ "3", "2.0", "3N", "Massimo Bianchini", "1562", "1724", "ITA", "1324.0" },
				{ "4", "1.5", "3N", "Mario Giovanzanti", "1368", "1643", "ITA", "1443.5" },
				{ "5", "1.5", "NC", "Erminio Castaldi", "1212", "1604", "ITA", "1404.0" },
				{ "6", "1.0", "NC", "Lorenzo Caputi", "1391", "1786", "ITA", "1786.0" },
				{ "7", "1.0", "NC", "Alejandro Gomez", "1440", "1733", "ITA", "1733.5" },
				{ "8", "1.0", "NC", "Stefano Cavoli", "1337", "1590", "ITA", "1590.5" },
				{ "9", "1.0", "NC", "Cristian Spadoni", "1440", "1460", "ITA", "1460.5" },
				{ "10", "1.0", "NC", "Filippo Sciarra", "999", "1440", "ITA", "1440.0" },
				{ "11", "1.0", "2N", "Ivano Fioravanti", "1780", "1415", "ITA", "1415.5" },
				{ "12", "0.5", "NC", "Raffaele Gentile", "1311", "1390", "ITA", "1590.5" },
				{ "13", "0.5", "2N", "Andrea Fiore", "1619", "1124", "ITA", "1324.0" },
				{ "14", "0.0", "NC", "Emanuele Marini", "1440", "1451", "ITA", "1851.0" },
				{ "15", "0.0", "2N", "Filippo Melchiorre", "1675", "1004", "ITA", "1404.0" },
				{ "16", "0.0", "NC", "Filippo Cavoli", "1440", "705", "ITA", "1105.5" } };

		refereeController.startTournament();
		assertNotNull(t.getStandings());
		assertNotNull(t.getScoreboard());

		String[] results = { "1-0", "0-1", "0-1", "1-0", "0-1", "0-1", "0-1", "0-1" };
		refereeController.uploadResults(results);

		for (int i = 0; i < 8; i++) {
			assertTrue(t.getScoreboard().getBoard()[i + 1][3].equals(results[i]));
		}

		refereeController.updateStandings();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t.getStandings().getStandings()[i + 1][j].equals(firstRoundStandings[i][j]));
			}
		}

		refereeController.publishNewRound();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				assertTrue(t.getScoreboard().getBoard()[i + 1][j].equals(secondRoundScoreboard[i][j]));
			}
		}

		String[] results2 = { "0-1", "0.5-0.5", "0-1", "0-1", "0-1", "0-1", "0.5-0.5", "0-1" };
		refereeController.uploadResults(results2);

		for (int i = 0; i < 8; i++) {
			assertTrue(t.getScoreboard().getBoard()[i + 1][3].equals(results2[i]));
		}
		
		refereeController.updateStandings();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t.getStandings().getStandings()[i + 1][j].equals(secondRoundStandings[i][j]));
			}
		}
		
		

	}

}