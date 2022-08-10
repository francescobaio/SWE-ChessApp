package domain_model;


public class UserFactory {

	
	public Player createActor(String name,String surname,String birthDate,int age,int ratingElo,String title,String nationality) {
		
		return new Player(name,surname,birthDate,age,ratingElo,title,nationality);
		
	}
	
	

	public TournamentManager createActor(String name, String surname,int phoneNumber, ManagerTournamentCatalog managerCatalog) {
		
		return new TournamentManager(name,surname,phoneNumber,managerCatalog);
		
	} 
	
	public Referee createActor(String name,String surname,Tournament activeTournament) {
		
		return new Referee(name,surname,activeTournament);
		
	}

}


