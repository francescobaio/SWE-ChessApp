package domain_model;

import java.util.HashMap;
import java.util.Map;

 public class Session implements AccountCreator, AccountRemover {

	private Map<String, String> accounts = new HashMap<String, String>();
	private Map<String, ChessPerson> userMap = new HashMap<String, ChessPerson>();
	private UserFactory userFactory = new UserFactory();

	public Map<String, ChessPerson> getUserMap() {
		return new HashMap<>(userMap);
	}

	public Map<String, String> getAccounts() {
		return new HashMap<>(accounts);
	}

	public void deleteAccount(String username, String password) throws IllegalArgumentException {

		if (accounts.containsKey(username)) {
			if (accounts.get(username).equals(password)) {
				userMap.remove(username);
				accounts.remove(username);
			} else {
				throw new IllegalArgumentException("Wrong Password");
			}

		} else {
			throw new IllegalArgumentException("Wrong Username");
		}

	}

	public void createAccount(Object[] params, UserType type, String username, String password)
			throws IllegalArgumentException {

		ChessPerson account = userFactory.createActor(params, type);
		if (accounts.containsKey(username)) {
			throw new IllegalArgumentException("Username already exists.");
		}
		accounts.put(username, password);
		userMap.put(username, account);

	}

	public ChessPerson signIn(String username, String password) throws IllegalArgumentException {

		if (accounts.containsKey(username)) {

			if (accounts.get(username).equals(password)) {

				return userMap.get(username);
				 
			} else {

				throw new IllegalArgumentException("Wrong Password.");
			}

		} else {
			throw new IllegalArgumentException("Username doesn't exist.");
		}

	}

}
