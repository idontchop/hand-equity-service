
package dtos;
import java.time.LocalDateTime;



/**
 * Bean to store results of a hand equity.
 * Easily output to Json for sharing on idontchop cloud.
 * Fields will map to mysql database though this package only deals in JSON
 * @author sacred
 */
public class ResultDto {
    
    // Should be assigned when values given
    private LocalDateTime created = LocalDateTime.now();

    
    // 0 - 9, arrays not used for easy mapping
    private String hand1;
    private String hand2;
    private String hand3;
    private String hand4;
    private String hand5;
    private String hand6;
    private String hand7;
    private String hand8;
    private String hand9;
    private String hand10;
    
    private long wins1;
    private long wins2;
    private long wins3;
    private long wins4;
    private long wins5;
    private long wins6;
    private long wins7;
    private long wins8;
    private long wins9;
    private long wins10;

    private long ties1;
    private long ties2;
    private long ties3;
    private long ties4;
    private long ties5;
    private long ties6;
    private long ties7;
    private long ties8;
    private long ties9;
    private long ties10;
    
    // System information
    private String systeminfo;
    
    // calculation info
    private long numGames;
    private long elapsedMillis;
    
    // Extraneous info for saving
    private String board;
    private String dead;
    
    private String resultText;      // lazy way of simply saving evaluation output
    
    public ResultDto () {
    }
    
    /**
     * Returns a new instance of Dto from results
     * @param results
     */
    public static ResultDto fromCalc(long[][] results) {
    	ResultDto dto = new ResultDto();
    	
    	for ( int i = 0; i < results.length; i++) {
    		dto.setWin(results[i][0], i+1);
    		dto.setTie(results[i][1], i+1);
    	}
    	
    	dto.setNumGames(results[0][2]);
    	
    	return dto;
    }
       
    public void setHands(String ...hands) {
        for (int i = 0; i < hands.length; i++) {
            
        }
    }


    public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getDead() {
		return dead;
	}

	public void setDead(String dead) {
		this.dead = dead;
	}

	/**
     * @return the systeminfo
     */
    public String getSysteminfo() {
        return systeminfo;
    }

    /**
     * @param systeminfo the systeminfo to set
     */
    public void setSysteminfo(String systeminfo) {
        this.systeminfo = systeminfo;
    }

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/**
     * @return the hand1
     */
    public String getHand1() {
        return hand1;
    }

    /**
     * @param hand1 the hand1 to set
     */
    public void setHand1(String hand1) {
        this.hand1 = hand1;
    }

    /**
     * @return the hand2
     */
    public String getHand2() {
        return hand2;
    }

    /**
     * @param hand2 the hand2 to set
     */
    public void setHand2(String hand2) {
        this.hand2 = hand2;
    }

    /**
     * @return the hand3
     */
    public String getHand3() {
        return hand3;
    }

    /**
     * @param hand3 the hand3 to set
     */
    public void setHand3(String hand3) {
        this.hand3 = hand3;
    }

    /**
     * @return the hand4
     */
    public String getHand4() {
        return hand4;
    }

    /**
     * @param hand4 the hand4 to set
     */
    public void setHand4(String hand4) {
        this.hand4 = hand4;
    }

    /**
     * @return the hand5
     */
    public String getHand5() {
        return hand5;
    }

    /**
     * @param hand5 the hand5 to set
     */
    public void setHand5(String hand5) {
        this.hand5 = hand5;
    }

    /**
     * @return the hand6
     */
    public String getHand6() {
        return hand6;
    }

    /**
     * @param hand6 the hand6 to set
     */
    public void setHand6(String hand6) {
        this.hand6 = hand6;
    }

    /**
     * @return the hand7
     */
    public String getHand7() {
        return hand7;
    }

    /**
     * @param hand7 the hand7 to set
     */
    public void setHand7(String hand7) {
        this.hand7 = hand7;
    }

    /**
     * @return the hand8
     */
    public String getHand8() {
        return hand8;
    }

    /**
     * @param hand8 the hand8 to set
     */
    public void setHand8(String hand8) {
        this.hand8 = hand8;
    }

    /**
     * @return the hand9
     */
    public String getHand9() {
        return hand9;
    }

    /**
     * @param hand9 the hand9 to set
     */
    public void setHand9(String hand9) {
        this.hand9 = hand9;
    }

    /**
     * @return the hand10
     */
    public String getHand10() {
        return hand10;
    }

    /**
     * @param hand10 the hand10 to set
     */
    public void setHand10(String hand10) {
        this.hand10 = hand10;
    }

    /**
     * @return the numGames
     */
    public long getNumGames() {
        return numGames;
    }

    /**
     * @param numGames the numGames to set
     */
    public void setNumGames(long numGames) {
        this.numGames = numGames;
    }

    /**
     * @return the elapsedMillis
     */
    public long getElapsedMillis() {
        return elapsedMillis;
    }

    /**
     * @param elapsedMillis the elapsedMillis to set
     */
    public void setElapsedMillis(long elapsedMillis) {
        this.elapsedMillis = elapsedMillis;
    }

    /**
     * helps in getting formatted text for wins / ties
     * 
     * @param handNum 1-10 corresponds
     * @param percentage true if percentage, false for total
     * @return 
     */
    public String getWins ( int handNum, boolean percentage ) {
        String win = "";
        long wins = 0L;
        
        switch (handNum) {
            case 1: wins = getWins1(); break;
            case 2: wins = getWins2(); break;
            case 3: wins = getWins3(); break;
            case 4: wins = getWins4(); break;
            case 5: wins = getWins5(); break;
            case 6: wins = getWins6(); break;
            case 7: wins = getWins7(); break;
            case 8: wins = getWins8(); break;
            case 9: wins = getWins9(); break;
        }
        
        win = percentage ?
                String.format("%.2f", (double) ( (double)wins / (double) numGames)*100 ):
                Long.toString(wins);
        
        return win;
    }
    
    /**
     * See getWins()
     * @param handNum
     * @param percentage
     * @return 
     */
    public String getTies ( int handNum, boolean percentage ) {
        String tie = "";
        long ties = 0L;
        
        switch ( handNum ) {
            case 1: ties = getTies1(); break;
            case 2: ties = getTies2(); break;
            case 3: ties = getTies3(); break;
            case 4: ties = getTies4(); break;
            case 5: ties = getTies5(); break;
            case 6: ties = getTies6(); break;
            case 7: ties = getTies7(); break;
            case 8: ties = getTies8(); break;
            case 9: ties = getTies9(); break;
            case 10: ties = getTies10(); break;
        }
        
        tie = percentage ?
                String.format("%.2f", (double) ( (double)ties / (double) numGames)*100 ) :
                Long.toString(ties);
        
        return tie;
    }
    
    /**
     * receives a results array from equityCalc and populates variables here
     * @param results 
     */
    public void parseResults ( long[][] results ) {
        
        numGames = results[0][2];
        for ( int i = 0; i < results.length; i++) {
            setWin ( results[i][0], i+1 );
            setTie ( results[i][1], i+1 );
        }
        
    }
    
    /**
     * Assists in setting the proper variable.
     * Note, this corresponds to starting at 1 so array loops must +1
     * @param win
     * @param handNum 
     */
    public void setWin ( long win, int handNum ) {
        switch (handNum) {
            case 1: setWins1(win); break;
            case 2: setWins2(win); break;
            case 3: setWins3(win); break;
            case 4: setWins4(win); break;
            case 5: setWins5(win); break;
            case 6: setWins6(win); break;
            case 7: setWins7(win); break;
            case 8: setWins8(win); break;
            case 9: setWins9(win); break;
            case 10: setWins10(win); break;
        }
    }   
    
    /**     * Assists in setting the proper variable.
     * Note, this corresponds to starting at 1 so array loops must +1
     * 
     * @param tie
     * @param handNum 
     */
    public void setTie ( long tie, int handNum ) {
        switch (handNum) {
            case 1: setTies1(tie); break;
            case 2: setTies2(tie); break;
            case 3: setTies3(tie); break;
            case 4: setTies4(tie); break;
            case 5: setTies5(tie); break;
            case 6: setTies6(tie); break;
            case 7: setTies7(tie); break;
            case 8: setTies8(tie); break;
            case 9: setTies9(tie); break;
            case 10: setTies10(tie); break;
        }        
    }
    
    public void setHand ( String hand, int handNum) {
        switch (handNum) {
            case 1: hand1 = hand; break;
            case 2: hand2 = hand; break;
            case 3: hand3 = hand; break;
            case 4: hand4 = hand; break;
            case 5: hand5 = hand; break;
            case 6: hand6 = hand; break;
            case 7: hand7 = hand; break;
            case 8: hand8 = hand; break;
            case 9: hand9 = hand; break;
            case 10: hand10 = hand; break;
        }
    }
    
    public void setResultText(String resultText) {
        this.resultText = resultText;
    }
    
    public String getResultText() {
        return resultText;
    }
    
        /**
     * @return the wins1
     */
    public long getWins1() {
        return wins1;
    }

    /**
     * @param wins1 the wins1 to set
     */
    public void setWins1(long wins1) {
        this.wins1 = wins1;
    }

    /**
     * @return the wins2
     */
    public long getWins2() {
        return wins2;
    }

    /**
     * @param wins2 the wins2 to set
     */
    public void setWins2(long wins2) {
        this.wins2 = wins2;
    }

    /**
     * @return the wins3
     */
    public long getWins3() {
        return wins3;
    }

    /**
     * @param wins3 the wins3 to set
     */
    public void setWins3(long wins3) {
        this.wins3 = wins3;
    }

    /**
     * @return the wins4
     */
    public long getWins4() {
        return wins4;
    }

    /**
     * @param wins4 the wins4 to set
     */
    public void setWins4(long wins4) {
        this.wins4 = wins4;
    }

    /**
     * @return the wins5
     */
    public long getWins5() {
        return wins5;
    }

    /**
     * @param wins5 the wins5 to set
     */
    public void setWins5(long wins5) {
        this.wins5 = wins5;
    }

    /**
     * @return the wins6
     */
    public long getWins6() {
        return wins6;
    }

    /**
     * @param wins6 the wins6 to set
     */
    public void setWins6(long wins6) {
        this.wins6 = wins6;
    }

    /**
     * @return the wins7
     */
    public long getWins7() {
        return wins7;
    }

    /**
     * @param wins7 the wins7 to set
     */
    public void setWins7(long wins7) {
        this.wins7 = wins7;
    }

    /**
     * @return the wins8
     */
    public long getWins8() {
        return wins8;
    }

    /**
     * @param wins8 the wins8 to set
     */
    public void setWins8(long wins8) {
        this.wins8 = wins8;
    }

    /**
     * @return the wins9
     */
    public long getWins9() {
        return wins9;
    }

    /**
     * @param wins9 the wins9 to set
     */
    public void setWins9(long wins9) {
        this.wins9 = wins9;
    }

    /**
     * @return the wins10
     */
    public long getWins10() {
        return wins10;
    }

    /**
     * @param wins10 the wins10 to set
     */
    public void setWins10(long wins10) {
        this.wins10 = wins10;
    }

    /**
     * @return the ties1
     */
    public long getTies1() {
        return ties1;
    }

    /**
     * @param ties1 the ties1 to set
     */
    public void setTies1(long ties1) {
        this.ties1 = ties1;
    }

    /**
     * @return the ties2
     */
    public long getTies2() {
        return ties2;
    }

    /**
     * @param ties2 the ties2 to set
     */
    public void setTies2(long ties2) {
        this.ties2 = ties2;
    }

    /**
     * @return the ties3
     */
    public long getTies3() {
        return ties3;
    }

    /**
     * @param ties3 the ties3 to set
     */
    public void setTies3(long ties3) {
        this.ties3 = ties3;
    }

    /**
     * @return the ties4
     */
    public long getTies4() {
        return ties4;
    }

    /**
     * @param ties4 the ties4 to set
     */
    public void setTies4(long ties4) {
        this.ties4 = ties4;
    }

    /**
     * @return the ties5
     */
    public long getTies5() {
        return ties5;
    }

    /**
     * @param ties5 the ties5 to set
     */
    public void setTies5(long ties5) {
        this.ties5 = ties5;
    }

    /**
     * @return the ties6
     */
    public long getTies6() {
        return ties6;
    }

    /**
     * @param ties6 the ties6 to set
     */
    public void setTies6(long ties6) {
        this.ties6 = ties6;
    }

    /**
     * @return the ties7
     */
    public long getTies7() {
        return ties7;
    }

    /**
     * @param ties7 the ties7 to set
     */
    public void setTies7(long ties7) {
        this.ties7 = ties7;
    }

    /**
     * @return the ties8
     */
    public long getTies8() {
        return ties8;
    }

    /**
     * @param ties8 the ties8 to set
     */
    public void setTies8(long ties8) {
        this.ties8 = ties8;
    }

    /**
     * @return the ties9
     */
    public long getTies9() {
        return ties9;
    }

    /**
     * @param ties9 the ties9 to set
     */
    public void setTies9(long ties9) {
        this.ties9 = ties9;
    }

    /**
     * @return the ties10
     */
    public long getTies10() {
        return ties10;
    }

    /**
     * @param ties10 the ties10 to set
     */
    public void setTies10(long ties10) {
        this.ties10 = ties10;
    }
    
}
