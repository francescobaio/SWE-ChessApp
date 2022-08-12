package domain_model;

import java.util.ArrayList;

public class TournamentManager extends User {

	private int phoneNumber;

	private ManagerTournamentCatalog managerCatalog;
	
	public TournamentManager() {}

	public TournamentManager(String name, String surname, int phoneNumber, ManagerTournamentCatalog managerCatalog) {

		super(name, surname);
		this.phoneNumber = phoneNumber;
		this.managerCatalog = managerCatalog;

	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public ManagerTournamentCatalog getManagerCatalog() {
		return managerCatalog;
	}

	public void createTournament(String name, String province, String region, String startingDate, String endingDate,
			String timeControl, int numOfRounds, String refereeName, String managerName,int maxPlayers) {

		Tournament t = new Tournament(name, province, region, startingDate, endingDate, timeControl, numOfRounds,
				refereeName, this.getName(),maxPlayers);
		managerCatalog.addTournament(t);

	}
	
	
	public void setAttributes(Object[] params) {
			
			super.setAttributes(params);
			phoneNumber = (int) params[2];
			managerCatalog = (ManagerTournamentCatalog)params[3];
		}
		

}
