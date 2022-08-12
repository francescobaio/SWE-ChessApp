package domain_model;

import java.util.ArrayList;

public class Player extends User {

	private String birthDate;
	private int age;
	private int ratingElo;
	private String title;
	private int k;
	private String nationality;

	private ArrayList<Tournament> subscribedTournaments = new ArrayList<Tournament>();
	private Tournament playingTournament;
	private Stats playerStats;
	
	
	public Player() {}
	

	public Player(String name, String surname,String birthDate, int age, int ratingElo, String title,
			String nationality) {

		super(name, surname);
		this.birthDate = birthDate;
		this.age = age;
		this.ratingElo = ratingElo;
		this.setTitle(title);
		this.playerStats = new Stats(ratingElo);
		this.nationality = nationality;

		if (ratingElo < 2300 && age < 18) {
			setK(40);
		} else if (ratingElo < 2300 && age >= 18) {
			setK(20);
		} else if (ratingElo >= 2300 && ratingElo < 2400) {
			setK(20);
		} else if (ratingElo >= 2400) {
			setK(10);
		}

	}

	public String getBirthDate() {
		return birthDate;
	}

	public int getRatingElo() {
		return ratingElo;
	}

	public void setRatingElo(int ratingElo) {
		this.ratingElo = ratingElo;
	}

	public Stats getPlayerStats() {
		return playerStats;
	}

	public int getAge() {
		return age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addWin() {
		playerStats.setNumOfWins(playerStats.getNumOfWins() + 1);
	}

	public void addDraw() {
		playerStats.setNumOfDraws(playerStats.getNumOfDraws() + 1);
	}

	public void addDefeat() {
		playerStats.setNumOfDefeats(playerStats.getNumOfDefeats() + 1);
	}

	public void setPlayingTournament(Tournament playingTournament) {
		this.playingTournament = playingTournament;
	}
	
	
	
	
	
	public void setAttributes(Object[] params) {
		
		super.setAttributes(params);
		birthDate = (String)params[2];
		age = (int)params[3];
		ratingElo = (int) params[4];
		title = (String)params[5];
		nationality = (String) params[6];
		
	}
	
		

	public void updateStats() {

		playerStats.setNumOfGames(playerStats.getNumOfGames() + playingTournament.getNumOfRounds());
		playerStats.setNumOfTournaments(playerStats.getNumOfTournaments() + 1);
		playerStats.setLastPerformance(playingTournament.getPerformance(getName() + " " + getSurname()));

		float playerScore = playingTournament.getPlayerScore(this);
		float playerVariation = playingTournament.getPlayerVariation(this);

		ratingElo += (playerScore - playerVariation) * k;
		title = computeTitle(ratingElo);
		
		if(ratingElo < playerStats.getLowestRatingElo()) {
			playerStats.setLowestRatingElo(ratingElo);
		}else if (ratingElo > playerStats.getHighestRatingElo()) {
			playerStats.setHighestRatingElo(ratingElo);
		}
		
	
	}
	
	

	public String computeTitle(int ratingElo) {

		String category;
		if (ratingElo < 1500) {

			category = "NC";

		} else if (ratingElo >= 1500 && ratingElo < 1600) {

			category = "3N";

		} else if (ratingElo >= 1600 && ratingElo < 1800) {

			category = "2N";

		} else if (ratingElo >= 1800 && ratingElo < 2000) {
			category = "1N";
		} else if (ratingElo >= 2000 && ratingElo < 2200) {
			category = "CM";
		} else if (ratingElo >= 2200 && ratingElo < 2300) {
			category = "M";

		} else if (ratingElo >= 2300 && ratingElo < 2400) {
			category = "FM";
		} else if (ratingElo >= 2400 && ratingElo < 2500) {
			
			category = "IM";
			
			
		} else {
			
			category = "GM";
			
		}
		
		return category;

	}
	
	
	
	
	public void subscribeTournament(Tournament t) {
		subscribedTournaments.add(t);
	}
	
	
	public void unsubscribeTournament(Tournament t ) {
		subscribedTournaments.remove(t);
	}
	
	
	
	
	
	

}
