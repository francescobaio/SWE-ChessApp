package business_logic;

import domain_model.ChessPerson;

public class ChessPersonController extends PersonController {

	private ChessPerson chessPerson;

	public ChessPersonController(ChessPerson chessPerson) {
		super(chessPerson);
		this.chessPerson = chessPerson;
	}

	public void deleteAccount(String username, String password) {

		try {
			chessPerson.deleteAccount(username, password);
			
		} catch (IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
		}

	}

}
