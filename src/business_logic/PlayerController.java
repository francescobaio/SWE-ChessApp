package business_logic;

import domain_model.Player;
import domain_model.Stats;
import domain_model.Tournament;

public class PlayerController extends ChessPersonController {

	private Player player;

	public PlayerController(Player player) {
		super(player);
		this.player = player;
	}

	public void subscribeTournament(Tournament t) {
		try {
			player.subscribeTournament(t);
			t.addPlayer(player);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void unsubscribeTournament(Tournament t) {
		player.unsubscribeTournament(t);
		t.removePlayer(player);
	}

	public Stats showStatistics() {
		return player.getStatistics();
	}

	public Tournament showCurrentTournament() {
		return player.getCurrentTournament();
	}

}
