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

	public Tournament createTournament(String name, String province, String region, String startingDate, String endingDate,
			String timeControl, int numOfRounds, String refereeName, String managerName) {
		return tournamentManager.createTournament(name, province, region, startingDate, endingDate, timeControl, numOfRounds,
				refereeName, managerName);
	}

	public void removeTournament(Tournament t) {
		tournamentManager.removeTournament(t);
	}

	public void removePlayer(Tournament t, Player p) {
		t.removePlayer(p);
		p.unsubscribeTournament(t);
	}

	public void addPlayer(Tournament t, Player p) {
		try {

			t.addPlayer(p);
			p.subscribeTournament(t);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void editInformation(Tournament t ,String nameInformation, Object information) {
		t.editInformation(nameInformation, information);
	}
	
	

}
