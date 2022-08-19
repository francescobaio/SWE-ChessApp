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

	private static Referee r1, r2;
	private static RefereeController rc1, rc2;
	private static Tournament t, t2;
	private static Player p6;
	private static PlayerController pc6;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {

		t = new Tournament("Torneo sociale", "RI", "Lazio", "28/02/2022", "02/05/2022", "90+30", 2, "Fabrizio Falsi",
				"Erminio Castaldi");
		t2 = new Tournament("Campionato Provinciale Rieti", "RI", "Lazio", "12/02/2022", "14/05/2022", "90+30", 2,
				"Giuseppe Bacigalupi", "Erminio Castaldi");

		r1 = new Referee("Fabrizio", "Falsi", null, null, t, "AN");
		rc1 = new RefereeController(r1);

		r2 = new Referee("Giuseppe", "Bacigalupi", null, null, t2, "AN");
		rc2 = new RefereeController(r2);

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

		pc1.subscribeTournament(t2);
		pc2.subscribeTournament(t2);
		pc3.subscribeTournament(t2);
		pc4.subscribeTournament(t2);
		pc5.subscribeTournament(t2);
		pc7.subscribeTournament(t2);
		pc8.subscribeTournament(t2);
		pc9.subscribeTournament(t2);
		pc10.subscribeTournament(t2);
		pc11.subscribeTournament(t2);
		pc12.subscribeTournament(t2);
		pc13.subscribeTournament(t2);
		pc14.subscribeTournament(t2);
		pc15.subscribeTournament(t2);
		pc16.subscribeTournament(t2);
	}

	@AfterEach
	public void setUp() throws InterruptedException {

		System.out.println(t2.getListOfPlayers().get(1).getName());

		t2.getListOfPlayers().get(0).setRatingElo(1922);
		t2.getListOfPlayers().get(1).setRatingElo(1792);
		t2.getListOfPlayers().get(2).setRatingElo(1780);
		t2.getListOfPlayers().get(3).setRatingElo(1675);
		t2.getListOfPlayers().get(4).setRatingElo(1619);
		t2.getListOfPlayers().get(5).setRatingElo(1440);
		t2.getListOfPlayers().get(6).setRatingElo(1337);
		t2.getListOfPlayers().get(7).setRatingElo(1368);
		t2.getListOfPlayers().get(8).setRatingElo(1391);
		t2.getListOfPlayers().get(9).setRatingElo(1440);
		t2.getListOfPlayers().get(10).setRatingElo(1440);
		t2.getListOfPlayers().get(11).setRatingElo(1212);
		t2.getListOfPlayers().get(12).setRatingElo(999);
		t2.getListOfPlayers().get(13).setRatingElo(1440);
		t2.getListOfPlayers().get(14).setRatingElo(1311);

		System.out.println(t2.getListOfPlayers().get(1).getName());

	}

	@Test
	public void testEvenPlayersTournament() {

		String[][] initialRoundStandings = { { "1", "0", "1N", "Leonardo Petrilli", "1922", "1922", "ITA", "0" },
				{ "2", "0", "1N", "Francesco Giovanzanti", "1792", "1792", "ITA", "0" },
				{ "3", "0", "2N", "Ivano Fioravanti", "1780", "1780", "ITA", "0" },
				{ "4", "0", "2N", "Filippo Melchiorre", "1675", "1675", "ITA", "0" },
				{ "5", "0", "2N", "Andrea Fiore", "1619", "1619", "ITA", "0" },
				{ "6", "0", "3N", "Massimo Bianchini", "1562", "1562", "ITA", "0" },
				{ "7", "0", "NC", "Filippo Cavoli", "1440", "1440", "ITA", "0" },
				{ "8", "0", "NC", "Cristian Spadoni", "1440", "1440", "ITA", "0" },
				{ "9", "0", "NC", "Emanuele Marini", "1440", "1440", "ITA", "0" },
				{ "10", "0", "NC", "Alejandro Gomez", "1440", "1440", "ITA", "0" },
				{ "11", "0", "NC", "Lorenzo Caputi", "1391", "1391", "ITA", "0" },
				{ "12", "0", "3N", "Mario Giovanzanti", "1368", "1368", "ITA", "0" },
				{ "13", "0", "NC", "Stefano Cavoli", "1337", "1337", "ITA", "0" },
				{ "14", "0", "NC", "Raffaele Gentile", "1311", "1311", "ITA", "0" },
				{ "15", "0", "NC", "Erminio Castaldi", "1212", "1212", "ITA", "0" },
				{ "16", "0", "NC", "Filippo Sciarra", "999", "999", "ITA", "0" } };

		String[][] firstRoundScoreboard = { { "1", "Leonardo Petrilli", "Emanuele Marini", "-" },
				{ "2", "Alejandro Gomez", "Francesco Giovanzanti", "-" },
				{ "3", "Ivano Fioravanti", "Lorenzo Caputi", "-" },
				{ "4", "Mario Giovanzanti", "Filippo Melchiorre", "-" }, { "5", "Andrea Fiore", "Stefano Cavoli", "-" },
				{ "6", "Raffaele Gentile", "Massimo Bianchini", "-" },
				{ "7", "Filippo Cavoli", "Erminio Castaldi", "-" },
				{ "8", "Filippo Sciarra", "Cristian Spadoni", "-" } };

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
				{ "2", "2.0", "1N", "Francesco Giovanzanti", "1792", "1816", "ITA", "1415.5" },
				{ "3", "2.0", "3N", "Massimo Bianchini", "1562", "1724", "ITA", "1324.0" },
				{ "4", "1.5", "3N", "Mario Giovanzanti", "1368", "1644", "ITA", "1443.5" },
				{ "5", "1.5", "NC", "Erminio Castaldi", "1212", "1604", "ITA", "1404.0" },
				{ "6", "1.0", "NC", "Lorenzo Caputi", "1391", "1786", "ITA", "1786.0" },
				{ "7", "1.0", "NC", "Alejandro Gomez", "1440", "1734", "ITA", "1733.5" },
				{ "8", "1.0", "NC", "Stefano Cavoli", "1337", "1591", "ITA", "1590.5" },
				{ "9", "1.0", "NC", "Cristian Spadoni", "1440", "1461", "ITA", "1460.5" },
				{ "10", "1.0", "NC", "Filippo Sciarra", "999", "1440", "ITA", "1440.0" },
				{ "11", "1.0", "2N", "Ivano Fioravanti", "1780", "1416", "ITA", "1415.5" },
				{ "12", "0.5", "NC", "Raffaele Gentile", "1311", "1391", "ITA", "1590.5" },
				{ "13", "0.5", "2N", "Andrea Fiore", "1619", "1124", "ITA", "1324.0" },
				{ "14", "0.0", "NC", "Emanuele Marini", "1440", "1451", "ITA", "1851.0" },
				{ "15", "0.0", "2N", "Filippo Melchiorre", "1675", "1004", "ITA", "1404.0" },
				{ "16", "0.0", "NC", "Filippo Cavoli", "1440", "706", "ITA", "1105.5" } };

		rc1.startTournament();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t.getStandings().getStandings()[i + 1][j].equals(initialRoundStandings[i][j]));
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				assertTrue(t.getScoreboard().getBoard()[i + 1][j].equals(firstRoundScoreboard[i][j]));
			}
		}

		String[] results = { "1-0", "0-1", "0-1", "1-0", "0-1", "0-1", "0-1", "0-1" };
		rc1.uploadResults(results);

		for (int i = 0; i < 8; i++) {
			assertTrue(t.getScoreboard().getBoard()[i + 1][3].equals(results[i]));
		}

		rc1.updateStandings();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t.getStandings().getStandings()[i + 1][j].equals(firstRoundStandings[i][j]));
			}
		}

		rc1.publishNewRound();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				assertTrue(t.getScoreboard().getBoard()[i + 1][j].equals(secondRoundScoreboard[i][j]));
			}
		}

		String[] results2 = { "0-1", "0.5-0.5", "0-1", "0-1", "0-1", "0-1", "0.5-0.5", "0-1" };
		rc1.uploadResults(results2);

		for (int i = 0; i < 8; i++) {
			assertTrue(t.getScoreboard().getBoard()[i + 1][3].equals(results2[i]));
		}

		rc1.updateStandings();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t.getStandings().getStandings()[i + 1][j].equals(secondRoundStandings[i][j]));
			}
		}

		// verify new ratingElo for the player Massimo Bianchini
		assertEquals(1570, p6.getRatingElo());
		// verify his performance at this tournament
		assertEquals(1724, pc6.showStatistics().getLastPerformance());
		// verify other statistics..
		assertEquals(2, pc6.showStatistics().getNumOfWins());
		assertEquals(2, pc6.showStatistics().getNumOfGames());
		assertEquals(0, pc6.showStatistics().getNumOfDraws());
		assertEquals(0, pc6.showStatistics().getNumOfDefeats());
		assertEquals(1570, pc6.showStatistics().getHighestRatingElo());
		assertEquals(1562, pc6.showStatistics().getLowestRatingElo());
	}

	@Test
	public void testOddPlayersTournament() {

		String[][] initialRoundStandings = { { "1", "0", "1N", "Leonardo Petrilli", "1922", "1922", "ITA", "0" },
				{ "2", "0", "1N", "Francesco Giovanzanti", "1792", "1792", "ITA", "0" },
				{ "3", "0", "2N", "Ivano Fioravanti", "1780", "1780", "ITA", "0" },
				{ "4", "0", "2N", "Filippo Melchiorre", "1675", "1675", "ITA", "0" },
				{ "5", "0", "2N", "Andrea Fiore", "1619", "1619", "ITA", "0" },
				{ "6", "0", "NC", "Filippo Cavoli", "1440", "1440", "ITA", "0" },
				{ "7", "0", "NC", "Cristian Spadoni", "1440", "1440", "ITA", "0" },
				{ "8", "0", "NC", "Emanuele Marini", "1440", "1440", "ITA", "0" },
				{ "9", "0", "NC", "Alejandro Gomez", "1440", "1440", "ITA", "0" },
				{ "10", "0", "NC", "Lorenzo Caputi", "1391", "1391", "ITA", "0" },
				{ "11", "0", "3N", "Mario Giovanzanti", "1368", "1368", "ITA", "0" },
				{ "12", "0", "NC", "Stefano Cavoli", "1337", "1337", "ITA", "0" },
				{ "13", "0", "NC", "Raffaele Gentile", "1311", "1311", "ITA", "0" },
				{ "14", "0", "NC", "Erminio Castaldi", "1212", "1212", "ITA", "0" },
				{ "15", "0", "NC", "Filippo Sciarra", "999", "999", "ITA", "0" } };

		String[][] firstRoundScoreboard = { { "1", "Leonardo Petrilli", "Emanuele Marini", "-" },
				{ "2", "Alejandro Gomez", "Francesco Giovanzanti", "-" },
				{ "3", "Ivano Fioravanti", "Lorenzo Caputi", "-" },
				{ "4", "Mario Giovanzanti", "Filippo Melchiorre", "-" }, { "5", "Andrea Fiore", "Stefano Cavoli", "-" },
				{ "6", "Raffaele Gentile", "Filippo Cavoli", "-" },
				{ "7", "Cristian Spadoni", "Erminio Castaldi", "-" }, { "8", "Filippo Sciarra", "_BYE_", "-" } };

		String[][] firstRoundStandings = { { "1", "1.0", "NC", "Lorenzo Caputi", "1391", "2180", "ITA", "1780.0" },
				{ "2", "1.0", "3N", "Mario Giovanzanti", "1368", "2075", "ITA", "1675.0" },
				{ "3", "1.0", "NC", "Stefano Cavoli", "1337", "2019", "ITA", "1619.0" },
				{ "4", "1.0", "1N", "Leonardo Petrilli", "1922", "1840", "ITA", "1440.0" },
				{ "5", "1.0", "1N", "Francesco Giovanzanti", "1792", "1840", "ITA", "1440.0" },
				{ "6", "1.0", "NC", "Erminio Castaldi", "1212", "1840", "ITA", "1440.0" },
				{ "7", "1.0", "NC", "Filippo Cavoli", "1440", "1711", "ITA", "1311.0" },
				{ "8", "1.0", "NC", "Filippo Sciarra", "999", "400", "ITA", "0.0" },
				{ "9", "0.0", "NC", "Emanuele Marini", "1440", "1522", "ITA", "1922.0" },
				{ "10", "0.0", "NC", "Alejandro Gomez", "1440", "1392", "ITA", "1792.0" },
				{ "11", "0.0", "NC", "Raffaele Gentile", "1311", "1040", "ITA", "1440.0" },
				{ "12", "0.0", "2N", "Ivano Fioravanti", "1780", "991", "ITA", "1391.0" },
				{ "13", "0.0", "2N", "Filippo Melchiorre", "1675", "968", "ITA", "1368.0" },
				{ "14", "0.0", "2N", "Andrea Fiore", "1619", "937", "ITA", "1337.0" },
				{ "15", "0.0", "NC", "Cristian Spadoni", "1440", "812", "ITA", "1212.0" } };

		String[][] secondRoundScoreboard = { { "1", "Lorenzo Caputi", "Francesco Giovanzanti", "-" },
				{ "2", "Erminio Castaldi", "Mario Giovanzanti", "-" }, { "3", "Stefano Cavoli", "Filippo Cavoli", "-" },
				{ "4", "Filippo Sciarra", "Leonardo Petrilli", "-" },
				{ "5", "Emanuele Marini", "Ivano Fioravanti", "-" },
				{ "6", "Filippo Melchiorre", "Alejandro Gomez", "-" }, { "7", "Andrea Fiore", "Raffaele Gentile", "-" },
				{ "8", "Cristian Spadoni", "_BYE_", "-" } };

		String[][] secondRoundStandings = {
				{ "1", "2.0", "1N", "Francesco Giovanzanti", "1792", "1816", "ITA", "1415.5" },
				{ "2", "2.0", "NC", "Filippo Cavoli", "1440", "1724", "ITA", "1324.0" },
				{ "3", "2.0", "1N", "Leonardo Petrilli", "1922", "1620", "ITA", "1219.5" },
				{ "4", "1.5", "3N", "Mario Giovanzanti", "1368", "1644", "ITA", "1443.5" },
				{ "5", "1.5", "NC", "Erminio Castaldi", "1212", "1604", "ITA", "1404.0" },
				{ "6", "1.0", "NC", "Lorenzo Caputi", "1391", "1786", "ITA", "1786.0" },
				{ "7", "1.0", "NC", "Alejandro Gomez", "1440", "1734", "ITA", "1733.5" },
				{ "8", "1.0", "NC", "Stefano Cavoli", "1337", "1530", "ITA", "1529.5" },
				{ "9", "1.0", "2N", "Ivano Fioravanti", "1780", "1416", "ITA", "1415.5" },
				{ "10", "1.0", "NC", "Filippo Sciarra", "999", "961", "ITA", "961.0" },
				{ "11", "1.0", "NC", "Cristian Spadoni", "1440", "606", "ITA", "606.0" },
				{ "12", "0.5", "NC", "Raffaele Gentile", "1311", "1330", "ITA", "1529.5" },
				{ "13", "0.5", "2N", "Andrea Fiore", "1619", "1124", "ITA", "1324.0" },
				{ "14", "0.0", "NC", "Emanuele Marini", "1440", "1451", "ITA", "1851.0" },
				{ "15", "0.0", "2N", "Filippo Melchiorre", "1675", "1004", "ITA", "1404.0" } };

		rc2.startTournament();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t2.getStandings().getStandings()[i + 1][j].equals(initialRoundStandings[i][j]));
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				assertTrue(t2.getScoreboard().getBoard()[i + 1][j].equals(firstRoundScoreboard[i][j]));
			}
		}

		String[] results = { "1-0", "0-1", "0-1", "1-0", "0-1", "0-1", "0-1", "1F-0F" };
		rc2.uploadResults(results);

		for (int i = 0; i < 8; i++) {
			assertTrue(t2.getScoreboard().getBoard()[i + 1][3].equals(results[i]));
		}

		rc2.updateStandings();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t2.getStandings().getStandings()[i + 1][j].equals(firstRoundStandings[i][j]));
			}
		}

		rc2.publishNewRound();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				assertTrue(t2.getScoreboard().getBoard()[i + 1][j].equals(secondRoundScoreboard[i][j]));
			}
		}

		String[] results2 = { "0-1", "0.5-0.5", "0-1", "0-1", "0-1", "0-1", "0.5-0.5", "1F-0F" };
		rc2.uploadResults(results2);

		for (int i = 0; i < 8; i++) {
			assertTrue(t2.getScoreboard().getBoard()[i + 1][3].equals(results2[i]));
		}

		rc2.updateStandings();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 8; j++) {
				assertTrue(t2.getStandings().getStandings()[i + 1][j].equals(secondRoundStandings[i][j]));
			}
		}

	}

}