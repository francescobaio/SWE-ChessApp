package domain_model;

public class User extends Person {

	private AccountCreator accountCreator;

	public User(AccountCreator accountCreator) {
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
