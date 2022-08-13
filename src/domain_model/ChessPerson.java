package domain_model;

public abstract class ChessPerson extends Person {

	private AccountRemover accountRemover;

	public ChessPerson() {
	}

	public ChessPerson(String name, String surname, TournamentDisplayer tournamentDisplayer,
			AccountRemover accountRemover) {
		super(name, surname, tournamentDisplayer);
		this.accountRemover = accountRemover;
	}

	public void setAttributes(Object[] params) {

		setName((String) params[0]);
		setSurname((String) params[1]);
		setTournamentDisplayer((TournamentDisplayer) params[2]);
		accountRemover = (AccountRemover) params[3];

	}

	public void deleteAccount(String username, String password) {
		accountRemover.deleteAccount(username, password);
	}

}
