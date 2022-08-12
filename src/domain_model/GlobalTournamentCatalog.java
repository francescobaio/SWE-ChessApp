package domain_model;

import java.util.HashSet;

public class GlobalTournamentCatalog implements Observer {

	private HashSet<Tournament> listOfTournaments = new HashSet<>();

	public GlobalTournamentCatalog() {
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

	@Override
	public void update(Object arg) {

		if (listOfTournaments.contains(arg)) {

			removeTournament((Tournament) arg);

		} else {

			addTournament((Tournament) arg);
		}
	}

}
