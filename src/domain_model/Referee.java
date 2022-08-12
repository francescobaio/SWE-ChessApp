package domain_model;

public class Referee extends User {

	private Tournament activeTournament;
	
	public Referee() {}

	public Referee(String name, String surname,Tournament activeTournament) {

		super(name, surname);
		this.activeTournament = activeTournament;

	}

	
	public void setAttributes(Object[] params) {
		
		super.setAttributes(params);
		activeTournament = (Tournament)params[2];
		
	}
	
	

}
