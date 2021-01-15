package dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * Sent by front end with hands, board, dead
 * 
 * @author micro
 *
 */
public class HandCalcDto {

	private List<String> hands = new ArrayList<>();
	private String board = null;
	private String dead = null;
	
	public List<String> getHands() {
		return hands;
	}
	public void setHands(List<String> hands) {
		this.hands = hands;
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
	
	
	
}
