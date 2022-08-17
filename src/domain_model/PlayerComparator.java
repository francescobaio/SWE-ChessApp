package domain_model;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player>{
	
	@Override
	public int compare(Player p1,Player p2) {
		if(p1.getRatingElo() == p2.getRatingElo()) {
			return 0;
		}else if(p1.getRatingElo() > p2.getRatingElo()) {
			return -1;
		}else {
			return 1;
		}
	}

}
