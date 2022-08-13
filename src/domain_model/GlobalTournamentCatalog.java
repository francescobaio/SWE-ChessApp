package domain_model;

import java.util.ArrayList;
import java.util.HashSet;

public class GlobalTournamentCatalog implements Observer, TournamentDisplayer {

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

	@Override
	public ArrayList<Tournament> displayTournaments() {
		
		ArrayList<Tournament> tournaments = new ArrayList<Tournament>(listOfTournaments);
		tournaments.sort(new DateComparator());
		return tournaments;
	}

}
