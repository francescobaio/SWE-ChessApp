package domain_model;

import java.util.Comparator;

public class CriteriaComparator implements Comparator<CriteriaStandings> {

	@Override
	public int compare(CriteriaStandings c1, CriteriaStandings c2) {

		if (c1.getPoints() > c2.getPoints() || (c1.getPoints() == c2.getPoints() && c1.getAro() > c2.getAro())
				|| (c1.getPoints() == c2.getPoints() && c1.getAro() == c2.getAro()
						&& c1.getRatingElo() > c2.getRatingElo())) {
			return -1;
		} else if (c1.getPoints() == c2.getPoints() && c1.getAro() == c2.getAro()
				&& c1.getRatingElo() == c2.getRatingElo()) {
			return 0;
		} else {
			return 1;
		}

	}

}
