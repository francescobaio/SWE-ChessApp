package domain_model;

public abstract class Observable {

	private Observer observer;

	public void notify(Object arg) {
		observer.update(arg);
	}

	public void subscribe(Observer o) {
		observer = o;
	}
	
}

