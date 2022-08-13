package domain_model;

public class Referee extends ChessPerson {

	private Tournament activeTournament;
	
	public Referee() {}

	public Referee(String name, String surname,Session session,Tournament activeTournament) {

		super(name, surname,session);
		this.activeTournament = activeTournament;

	}

	
	public void setAttributes(Object[] params) {
		
		super.setAttributes(params);
		activeTournament = (Tournament)params[2];
		
	}
	
	

}
