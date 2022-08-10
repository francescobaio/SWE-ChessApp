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

	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public Standings getStandings() {
		return new Standings(standings);
	}

	public void addPlayer(Player p) throws Exception {
		if (listOfPlayers.contains(p)) {
			throw new Exception("Player already subscribed.");
		}
		listOfPlayers.add(p);
	}

	public void removePlayer(Player p) throws Exception {
		if (!listOfPlayers.remove(p)) {
			throw new Exception("Player not found");
		}
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

	}

}
