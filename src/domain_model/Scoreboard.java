package domain_model;

import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard {

	private int numOfPlayers;
	private String[][] board;
	private Map<String, ArrayList<String>> previousPairings = new HashMap<String, ArrayList<String>>();
	private Map<String, String> previousColour = new HashMap<String, String>();
	private Map<String, Float> eloVariations = new HashMap<String, Float>();

	public Scoreboard(int numOfPlayers) {

		this.numOfPlayers = numOfPlayers;
		board = new String[((int) Math.ceil(numOfPlayers / 2)) + 1][4];
		board[0][0] = "Table";
		board[0][1] = "White";
		board[0][2] = "Black";
		board[0][3] = "Result";

	}

	public void initialize(Standings standings) {

		ArrayList<String> firstOpponent = new ArrayList<String>();

		for (int i = 1; i < (int) Math.ceil(numOfPlayers / 2) + 1 - numOfPlayers % 2; i++) {

			board[i][0] = Integer.toString(i);
			board[i][3] = "-";

			if (i % 2 == 1) {

				board[i][1] = standings.getElement(i, 3);
				board[i][2] = standings.getElement((int) Math.floor(numOfPlayers / 2) + i, 3);
				previousColour.put(standings.getElement(i, 3), "WHITE");
				previousColour.put(standings.getElement((int) Math.floor(numOfPlayers / 2) + i, 3), "BLACK");

			} else {

				board[i][1] = standings.getElement((int) Math.floor(numOfPlayers / 2) + i, 3);
				board[i][2] = standings.getElement(i, 3);
				previousColour.put(standings.getElement(i, 3), "BLACK");
				previousColour.put(standings.getElement((int) Math.floor(numOfPlayers / 2) + i, 3), "WHITE");

			}

			firstOpponent.add(board[i][2]);
			previousPairings.put(board[i][1], new ArrayList<String>(firstOpponent));
			firstOpponent.clear();
			firstOpponent.add(board[i][1]);
			previousPairings.put(board[i][2], new ArrayList<String>(firstOpponent));
			firstOpponent.clear();

		}

		if (numOfPlayers % 2 == 1) {

			board[(int) Math.ceil(numOfPlayers / 2)][0] = Integer.toString((int) Math.ceil(numOfPlayers / 2));
			board[(int) Math.ceil(numOfPlayers / 2)][1] = standings.getElement(numOfPlayers - 1, 3);
			board[(int) Math.ceil(numOfPlayers / 2)][2] = "_BYE_";
			board[(int) Math.ceil(numOfPlayers / 2)][3] = "-";
			previousColour.put(standings.getElement(numOfPlayers - 1, 3), "WHITE");
		}

		for (int i = 1; i < numOfPlayers + 1; i++) {
			eloVariations.put(standings.getElement(i, 3), 0.0f);
		}

	}

	public void uploadResults(String[] results, ArrayList<Player> players) {

		boolean found = false;
		int k;
		float tmp;
		
		
		if(numOfPlayers%2 == 1) {
			
			board[(int) Math.ceil(numOfPlayers / 2)][3] = "1F-0F";
			
		}
		
			
		

		for (int i = 1; i < (int) Math.ceil(numOfPlayers / 2) + 1 - numOfPlayers % 2 ; i++) {
			board[i][3] = results[i - 1];
			for (int j = 0; j < numOfPlayers; j++) {
				if (board[i][1].equals(players.get(j).getName() + " " + players.get(j).getSurname())) {
					k = 0;
					while (found == false) {
						if ((players.get(k).getName() + " " + players.get(k).getSurname()).equals(board[i][2])) {

							tmp = eloVariations.get(board[i][2]);
							tmp += EloTable.getVariation(players.get(k).getRatingElo(), players.get(j).getRatingElo());
							eloVariations.put(board[i][2], tmp);

							tmp = eloVariations.get(board[i][1]);
							tmp += EloTable.getVariation(players.get(j).getRatingElo(), players.get(k).getRatingElo());
							eloVariations.put(board[i][1], tmp);
							
							found = true;

						}
						k++;
					}
					
					found = false;
					
					if (board[i][3].charAt(1) == '.') {
						players.get(j).addDraw();
					} else if (board[i][3].charAt(0) == '0') {
						players.get(j).addDefeat();
					} else {
						players.get(j).addWin();
					}
				} else if (board[i][2].equals(players.get(j).getName() + " " + players.get(j).getSurname())) {
					
					k = 0;
					while (found == false) {
						if ((players.get(k).getName() + " " + players.get(k).getSurname()).equals(board[i][1])) {

							tmp = eloVariations.get(board[i][1]);
							tmp += EloTable.getVariation(players.get(k).getRatingElo(), players.get(j).getRatingElo());
							eloVariations.put(board[i][1], tmp);

							tmp = eloVariations.get(board[i][2]);
							tmp += EloTable.getVariation(players.get(j).getRatingElo(), players.get(k).getRatingElo());
							eloVariations.put(board[i][2], tmp);
							
							found = true;

						}
						k++;
					}
					
					
					found = false;
					

					if (board[i][3].charAt(1) == '.') {
						players.get(j).addDraw();
					} else if (board[i][3].charAt(0) == '0') {
						players.get(j).addWin();
					} else {
						players.get(j).addDefeat();
					}
				}
			}
		}

	}

	public String getElement(int i, int j) {

		return board[i][j];

	}

	public void publishNewRound(Standings standings) {

		ArrayList<String[]> playersNames = new ArrayList<String[]>();
		ArrayList<String[]> copyPlayersNames = new ArrayList<String[]>();
		int numOfPairings = 0;

		for (int i = 1; i < numOfPlayers + 1; i++) {
			playersNames.add(standings.getElement(i));
		}

		boolean found = false;
		String[] tmp;

		if (playersNames.size() % 2 == 1) {

			int m = playersNames.size() - 1;

			while (found == false) {
				if (!(previousPairings.get(playersNames.get(m)[3]).contains("_BYE_"))) {
					found = true;
					board[(int) Math.ceil(numOfPlayers / 2)][1] = playersNames.get(m)[3];
					board[(int) Math.ceil(numOfPlayers / 2)][2] = "_BYE_";
					board[(int) Math.ceil(numOfPlayers / 2)][3] = "-";
					previousPairings.get(playersNames.get(m)[3]).add("_BYE_");
					playersNames.remove(m);
				}
				m--;
			}
			found = false;

		}

		while (playersNames.size() != 0) {

			do {

				copyPlayersNames.add(playersNames.get(0));
				tmp = playersNames.remove(0);

			} while (tmp[1].equals(playersNames.get(0)[1]));

			if (copyPlayersNames.size() % 2 == 1 && copyPlayersNames.size() != 1) {
				playersNames.add(0, copyPlayersNames.remove(copyPlayersNames.size() - 1));

			} else if (copyPlayersNames.size() == 1) {
				int index = 0;
				while (found == false) {
					if (!(previousPairings.get(copyPlayersNames.get(0)[3])).contains(playersNames.get(index)[3])) {
						found = true;
						previousPairings.get(copyPlayersNames.get(0)[3]).add(playersNames.get(index)[3]);
						previousPairings.get(playersNames.get(index)[3]).add(copyPlayersNames.get(0)[3]);
						numOfPairings++;
						board[numOfPairings][3] = "-";
						if (previousColour.get(copyPlayersNames.get(0)[3]).equals("WHITE")) {
							previousColour.put(copyPlayersNames.get(0)[3], "BLACK");
							previousColour.put(playersNames.get(index)[3], "WHITE");
							board[numOfPairings][1] = playersNames.get(index)[3];
							board[numOfPairings][2] = copyPlayersNames.get(0)[3];
						} else {
							previousColour.put(copyPlayersNames.get(0)[3], "WHITE");
							previousColour.put(playersNames.get(index)[3], "BLACK");
							board[numOfPairings][2] = playersNames.get(index)[3];
							board[numOfPairings][1] = copyPlayersNames.get(0)[3];
						}

						copyPlayersNames.remove(0);
						playersNames.remove(index);

					}

					index++;

				}

				found = false;

			}

			while (copyPlayersNames.size() != 0) {

				int k = (int) Math.ceil(copyPlayersNames.size() / 2);

				if (k != 1) {

					do {
						if (!(previousPairings.get(copyPlayersNames.get(0)[3]).contains(copyPlayersNames.get(k)[3]))) {
							found = true;
							previousPairings.get(copyPlayersNames.get(0)[3]).add(copyPlayersNames.get(k)[3]);
							previousPairings.get(copyPlayersNames.get(k)[3]).add(copyPlayersNames.get(0)[3]);
							numOfPairings++;
							board[numOfPairings][3] = "-";

							if (previousColour.get(copyPlayersNames.get(0)[3]).equals("WHITE")) {

								previousColour.put(copyPlayersNames.get(0)[3], "BLACK");
								previousColour.put(copyPlayersNames.get(k)[3], "WHITE");
								board[numOfPairings][1] = copyPlayersNames.get(k)[3];
								board[numOfPairings][2] = copyPlayersNames.get(0)[3];
							} else {
								previousColour.put(copyPlayersNames.get(0)[3], "WHITE");
								previousColour.put(copyPlayersNames.get(k)[3], "BLACK");
								board[numOfPairings][1] = copyPlayersNames.get(0)[3];
								board[numOfPairings][2] = copyPlayersNames.get(k)[3];
							}

							copyPlayersNames.remove(k);
							copyPlayersNames.remove(0);

						}

						if (k == copyPlayersNames.size() - 1) {
							k = 1;

						} else {
							k++;
						}

					} while (found == false && k != (int) Math.ceil(copyPlayersNames.size() / 2));

				}

				if (found == false) {

					int l = 0;

					while (found == false) {
						if (!(previousPairings.get(copyPlayersNames.get(0)[3]).contains(playersNames.get(l)[3]))) {
							found = true;
							previousPairings.get(copyPlayersNames.get(0)[3]).add(playersNames.get(l)[3]);
							previousPairings.get(playersNames.get(l)[3]).add(copyPlayersNames.get(0)[3]);
							numOfPairings++;
							board[numOfPairings][3] = "-";

							if (previousColour.get(copyPlayersNames.get(0)[3]).equals("WHITE")) {

								previousColour.put(copyPlayersNames.get(0)[3], "BLACK");
								previousColour.put(playersNames.get(l)[3], "WHITE");
								board[numOfPairings][1] = playersNames.get(l)[3];
								board[numOfPairings][2] = copyPlayersNames.get(0)[3];
							} else {
								previousColour.put(copyPlayersNames.get(0)[3], "WHITE");
								previousColour.put(playersNames.get(l)[3], "BLACK");
								board[numOfPairings][1] = copyPlayersNames.get(0)[3];
								board[numOfPairings][2] = playersNames.get(l)[3];
							}

							copyPlayersNames.remove(0);
							playersNames.remove(l);

						}
						l++;
					}

				}

				found = false;

			}

		}

	}
	
	
	
	
	public float getPlayerVariation(String name) {
		return eloVariations.get(name);
	}
	


}
