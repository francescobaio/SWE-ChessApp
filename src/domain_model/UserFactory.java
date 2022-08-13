package domain_model;


public class UserFactory {

	
	public ChessPerson createActor(Object[] params,UserType type) {
		
		ChessPerson account =  null;
		if(type == UserType.Player) {
			account = new Player();
		}else if(type == UserType.Referee) {
			account = new Referee();
		}else if(type == UserType.TournamentManager) {
			account = new TournamentManager();
		}
		
		account.setAttributes(params);
		return account;
	}
	

}


