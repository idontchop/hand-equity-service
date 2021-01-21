package com.idontchop.handequityservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dtos.ResultDto;
import pokerTools.EquityCalc;
import pokerTools.EquityCalcObserver;
import pokerTools.HoldemStrings;
import pokerTools.Pocket;

@Service
public class EquityService implements EquityCalcObserver {
	
	private EquityCalc equityCalc = new EquityCalc(this);
	
	public ResultDto doEquityCalc(List<String> hands, String board, String dead) {
		
		if (board == null) board = "";
		if (dead == null) dead = "";
		
		Pocket[][] pockets = new Pocket[hands.size()][];
				
		// convert list of hands to pocket array for equityCalc
		for (int i = 0; i < hands.size(); i++) {
			pockets[i] = HoldemStrings.pocketsToArray(hands.get(i));			
		}
		
		long startTime = System.currentTimeMillis();
		// do calc
		long[][] results = equityCalc.calcEnum(
				pockets, HoldemStrings.cardsToArray(board), HoldemStrings.cardsToArray(dead));
		
		long endTime = System.currentTimeMillis();

		//build dto
		return ResultDto.fromCalc(results)
				.addHands(hands, board, dead)
				.addMillis(endTime-startTime)
				.createResultText();
		
	}
	
	@Override
	public boolean checkStop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEquity(float[] arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
