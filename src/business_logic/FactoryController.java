package business_logic;

import domain_model.Player;
import domain_model.UserFactory;

public class FactoryController {
	
	
	private UserFactory userFactory;
	
	
	public Player createAccount(String name,String surname,String birthDate,int age,int ratingElo,String title,String nationality) {
		
		return userFactory.createActor(name, surname, birthDate, age, ratingElo,title,nationality);
		
		
	}
	

}
