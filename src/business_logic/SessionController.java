package business_logic;

import domain_model.Session;
import domain_model.Person;
import domain_model.UserType;

public class SessionController {

	private Session session;

	public SessionController(Session session) {

		this.session = session;
	}

	public void createAccount(Object[] params, UserType type, String username, String password) throws IllegalArgumentException {
		
		session.createAccount(params, type, username, password);

	}
	
	public Person signin(String username, String password) throws IllegalArgumentException {
		
		return session.signin(username, password);
		
	}

}
