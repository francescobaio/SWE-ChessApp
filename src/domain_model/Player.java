package domain_model;

import java.util.ArrayList;

public class Player extends ChessPerson {

	private int age;
	private int ratingElo;
	private String title;
	private int k;
	private String nationality;

	private ArrayList<Tournament> subscribedTournaments = new ArrayList<Tournament>();
	private Tournament playingTournament;
	private Stats playerStats;

	public Player() {
	}

	public Player(String name, String surname, TournamentDisplayer tournamentDisplayer, AccountRemover accountRemover,
			int ratingElo, int age, String title, String nationality) {

		super(name, surname, tournamentDisplayer, accountRemover);
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

	public ArrayList<Tournament> getSubscribedTournaments() {
		return new ArrayList<Tournament>(subscribedTournaments);
	}

	public void setAttributes(Object[] params) {

		super.setAttributes(params);
		age = (int) params[4];
		ratingElo = (int) params[5];
		title = (String) params[6];
		nationality = (String) params[7];

	}

	public void updateStats() {

		playerStats.setNumOfGames(playerStats.getNumOfGames() + playingTournament.getNumOfRounds());
		playerStats.setNumOfTournaments(playerStats.getNumOfTournaments() + 1);
		playerStats.setLastPerformance(playingTournament.getPerformance(getName() + " " + getSurname()));

		float playerScore = playingTournament.getPlayerScore(this);
		float playerVariation = playingTournament.getPlayerVariation(this);

		ratingElo += (playerScore - playerVariation) * k;

		if (ratingElo < playerStats.getLowestRatingElo()) {
			playerStats.setLowestRatingElo(ratingElo);
		} else if (ratingElo > playerStats.getHighestRatingElo()) {
			playerStats.setHighestRatingElo(ratingElo);
		}
		title = computeTitle(playerStats.getHighestRatingElo());

	}

	public String computeTitle(int Elo) {

		String category = title;

		if (Elo < 1500 && title != "3N" && title != "2N" && title != "1N" && title != "CM" && title != "M"
				&& title != "FM" && title != "IM" && title != "GM") {

			category = "NC";

		} else if (Elo >= 1500 && Elo < 1600 && title != "2N" && title != "1N" && title != "CM" && title != "M"
				&& title != "FM" && title != "IM" && title != "GM") {

			category = "3N";

		} else if (Elo >= 1600 && Elo < 1800 && title != "1N" && title != "CM" && title != "M" && title != "FM"
				&& title != "IM" && title != "GM") {

			category = "2N";

		} else if (Elo >= 1800 && Elo < 2000 && title != "CM" && title != "M" && title != "FM" && title != "IM"
				&& title != "GM") {
			category = "1N";
		} else if (Elo >= 2000 && Elo < 2200 && title != "M" && title != "FM" && title != "IM" && title != "GM") {
			category = "CM";
		} else if (Elo >= 2200 && Elo < 2300 && title != "FM" && title != "IM" && title != "GM") {
			category = "M";

		} else if (Elo >= 2300 && Elo < 2400 && title != "IM" && title != "GM") {
			category = "FM";
		} else if (Elo >= 2400 && Elo < 2500 && title != "GM") {

			category = "IM";

		} else if (Elo >= 2500) {

			category = "GM";

		}
		return category;

	}

	public void subscribeTournament(Tournament t) {
		subscribedTournaments.add(t);
	}

	public void unsubscribeTournament(Tournament t) {
		subscribedTournaments.remove(t);
	}

	public Stats getStatistics() {
		return new Stats(playerStats);
	}

	public Tournament getCurrentTournament() {
		return new Tournament(playingTournament);
	}

}
