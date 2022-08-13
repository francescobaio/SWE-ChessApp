package business_logic;

import java.util.ArrayList;

import domain_model.Tournament;
import domain_model.Person;
import domain_model.UserType;


public class UserController {

	private Person user;
	private SessionController sc;

	public UserController(Person user,SessionController sc) {

		this.user = user;
		this.sc = sc;

	}

	public ArrayList<String> showTournaments() {

		try {

			return user.showTournaments();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;
		}

	}

	public Tournament showTournamentDetails(String name) {

		try {

			return user.showTournamentDetails(name);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return null;

		}

	}

	public Person login(String username, String password) {
		
		
		try {
			
			return sc.signin(username, password);
			
			
		}catch(IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			return null;
		}	
	}
	
	

	public void signUp(Object[] params, UserType type, String username, String password) {

		try {

			sc.createAccount(params, type, username, password);
			
		} catch (IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
		}

	}

}
