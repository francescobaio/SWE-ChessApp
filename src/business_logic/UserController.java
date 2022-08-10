package business_logic;

import java.util.ArrayList;
import java.util.HashSet;

import domain_model.GlobalTournamentCatalog;
import domain_model.Player;
import domain_model.Session;
import domain_model.Stats;
import domain_model.Tournament;
import domain_model.User;

public class UserController {

	private User user;
	private FactoryController factoryController;

	public UserController(User user, FactoryController factoryController) {
		this.user = user;
		this.factoryController = factoryController;
	}

	public ArrayList<String> showTournaments() {
		
		return user.showTournaments();
	}

	public Tournament showTournamentDetails(String name) throws Exception{
		
		return user.showTournamentDetails(name);
	}

	
	public void signUp(String username, String password, String birthDate, int age, int ratingElo, String nationality) {
		
	}
}
