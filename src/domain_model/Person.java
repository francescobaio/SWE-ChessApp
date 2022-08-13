package domain_model;

import java.util.ArrayList;

public class Person {

	private String name;
	private String surname;
	private TournamentDisplayer tournamentDisplayer;
	
	
	
	public Person() {}

	public Person(String name, String surname,TournamentDisplayer tournamentDisplayer) {

		this.name = name;
		this.surname = surname;
		this.tournamentDisplayer = tournamentDisplayer;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setTournamentDisplayer(TournamentDisplayer tournamentDisplayer) {
		this.tournamentDisplayer = tournamentDisplayer;
	}
	
	
	public ArrayList<String> showTournaments() {

		ArrayList<Tournament> tournaments = tournamentDisplayer.displayTournaments();
		ArrayList<String> namesOfTournaments = new ArrayList<>();

		for (int i = 0; i < tournaments.size(); i++) {
			namesOfTournaments.add(tournaments.get(i).getName());
		}

		return namesOfTournaments;

	}

	public Tournament showTournamentDetails(String name) throws Exception {

		ArrayList<Tournament> tournaments = tournamentDisplayer.displayTournaments();

		for (Tournament t : tournaments) {
			if (t.getName() == name) {
				return t;
			}
		}
		throw new Exception("Tournament Not found");
	}

	
	
}
