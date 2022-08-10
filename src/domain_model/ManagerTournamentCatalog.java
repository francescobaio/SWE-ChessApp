package domain_model;

import java.util.ArrayList;

public class ManagerTournamentCatalog extends Observable {

	private ArrayList<Tournament> managerTournaments = new ArrayList<Tournament>();

	public ManagerTournamentCatalog(Observer observer) {

		subscribe(observer);

	}

	public ArrayList<Tournament> getManagerTournaments() {
		return managerTournaments;
	}

	public void addTournament(Tournament t) {
		managerTournaments.add(t);
		notify(t);
	}

	public void removeTournament(Tournament t) throws Exception {
		if (managerTournaments.remove(t)) {
			notify(t);
		} else {
			throw new Exception("No such Tournament found");
		}
	}
	
}
