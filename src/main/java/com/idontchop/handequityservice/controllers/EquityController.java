package com.idontchop.handequityservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.idontchop.handequityservice.services.EquityService;

import dtos.HandCalcDto;
import dtos.RestMessage;
import dtos.ResultDto;

@RestController
public class EquityController {
	
	@Autowired EquityService equityService;
	
	@PostMapping("/equity")
	public ResultDto getResult(@RequestBody HandCalcDto dto) {
		
		if ( dto.getHands().size() < 2) {
			throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Hands less than size 2");
		} else if ( dto.getHands().size() > 3) {
			throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Hands more than 3");
		} else if ( dto.getHands().size() > 2 && (dto.getBoard() == null ||  dto.getBoard().length() < 6) ) {
			throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Must have full flop for hands > 2");
		} else if ( dto.getBoard().length() > 0 && (dto.getBoard().length() < 6 || dto.getBoard().length() > 10)) {
			throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Must have 3 or 4 board cards.");
		}
		
		return equityService.doEquityCalc(dto.getHands(), dto.getBoard(), dto.getDead());
	}
	
	/*
	@ExceptionHandler({ ResponseStatusException.class })
	public ResponseEntity<RestMessage> handleError( ResponseStatusException ex, WebRequest request) {
		
	}*/

}
