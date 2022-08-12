package domain_model;

import java.util.Comparator;

public class DateComparator  implements Comparator<Tournament> {

	@Override
	public int compare(Tournament o1, Tournament o2) {
		
			
	  int startingDayTournament1 = Integer.parseInt(o1.getStartingDate().substring(0, 2));
	  int startingMonthTournament1 = Integer.parseInt(o1.getStartingDate().substring(3,5));
	  int startingYearTournament1 = Integer.parseInt(o1.getStartingDate().substring(6));
	  
	  int startingDayTournament2 = Integer.parseInt(o2.getStartingDate().substring(0, 2));
	  int startingMonthTournament2 = Integer.parseInt(o2.getStartingDate().substring(3,5));
	  int startingYearTournament2 = Integer.parseInt(o2.getStartingDate().substring(6));
	  
	  
	  if(startingYearTournament1 > startingYearTournament2) {
		  return 1;
	  }else if(startingYearTournament2 > startingYearTournament1) {
		  return -1;
	  }else if(startingYearTournament1 == startingYearTournament2 && startingMonthTournament1 > startingMonthTournament2) {
		  return 1;
	  }else if(startingYearTournament1 == startingYearTournament2 && startingMonthTournament1 < startingMonthTournament2) {
		  return -1;
	  }else if(startingYearTournament1 == startingYearTournament2 && startingMonthTournament1 == startingMonthTournament2
			  && startingDayTournament1 > startingDayTournament2) {
		  return 1;
	  }else if(startingYearTournament1 == startingYearTournament2 && startingMonthTournament1 == startingMonthTournament2
			  && startingDayTournament1 < startingDayTournament2) {
		  return -1;
	  }else {
		  return 0;
	  }
	  		
	}


}
