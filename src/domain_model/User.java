package domain_model;

public class User extends Person {

	private AccountCreator accountCreator;

	public User(String name, String surname, TournamentDisplayer tournamentDisplayer,AccountCreator accountCreator) {
		super(name,surname,tournamentDisplayer);
		this.accountCreator = accountCreator;
	}

	public void createAccount(Object[] params, UserType type, String username, String password)
			throws IllegalArgumentException {
		accountCreator.createAccount(params, type, username, password);
	}

	public ChessPerson signIn(String username, String password) throws IllegalArgumentException {
		return accountCreator.signIn(username, password);

	}

}
