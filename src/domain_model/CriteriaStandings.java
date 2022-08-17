package domain_model;

public class CriteriaStandings {

	private int pos;
	private float points;
	private float aro;
	private int ratingElo;

	public CriteriaStandings(int pos, float points, float aro, int ratingElo) {
		this.pos = pos;
		this.points = points;
		this.aro = aro;
		this.ratingElo = ratingElo;
	}

	public int getRatingElo() {
		return ratingElo;
	}

	public float getAro() {
		return aro;
	}

	public float getPoints() {
		return points;
	}

	public int getPos() {
		return pos;
	}

}
