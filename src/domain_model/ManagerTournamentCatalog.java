package domain_model;

import java.util.ArrayList;

public class ManagerTournamentCatalog extends Observable {

	private ArrayList<Tournament> managerTournaments = new ArrayList<Tournament>();

	public ManagerTournamentCatalog(Observer observer) {

		subscribe(observer);

	}

	public ArrayList<Tournament> getManagerTournaments() {
		return new ArrayList<Tournament>(managerTournaments);
	}

	public void addTournament(Tournament t) {
		managerTournaments.add(t);
		notify(t);
	}

	public void removeTournament(Tournament t) {
		managerTournaments.remove(t);
		notify(t);
	}

}
