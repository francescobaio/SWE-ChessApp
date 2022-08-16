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
	private int maxPlayers;

	private Scoreboard scoreboard;
	private Standings standings;
	private ArrayList<Player> listOfPlayers = new ArrayList<Player>();

	public Tournament(String name, String province, String region, String startingDate, String endingDate,
			String timeControl, int numOfRounds, String refereeName, String managerName, int maxPlayers) {
		this.name = name;
		this.province = province;
		this.region = region;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.timeControl = timeControl;
		this.numOfRounds = numOfRounds;
		this.refereeName = refereeName;
		this.managerName = managerName;
		this.maxPlayers = maxPlayers;

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
		maxPlayers = t.maxPlayers;
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

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Standings getStandings() {
		return new Standings(standings);
	}
	
	
	public ArrayList<Player> getListOfPlayers(){
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
	
	
	public void update() {
		standings.updateStandings(new Scoreboard(scoreboard));
	}
	
	public void uploadResults(String[] results) {
		scoreboard.uploadResults(results, getListOfPlayers());
	}
	
	public void publishNewRound() {
		scoreboard.publishNewRound(getStandings());
	}


		

	public void editInformation(String nameInformation, Object information) {

		switch (nameInformation) {
		case "name":
			name = (String) information;
		case "province":
			province = (String) information;
		case "region":
			region = (String) information;
		case "startingDate":
			startingDate = (String) information;
		case "endingDate":
			endingDate = (String) information;
		case "timeControl":
			timeControl = (String) information;
		case "numOfRounds":
			numOfRounds = (int) information;
		case "refereeName":
			refereeName = (String) information;
		case "maxPlayers":
			maxPlayers = (int) information;
		}

	}

	public void start() {

		standings = new Standings(listOfPlayers.size());
		standings.initialize(listOfPlayers);

		scoreboard = new Scoreboard(listOfPlayers.size());
		scoreboard.initialize(getStandings());

		for (int i = 0; i < listOfPlayers.size(); i++) {
			listOfPlayers.get(i).setPlayingTournament(this);
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

}
