package business_logic;

import java.util.ArrayList;

import domain_model.Person;
import domain_model.Tournament;

public abstract class PersonController {

	private Person person;

	public PersonController(Person p) {
		this.person = p;
	}

	public ArrayList<String> showTournaments() {
		return person.showTournaments();
	}

	public Tournament showTournamentDetails(String name) {

		try {
			
			return person.showTournamentDetails(name);

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return null;
		}

	}

}
