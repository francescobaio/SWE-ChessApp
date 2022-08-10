package domain_model;

public class Stats {

	private int numOfTournaments = 0;
	private int lastPerformance = 0;
	private int numOfGames = 0;
	private int numOfWins = 0;
	private int numOfDraws = 0;
	private int numOfDefeats = 0;
	private int lowestRatingElo;
	private int highestRatingElo;

	
	
	public Stats(int ratingElo) {
		
		lowestRatingElo = ratingElo;
		highestRatingElo = ratingElo;
	}
	


	public int getNumOfTournaments() {
		return numOfTournaments;
	}

	public void setNumOfTournaments(int numOfTournaments) {
		this.numOfTournaments = numOfTournaments;
	}

	public int getLastPerformance() {
		return lastPerformance;
	}

	public void setLastPerformance(int lastPerformance) {
		this.lastPerformance = lastPerformance;
	}

	public int getNumOfGames() {
		return numOfGames;
	}

	public void setNumOfGames(int numOfGames) {
		this.numOfGames = numOfGames;
	}

	public int getNumOfWins() {
		return numOfWins;
	}

	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}

	public int getNumOfDraws() {
		return numOfDraws;
	}

	public void setNumOfDraws(int numOfDraws) {
		this.numOfDraws = numOfDraws;
	}

	public int getNumOfDefeats() {
		return numOfDefeats;
	}

	public void setNumOfDefeats(int numOfDefeats) {
		this.numOfDefeats = numOfDefeats;
	}

	public int getLowestRatingElo() {
		return lowestRatingElo;
	}

	public void setLowestRatingElo(int lowestRatingElo) {
		this.lowestRatingElo = lowestRatingElo;
	}

	public int getHighestRatingElo() {
		return highestRatingElo;
	}

	public void setHighestRatingElo(int highestRatingElo) {
		this.highestRatingElo = highestRatingElo;
	}

}
