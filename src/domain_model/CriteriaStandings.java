package domain_model;

public class CriteriaStandings {
	
	private int pos;
	private float points;
	private float aro;
	
	
	
	public CriteriaStandings(int pos,float points, float aro) {
		this.pos = pos;
		this.points = points;
		this.aro = aro;
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
