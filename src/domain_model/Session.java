package domain_model;

import java.util.HashMap;
import java.util.Map;

public class Session implements AccountCreator,AccountRemover {

	private Map<String, String[]> accounts = new HashMap<String, String[]>();
	private Map<String, ChessPerson> userMap = new HashMap<String, ChessPerson>();
	private UserFactory userFactory = new UserFactory();

	public Map<String, ChessPerson> getUserMap() {
		return new HashMap<>(userMap);
	}

	public void deleteAccount(String username,String password) throws IllegalArgumentException {
		
		if(accounts.containsKey(username)) {
			if(accounts.get(username)[0].equals(password)) {
				userMap.remove(username);
				accounts.remove(username);			
			}else {
				throw new IllegalArgumentException("Wrong Password");
			}
			
		}else {
			throw new IllegalArgumentException("Wrong Username");
		}
	
	}

	public String typeParsing(UserType type) {

		String tmp = null;

		if (type == UserType.Player) {

			tmp = "Player";

		} else if (type == UserType.TournamentManager) {

			tmp = "TournamentManager";

		} else if (type == UserType.Referee) {
			tmp = "Referee";
		}

		return tmp;
	}

	public void createAccount(Object[] params, UserType type, String username, String password)
			throws IllegalArgumentException {

		ChessPerson account = userFactory.createActor(params, type);
		String[] info = { password, typeParsing(type) };
		if (accounts.containsKey(username)) {
			throw new IllegalArgumentException("Username already exists.");
		}
		accounts.put(username, info);
		userMap.put(username, account);

	}

	public ChessPerson signIn(String username, String password) throws IllegalArgumentException {

		if (accounts.containsKey(username)) {

			if (accounts.get(username)[0].equals(password)) {

				switch (accounts.get(username)[1]) {
				case "Player":
					Player p = (Player) userMap.get(username);
					return p;
				case "Referee":
					Referee r = (Referee) userMap.get(username);
					return r;
				case "TournamentManager":
					TournamentManager m = (TournamentManager) userMap.get(username);
					return m;
				}

			} else {

				throw new IllegalArgumentException("Wrong Password.");
			}

		} else {
			throw new IllegalArgumentException("Username doesn't exist.");
		}

		return null;

	}

}
