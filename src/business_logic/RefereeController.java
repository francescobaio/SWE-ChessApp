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
		referee.getActiveTournament().setStarted(true);
	}

	public void updateStandings() {
		
		referee.updateStandings();
		if(referee.getActiveTournament().getNumOfRounds() == referee.getActiveTournament().getStandings().getCurrentRound()) {
			for (int i = 0; i < referee.getActiveTournament().getListOfPlayers().size(); i++) {
				referee.getActiveTournament().getListOfPlayers().get(i).updateStats();
			}
		}
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





