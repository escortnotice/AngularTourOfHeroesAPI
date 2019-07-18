package com.tourofheroes.service;

import org.springframework.stereotype.Service;

import com.tourofheroes.model.Hero;

@Service
public class TestSuccessService {

	public Hero testSuccessMessage(){
		
		return new Hero("Tom Hanks",50);
		
	}
}



