package domain_model;

public class Referee extends ChessPerson {

	private Tournament activeTournament;
	
	public Referee() {}

	public Referee(String name, String surname,TournamentDisplayer tournamentDisplayer,AccountRemover accountRemover,Tournament activeTournament) {

		super(name, surname,tournamentDisplayer,accountRemover);
		this.activeTournament = activeTournament;

	}

	
	public void setAttributes(Object[] params) {
		
		super.setAttributes(params);
		activeTournament = (Tournament)params[4];
		
	}
	
	
	
	

}
