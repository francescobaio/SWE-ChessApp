package domain_model;

public class TournamentObserver implements Observer {

	@Override
	public void update(Object arg) {

		if (GlobalTournamentCatalog.getInstance().getListOfTournaments().contains(arg)) {

			GlobalTournamentCatalog.getInstance().removeTournament((Tournament) arg);

		} else {
			GlobalTournamentCatalog.getInstance().addTournament((Tournament) arg);
		}
	}
}
