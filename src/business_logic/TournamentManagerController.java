package business_logic;

import domain_model.Person;
import domain_model.Player;
import domain_model.Tournament;
import domain_model.TournamentManager;

public class TournamentManagerController extends ChessPersonController {

	private TournamentManager tournamentManager;

	public TournamentManagerController(TournamentManager tournamentManager) {
		super(tournamentManager);
		this.tournamentManager = tournamentManager;
	}

	public Tournament createTournament(String name, String province, String region, String startingDate,
			String endingDate, String timeControl, int numOfRounds, String refereeName, String managerName) {

		Tournament t = new Tournament(name, province, region, startingDate, endingDate, timeControl, numOfRounds,
				refereeName, tournamentManager.getName());
		tournamentManager.addTournament(t);
		return t;

	}

	public void addPlayer(Tournament t, Player p) {
		try {

			t.addPlayer(p);
			p.subscribeTournament(t);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void editInformation(Tournament t, String nameInformation, Object information) {
		switch (nameInformation) {
		case "name":
			t.setName((String) information);
			break;
		case "province":
			t.setProvince((String) information);
			break;
		case "region":
			t.setRegion((String) information);
			break;
		case "startingDate":
			t.setStartingDate((String) information);
			break;
		case "endingDate":
			t.setEndingDate((String) information);
			break;
		case "timeControl":
			t.setTimeControl((String) information);
			break;
		case "numOfRounds":
			t.setNumOfRounds((int) information);
			break;
		case "refereeName":
			t.setRefereeName((String) information);
			break;
		}

	}

	public void removeTournament(Tournament t) {
		tournamentManager.removeTournament(t);
	}

	public void removePlayer(Tournament t, Player p) {
		t.removePlayer(p);
		p.unsubscribeTournament(t);
	}

}
