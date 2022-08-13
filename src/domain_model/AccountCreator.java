package domain_model;

public interface AccountCreator {

	public void createAccount(Object[] params, UserType type, String username, String password);

	public ChessPerson signIn(String username, String password);

}
