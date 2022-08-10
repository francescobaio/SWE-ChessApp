package domain_model;

public class Referee extends User {

	private Tournament activeTournament;

	public Referee(String name, String surname, Tournament activeTournament) {

		super(name, surname);
		this.activeTournament = activeTournament;

	}

	

}
