package domain_model;

import java.util.ArrayList;

 public class TournamentManager extends ChessPerson {

	private String phoneNumber;

	private ManagerTournamentCatalog managerCatalog;
	
	
	public Tournament createTournament(String name, String province, String region, String startingDate, String endingDate,
			String timeControl, int numOfRounds, String refereeName, String managerName) {

		Tournament t = new Tournament(name, province, region, startingDate, endingDate, timeControl, numOfRounds,
				refereeName, this.getName());
		managerCatalog.addTournament(t);
		return t;

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

	public ManagerTournamentCatalog getManagerCatalog() {
		return managerCatalog;
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
