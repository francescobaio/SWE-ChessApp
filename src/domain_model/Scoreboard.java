package domain_model;

import java.lang.Math;
import java.util.ArrayList;


public class Scoreboard {
	
	private int numOfPlayers;
	private String[][] board;
	
	public Scoreboard(int numOfPlayers) {
		
		this.numOfPlayers = numOfPlayers;
		board = new String[((int) Math.ceil(numOfPlayers/2))+ 1][4];
		board[0][0] = "Table";
		board[0][1] = "White";
		board[0][2] = "Black";
		board[0][3] = "Result";
	}
	
	
	public void initialize(Standings standings) {
		
		for(int i = 1;i < (int) Math.ceil(numOfPlayers/2)+ 1 - numOfPlayers%2 ;i++){
			
			board[i][0] = Integer.toString(i);
			board[i][3] = "-";
			
			if(i%2 == 1) {
				
				board[i][1] = standings.getElement(i, 3);
				board[i][2] = standings.getElement((int) Math.floor(numOfPlayers/2)+ i , 3);
				
			}else {
				
				board[i][1] = standings.getElement((int)Math.floor(numOfPlayers/2) + i,3);
				board[i][2] = standings.getElement(i,3);
				
			}
			
		}
		
		if(numOfPlayers%2 == 1) {
			
			board[(int)Math.ceil(numOfPlayers/2)][0] = Integer.toString((int)Math.ceil(numOfPlayers/2));
			board[(int)Math.ceil(numOfPlayers/2)][1] = standings.getElement(numOfPlayers - 1,3);
			board[(int)Math.ceil(numOfPlayers/2)][2] = "_BYE_";
			board[(int)Math.ceil(numOfPlayers/2)][3] = "-";
		}
	
	}
	
	
	public void uploadResults(String[] results) {
		
		for(int i=1;i<(int) Math.ceil(numOfPlayers/2)+ 1;i++){
			board[i][3] = results[i-1];
		}
		
	}
	
	
	public String getElement(int i, int j) {

		return board[i][j];

	}
	
	
	

}
