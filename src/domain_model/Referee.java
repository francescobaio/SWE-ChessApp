package domain_model;

import java.util.ArrayList;

public class Referee extends ChessPerson {

	private Tournament activeTournament;
	private String title;

	public Referee() {
	}

	public Referee(String name, String surname, TournamentDisplayer tournamentDisplayer, AccountRemover accountRemover,
			Tournament activeTournament, String title) {

		super(name, surname, tournamentDisplayer, accountRemover);
		this.activeTournament = activeTournament;
		this.title = title;

	}

	public void setAttributes(Object[] params) {

		super.setAttributes(params);
		activeTournament = (Tournament) params[4];
		title = (String) params[5];

	}

	public void startTournament() {
		activeTournament.start();
	}

	public void updateStandings() {
		activeTournament.update();
	}

	public void uploadResults(String[] results) {
		activeTournament.uploadResults(results);
	}
	
	public void publishNewRound() {
		activeTournament.publishNewRound();
	}
	
	
	
	
	
	
	

}
