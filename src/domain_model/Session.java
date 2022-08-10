package domain_model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Session {

	private Map<String, String[]> accounts = new HashMap<String, String[]>();
	private Map<String, User> userMap = new HashMap<String, User>();

	private static Session instance = null;

	private Session() {
	}

	public static Session getInstance() {
		if (instance == null) {
			instance = new Session();
		}
		return instance;
	}

	public Map<String, User> getUserMap() {
		return new HashMap<>(userMap);
	}

	public void deleteAccount(String username) {
		
		userMap.remove(username);
		accounts.remove(username);
	}

}


















