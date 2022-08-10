package domain_model;

import java.util.HashSet;

public class GlobalTournamentCatalog {
	

	private HashSet<Tournament> listOfTournaments = new HashSet<>();

	private static GlobalTournamentCatalog instance = null;

	private GlobalTournamentCatalog() {}

	public static GlobalTournamentCatalog getInstance() {

		if (instance == null) {
			instance = new GlobalTournamentCatalog();
		}
		return instance;
	}

	public HashSet<Tournament> getListOfTournaments() {
		// defensive copy
		return new HashSet<>(listOfTournaments);
	}

	public void removeTournament(Tournament t) {

		listOfTournaments.remove(t);

	}

	public void addTournament(Tournament t) {

		listOfTournaments.add(t);

	}

}
