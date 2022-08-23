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
			if (!(t.isStarted())) {
				player.subscribeTournament(t);
				t.addPlayer(player);
			} else {
				System.out.println("Tournament already started.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void unsubscribeTournament(Tournament t) {

		if (!(t.isStarted())) {
			player.unsubscribeTournament(t);
			t.removePlayer(player);
		} else {
			System.out.println("Tournament already started.");
		}

	}

	public Stats showStatistics() {
		return player.getStatistics();
	}

	
	public Tournament showCurrentTournament() {
		try {
			return player.getCurrentTournament();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

 }

 
 
 
 