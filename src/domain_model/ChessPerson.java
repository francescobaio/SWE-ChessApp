package domain_model;

public abstract class ChessPerson extends Person  {
	
	private Session session;
	
	public ChessPerson() {}
	
	public ChessPerson(String name,String surname,Session session) {
		super(name,surname);
		this.session = session;
	}
	
	public void deleteAccount(String username,String password) {
		
	}

}
