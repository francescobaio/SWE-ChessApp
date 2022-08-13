package business_logic;

import java.util.ArrayList;

import domain_model.ChessPerson;
import domain_model.User;
import domain_model.UserType;

public class UserController extends PersonController {

	private User user;

	public UserController(User user) {
		super(user);
		this.user = user;
	}

	public ChessPerson login(String username, String password) {

		try {

			return user.signIn(username, password);

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());
			return null;
		}
	}

	public void signUp(Object[] params, UserType type, String username, String password) {

		try {

			user.createAccount(params, type, username, password);

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}

}
