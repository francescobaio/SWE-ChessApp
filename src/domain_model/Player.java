package domain_model;

import java.util.ArrayList;



public class Player extends User{
	
	private String birthDate;
	private int age;
	private int ratingElo;
	private String title;
	private int k;
	private String nationality;
	
	
 	private ArrayList<Tournament> subscribedTournaments = new ArrayList<Tournament>();
    private Stats playerStats;
    
    
    public Player(String name,String surname,String birthDate,int age,int ratingElo,String title,String nationality) {
    	
    	super(name,surname);
    	this.birthDate = birthDate;
    	this.age = age;
    	this.ratingElo = ratingElo;
    	this.setTitle(title);
    	this.playerStats = new Stats(ratingElo);
    	this.nationality = nationality;
   
    	
    	if(ratingElo < 2300 && age < 18) {
    		setK(40);
    	}else if (ratingElo < 2300 && age >= 18){
    		setK(20);
    	}else if (ratingElo >= 2300 && ratingElo < 2400 ) {
    		setK(20);
    	}else if (ratingElo >= 2400) {
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
 
       
}
