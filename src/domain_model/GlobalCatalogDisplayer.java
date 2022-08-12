package domain_model;

import java.util.ArrayList;

public class GlobalCatalogDisplayer {

	private GlobalTournamentCatalog catalog;

	private static GlobalCatalogDisplayer instance = null;

	private GlobalCatalogDisplayer(GlobalTournamentCatalog catalog) {
		this.catalog = catalog;
	}

	public static GlobalCatalogDisplayer createInstance(GlobalTournamentCatalog catalog) throws Exception {

		if (instance == null) {

			instance = new GlobalCatalogDisplayer(catalog);

		} else {

			throw new Exception("Displayer already exists.");
		}

		return instance;
	}

	public static GlobalCatalogDisplayer getInstance() throws Exception {

		if (instance == null) {
			throw new Exception("Displayer doesn't exist.");
		} else {
			return instance;
		}

	}

	public ArrayList<Tournament> displayTournaments() {

		ArrayList<Tournament> tournaments = new ArrayList<Tournament>(catalog.getListOfTournaments());
		tournaments.sort(new DateComparator()); 
		return tournaments;

	}

}












