package testing;

import domain_model.*;


public class main {

	public static void main(String[] args) throws Exception {
		
	    GlobalTournamentCatalog tournamentCatalog = new GlobalTournamentCatalog();
	    AccountRemover accountRemover =  new Session();
	    ManagerTournamentCatalog managerCatalog = new ManagerTournamentCatalog(tournamentCatalog);
	    TournamentManager tournamentManager = new TournamentManager("Erminio","Castaldi",tournamentCatalog,accountRemover,"32800032342",managerCatalog);
	    Tournament t =tournamentManager.createTournament("Torneo sociale","RI","Lazio","28/02/2022","02/05/2022","90+30",5,"Fabrizio Falsi","Erminio Castaldi");
	    Referee referee = new Referee("Fabrizio","Falsi",tournamentCatalog,accountRemover,t,"IA");
	    
	    
	    
	    Player p1 = new Player("Leonardo","Petrilli",tournamentCatalog,accountRemover,1922,22,"1N","ITA");
	    Player p2 = new Player("Francesco","Giovanzanti",tournamentCatalog,accountRemover,1792,27,"1N","ITA");
	    Player p3 = new Player("Ivano","Fioravanti",tournamentCatalog,accountRemover,1780,61,"2N","ITA");
	    Player p4 = new Player("Filippo","Melchiorre",tournamentCatalog,accountRemover,1675,16,"2N","ITA");
	    Player p5 = new Player("Andrea","Fiore",tournamentCatalog,accountRemover,1619,29,"2N","ITA");
	    Player p7 = new Player("Filippo","Cavoli",tournamentCatalog,accountRemover,1440,14,"NC","ITA");
	    Player p8 = new Player("Stefano","Cavoli",tournamentCatalog,accountRemover,1337,18,"NC","ITA");
	    Player p9 = new Player("Mario","Giovanzanti",tournamentCatalog,accountRemover,1368,65,"3N","ITA");
	    Player p10 = new Player("Lorenzo","Caputi",tournamentCatalog,accountRemover,1391,15,"NC","ITA");
	    Player p11 = new Player("Cristian","Spadoni",tournamentCatalog,accountRemover,1440,15,"NC","ITA");
	    Player p12 = new Player("Emanuele","Marini",tournamentCatalog,accountRemover,1440,13,"NC","ITA");
	    Player p13 = new Player("Erminio","Castaldi",tournamentCatalog,accountRemover,1212,82,"NC","ITA");
	    Player p14 = new Player("Filippo","Sciarra",tournamentCatalog,accountRemover,999,15,"NC","ITA");
	    Player p15 = new Player("Alejandro","Gomez",tournamentCatalog,accountRemover,1440,50,"NC","ITA");
	    Player p16 = new Player("Raffaele","Gentile",tournamentCatalog,accountRemover,1311,64,"NC","ITA");
	    
	    

	    t.addPlayer(p1);
	    t.addPlayer(p2);
	    t.addPlayer(p3);
	    t.addPlayer(p4);
	    t.addPlayer(p5); 
	    t.addPlayer(p7);
	    t.addPlayer(p8);
	    t.addPlayer(p9);
	    t.addPlayer(p10);
	    t.addPlayer(p11);
	    t.addPlayer(p12);
	    t.addPlayer(p13);
	    t.addPlayer(p14);
	    t.addPlayer(p15);
	    t.addPlayer(p16);
	    
	    p1.subscribeTournament(t);
	    p2.subscribeTournament(t);
	    p3.subscribeTournament(t);
	    p4.subscribeTournament(t);
	    p5.subscribeTournament(t);
	    p7.subscribeTournament(t);
	    p8.subscribeTournament(t);
	    p9.subscribeTournament(t);
	    p10.subscribeTournament(t);
	    p11.subscribeTournament(t);
	    p12.subscribeTournament(t);
	    p13.subscribeTournament(t);
	    p14.subscribeTournament(t);
	    p15.subscribeTournament(t);
	    p16.subscribeTournament(t);
	    
	    System.out.println(t.getListOfPlayers().get(0).getRatingElo());

	    
	    referee.startTournament();
	    t.getStandings().getStandings();
	    t.getScoreboard().getBoard();
	    System.out.println("ciao");
	    System.out.println(t.getPlayerVariation(p13));
	    System.out.println("ciao");
	    
	    String[] results = {"1-0","0-1","0-1","1-0","0-1","0-1","0-1","0-1"};
	    referee.uploadResults(results);
	    referee.updateStandings();
	    t.getStandings().getStandings();
	    referee.publishNewRound();
	    t.getScoreboard().getBoard();
	    System.out.println("ciao");
	    System.out.println(t.getPlayerVariation(p13));
	    System.out.println("ciao");

	    
	    String[] results2 = {"0-1","0.5-0.5","0-1","0-1","0-1","0-1","0.5-0.5","0-1"};
	    referee.uploadResults(results2);
	    referee.updateStandings();
	    t.getStandings().getStandings();
	    referee.publishNewRound();
	    t.getScoreboard().getBoard();
	    System.out.println("ciao");
	    System.out.println(t.getPlayerVariation(p13));
	    System.out.println("ciao");

	    
	    String[] results3 = {"0.5-0.5","1-0","0.5-0.5","0.5-0.5","0.5-0.5","1-0","0-1","0-1"};
	    referee.uploadResults(results3);
	    referee.updateStandings();
	    t.getStandings().getStandings();
	    referee.publishNewRound();
	    t.getScoreboard().getBoard();
	    System.out.println("ciao");
	    System.out.println(t.getPlayerVariation(p13));
	    System.out.println("ciao");
	    
	    String[] results4 = {"0.5-0.5","0-1","0-1","0.5-0.5","1-0","1-0","0-1","0.5-0.5"};
	    referee.uploadResults(results4);
	    referee.updateStandings();
	    t.getStandings().getStandings();
	    referee.publishNewRound();
	    t.getScoreboard().getBoard();
	    System.out.println("ciao");
	    System.out.println(t.getPlayerVariation(p13));
	    System.out.println("ciao");
	    
	    String[] results5 = {"1-0","0.5-0.5","1-0","0.5-0.5","1-0","1-0","0-1","0.5-0.5"};
	    referee.uploadResults(results5);
	    referee.updateStandings();
	    t.getStandings().getStandings();
	    System.out.println("ciao");
	    System.out.println(t.getPlayerVariation(p13));
	    System.out.println("ciao");
	    
	   



	}

}
