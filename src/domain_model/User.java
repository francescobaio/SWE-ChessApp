package domain_model;

import java.util.ArrayList;

public class User {

	private String name;
	private String surname;
	
	
	
	public User() {}

	public User(String name, String surname) {

		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	
	public void setAttributes(Object[] params) {
		
		name = (String) params[0];
		surname = (String)params[1];
		
	}	

	
	public ArrayList<String> showTournaments() throws Exception {

		ArrayList<Tournament> tournaments = GlobalCatalogDisplayer.getInstance().displayTournaments();
		ArrayList<String> namesOfTournaments = new ArrayList<>();

		for (int i = 0; i < tournaments.size(); i++) {
			namesOfTournaments.add(tournaments.get(i).getName());
		}

		return namesOfTournaments;

	}

	public Tournament showTournamentDetails(String name) throws Exception {

		ArrayList<Tournament> tournaments = GlobalCatalogDisplayer.getInstance().displayTournaments();

		for (Tournament t : tournaments) {
			if (t.getName() == name) {
				return t;
			}
		}
		throw new Exception("Tournament Not found");
	}

	
	
}
