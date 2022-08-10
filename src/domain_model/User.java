package domain_model;

import java.util.ArrayList;

public class User {
	
	private String name;
	private String surname;
	
	
	public User(String name,String surname) {
		
		this.name = name;
		this.surname = surname;
	}
	
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	
	public ArrayList<String> showTournaments() {

		Tournament[] arrayOfTournament = (Tournament[]) GlobalTournamentCatalog.getInstance().getListOfTournaments()
				.toArray();
		ArrayList<String> listOfNames = new ArrayList<String>();

		for (Tournament t : arrayOfTournament) {
			listOfNames.add(t.getName());
		}

		return listOfNames;
	}
	

	public Tournament showTournamentDetails(String name) throws Exception {

		Tournament[] arrayOfTournament = (Tournament[]) GlobalTournamentCatalog.getInstance().getListOfTournaments().toArray();

		for (Tournament t : arrayOfTournament) {
			if (t.getName() == name) {
				return t;
			}
		}
		throw new Exception("Tournament Not found");
	}

	
	public void signUp(String username, String password, String birthDate, int age, int ratingElo, String nationality)
			throws Exception {

		if (Session.getInstance().getUserMap().containsKey(username)) {
			throw new Exception(username + "already exists.");
		}

		Player player = factoryController.createAccount(name,surname, birthDate, age, ratingElo,nationality);
		
		
		
		
		
		
		

	}


}
