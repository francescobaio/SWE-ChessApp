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
	
	

	public void createTournament(String name, String province, String region, String startingDate, String endingDate,
			String timeControl, int numOfRounds, String refereeName, String managerName, int maxPlayers) {
		tournamentManager.createTournament(name, province, region, startingDate, endingDate, timeControl, numOfRounds, refereeName, managerName, maxPlayers);
	}
	
	public void removeTournament(Tournament t) {
		tournamentManager.removeTournament(t);
	}

	public void removePlayer(Player p) {
		
	}

	
	
	
	

}
