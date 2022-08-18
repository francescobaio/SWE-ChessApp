package business_logic;

import domain_model.Referee;

public class RefereeController extends ChessPersonController {

	private Referee referee;

	public RefereeController(Referee referee) {
		super(referee);
		this.referee = referee;
	}

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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
