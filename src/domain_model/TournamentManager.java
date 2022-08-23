package domain_model;

import java.util.ArrayList;

 public class TournamentManager extends ChessPerson {

	private String phoneNumber;

	private ManagerTournamentCatalog managerCatalog;
	
	
	public void addTournament(Tournament tournament) {
		managerCatalog.addTournament(tournament);
	}


	public TournamentManager() {}

	public TournamentManager(String name, String surname, TournamentDisplayer tournamentDisplayer,
			AccountRemover accountRemover, String phoneNumber, ManagerTournamentCatalog managerCatalog) {

		super(name, surname, tournamentDisplayer, accountRemover);
		this.phoneNumber = phoneNumber;
		this.managerCatalog = managerCatalog;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	public void removeTournament(Tournament t) {
		managerCatalog.removeTournament(t);
	}

	public void setAttributes(Object[] params) {

		super.setAttributes(params);
		phoneNumber = (String) params[4];
		managerCatalog = (ManagerTournamentCatalog) params[5];
	}

}
