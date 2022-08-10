package domain_model;

import java.util.ArrayList;

public class Standings {

	private int numOfPlayers;
	private String[][] standings;
	private int currentRound;

	public Standings(int numOfPlayers) {

		this.numOfPlayers = numOfPlayers;
		standings = new String[numOfPlayers + 1][8];
		standings[0][0] = "POS";
		standings[0][1] = "PTS";
		standings[0][2] = "TITLE";
		standings[0][3] = "NAME";
		standings[0][4] = "ELO";
		standings[0][5] = "PERF";
		standings[0][6] = "NAT";
		standings[0][7] = "ARO";

	}

	public void initialize(ArrayList<Player> players) {

		players.sort(new PlayerComparator());

		for (int i = 1; i < numOfPlayers + 1; i++) {

			standings[i][0] = Integer.toString(i);
			standings[i][1] = "0";
			standings[i][2] = players.get(i - 1).getTitle();
			standings[i][3] = players.get(i - 1).getName() + " " + players.get(i - 1).getSurname();
			standings[i][4] = Integer.toString(players.get(i - 1).getRatingElo());
			standings[i][5] = "-";
			standings[i][6] = players.get(i - 1).getNationality();
			standings[i][7] = "0";

		}

	}

	public String getElement(int i, int j) {

		return standings[i][j];

	}

	public String[] getElement(int i) {
		return standings[i];
	}

	
	public Standings(Standings s) {

		numOfPlayers = s.numOfPlayers;
		standings = new String[numOfPlayers + 1][8];
		for (int i = 0; i < numOfPlayers + 1; i++) {
			for (int j = 0; j < 8; j++) {
				standings[i][j] = s.standings[i][j];
			}
		}
	}

	public void updateStandings(Scoreboard scoreboard) {
		
		for(int i=1;i < (int) Math.ceil(numOfPlayers/2)+ 1;i++) {
			for(int j = 1;j < numOfPlayers + 1;j++) {
				
				float tmp = Float.parseFloat(standings[j][1]);
				float aro = Float.parseFloat(standings[j][7]);
				int opponentElo = 0;
				int performance = Integer.parseInt(standings[j][5]);

				
				if(scoreboard.getElement(i,1).equals(standings[j][3])) {
					
					for(int k=1;k < numOfPlayers + 1;k++) {
						if(scoreboard.getElement(i, 2).equals(standings[k][3])) {
						   opponentElo = Integer.parseInt(standings[k][4]);
						}
					}
					
				    aro = (aro * currentRound + opponentElo)/(currentRound+1);
					standings[j][7] = Float.toString(aro);
					
					

					if(scoreboard.getElement(i, 3).charAt(1) == '.') {
						tmp += 0.5;
						standings[j][1] = Float.toString(tmp);
						performance = Math.round((performance * currentRound + opponentElo)/(currentRound+1));
								
					}else {
						
						tmp +=  Float.parseFloat(scoreboard.getElement(i, 3).substring(0, 1));
						standings[j][1] = Float.toString(tmp);
						
						if(scoreboard.getElement(i,3).charAt(0) == '1') {
							performance = Math.round((performance * currentRound + opponentElo + 400)/(currentRound+1));
						}else {
							performance = Math.round((performance * currentRound + opponentElo - 400)/(currentRound+1));
						}
						
					}
					
								
		
				}else if(scoreboard.getElement(i, 2).equals(standings[j][3])){
					
					
					for(int k=1;k < numOfPlayers + 1;k++) {
						if(scoreboard.getElement(i, 1).equals(standings[k][3])) {
						   opponentElo = Integer.parseInt(standings[k][4]);
						}
					}
					
				    aro = (aro * currentRound + opponentElo)/(currentRound+1);
					standings[j][7] = Float.toString(aro);
					
				
					
					if(scoreboard.getElement(i, 3).charAt(1) == '.') {
						tmp += 0.5;
						standings[j][1] = Float.toString(tmp);
						performance = Math.round((performance * currentRound + opponentElo)/(currentRound+1));
								
					}else {
						
						tmp +=  Float.parseFloat(scoreboard.getElement(i, 3).substring(2));
						standings[j][1] = Float.toString(tmp);	
						if(scoreboard.getElement(i,3).charAt(2) == '1') {
							performance = Math.round((performance * currentRound + opponentElo + 400)/(currentRound+1));
						}else {
							performance = Math.round((performance * currentRound + opponentElo - 400)/(currentRound+1));
						}
						
					}	
							
			}
			
		}
			
		
	}
	
	
		sortStandings();
		currentRound++;
	
	}
	
	
	
	public void sortStandings() {
		
		ArrayList<CriteriaStandings> criteria = new ArrayList<CriteriaStandings>();
		
		for(int i=1;i<numOfPlayers + 1;i++) {
			
			criteria.add(new CriteriaStandings(Integer.parseInt(standings[i][0]),Float.parseFloat(standings[i][1]),Float.parseFloat(standings[i][7])));
				
		}
		
		criteria.sort(new CriteriaComparator());
		String[][] sortedStandings = new String[numOfPlayers+1][8];
		sortedStandings[0] = standings[0];
		for(int i=1;i<numOfPlayers+1;i++) {
			sortedStandings[i] = standings[criteria.get(i).getPos()];
		}
		
		standings = sortedStandings;
	}
	
}
























