package domain_model;

import java.util.ArrayList;

 public class Tournament {

	private String name;
	private String province;
	private String region;
	private String startingDate;
	private String endingDate;
	private String timeControl;
	private int numOfRounds;
	private String refereeName;
	private String managerName;

	private Scoreboard scoreboard;
	private Standings standings;
	private ArrayList<Player> listOfPlayers = new ArrayList<Player>();

	public Tournament(String name, String province, String region, String startingDate, String endingDate,
			String timeControl, int numOfRounds, String refereeName, String managerNames) {
		this.name = name;
		this.province = province;
		this.region = region;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.timeControl = timeControl;
		this.numOfRounds = numOfRounds;
		this.refereeName = refereeName;
		this.managerName = managerName;

	}

	public Tournament(Tournament t) {
		name = t.name;
		province = t.province;
		region = t.region;
		startingDate = t.startingDate;
		endingDate = t.endingDate;
		timeControl = t.timeControl;
		numOfRounds = t.numOfRounds;
		refereeName = t.refereeName;
		managerName = t.managerName;
	}

	public String getName() {
		return name;
	}

	public String getProvince() {
		return province;
	}

	public String getRegion() {
		return region;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public String getEndingDate() {
		return endingDate;
	}

	public String getTimeControl() {
		return timeControl;
	}

	public int getNumOfRounds() {
		return numOfRounds;
	}

	public String getRefereeName() {
		return refereeName;
	}

	public String getManagerName() {
		return managerName;
	}
	
	public Scoreboard getScoreboard() {
		return new Scoreboard(scoreboard);
	}


	public Standings getStandings() {
		return new Standings(standings);
	}

	public ArrayList<Player> getListOfPlayers() {
		return new ArrayList<Player>(listOfPlayers);
	}

	public void addPlayer(Player p) throws Exception {
		if (listOfPlayers.contains(p)) {
			throw new Exception("Player already subscribed.");
		}
		listOfPlayers.add(p);
	}

	public void removePlayer(Player p) {
		listOfPlayers.remove(p);
	}

	public void updateStandings() {
		standings.updateStandings(new Scoreboard(scoreboard));
		if (standings.getCurrentRound() == numOfRounds) {
			for (int i = 0; i < listOfPlayers.size(); i++) {
				listOfPlayers.get(i).updateStats();
			}
		}
	}

	public void uploadResults(String[] results) {
		scoreboard.uploadResults(results, getListOfPlayers());
	}

	public void publishNewRound() throws Exception {
		if ((standings.getCurrentRound()-1) != numOfRounds) {
			scoreboard.publishNewRound(getStandings());
		}else {
			throw new Exception("Tournament finished");
		}
	}

	
	public void start() {

		standings = new Standings(listOfPlayers.size());
		standings.initialize(getListOfPlayers());

		scoreboard = new Scoreboard(listOfPlayers.size());
		scoreboard.initialize(getStandings());

		for (int i = 0; i < listOfPlayers.size(); i++) {
			listOfPlayers.get(i).setPlayingTournament(this);
		}

	}

	public void editInformation(String nameInformation, Object information) {

		switch (nameInformation) {
			case "name":
				name = (String) information;
				break;
			case "province":
				province = (String) information;
				break;
			case "region":
				region = (String) information;
				break;
			case "startingDate":
				startingDate = (String) information;
				break;
			case "endingDate":
				endingDate = (String) information;
				break;
			case "timeControl":
				timeControl = (String) information;
				break;
			case "numOfRounds":
				numOfRounds = (int) information;
				break;
			case "refereeName":
				refereeName = (String) information;
				break;
		}

	}

	public int getPerformance(String name) {

		String[][] copyStandings = standings.getStandings();

		for (int i = 1; i < listOfPlayers.size() + 1; i++) {
			if (copyStandings[i][3].equals(name)) {
				return Integer.parseInt(copyStandings[i][5]);
			}

		}

		return -1;
	}

	public float getPlayerVariation(Player p) {

		return scoreboard.getPlayerVariation(p.getName() + " " + p.getSurname());

	}

	public float getPlayerScore(Player p) {
		return standings.getPlayerScore(p.getName() + " " + p.getSurname());
	}

	public void updateStats() {
		for (int i = 0; i < listOfPlayers.size(); i++) {

		}
	}

}
