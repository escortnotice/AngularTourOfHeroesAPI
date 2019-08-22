package com.tourofheroes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tourofheroes.model.APIResponse;
import com.tourofheroes.model.Hero;
import com.tourofheroes.repository.HeroRepository;
import com.tourofheroes.util.BuildResponseUtil;

@RestController
public class HeroRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HeroRestController.class);

	@Autowired
	HeroRepository heroRepo;

	
	@GetMapping("/hero")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResponse getHeroes() {
		LOGGER.info("Inside get Heroes");
		List<Hero> heroList = heroRepo.getHeroes();
		return BuildResponseUtil.buildSuccessResponseObject(heroList, "List of Heroes Fetched Successfully");
	}
	
	@GetMapping("/hero/{id}")
	@ResponseBody
	public APIResponse getHero(@PathVariable int id) {
		Hero hero = heroRepo.getHero(id);
		return BuildResponseUtil.buildSuccessResponseObject(hero, "Hero Details Fetched Successfully"); 
	}
	
	@PutMapping("/hero")
	public void updateHero(@RequestBody Hero hero) {
		
		heroRepo.updateHero(hero);
	}
	
	@PostMapping(path="/hero")
	@ResponseBody
	@ResponseStatus(value= HttpStatus.CREATED)
	public Hero addHero(@RequestBody Hero hero) {
		return heroRepo.addHero(hero);
	}
	
	@DeleteMapping("/hero/{id}")
	public void addHero(@PathVariable int id) {
		heroRepo.delete(id);
	}
	
	@GetMapping("/hero/search")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public APIResponse searchHero(@RequestParam("name") String name){
		List<Hero> heroList =  heroRepo.search(name);
		return BuildResponseUtil.buildSuccessResponseObject(heroList, "Heroes Searched Successfully"); 
		
	}
}
