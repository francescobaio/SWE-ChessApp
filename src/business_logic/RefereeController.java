package business_logic;

import domain_model.Referee;

public class RefereeController {

	private Referee referee;

	public void startTournament() {
		referee.startTournament();
	}

	public void updateStandings() {
		referee.updateStandings();
	}

	public void uploadResults(String[] results) {
		referee.uploadResults(results);
	}

	public void publishNewRound() {
		try {
			referee.publishNewRound();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
