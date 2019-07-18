package com.tourofheroes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourofheroes.model.Hero;
import com.tourofheroes.repository.HeroRepository;

@RestController
@RequestMapping("/api/v1/")
public class HeroRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HeroRestController.class);

	@Autowired
	HeroRepository heroRepo;

	
	@GetMapping("/hero")
	@ResponseBody
	public List<Hero> getHeroes() {
		System.out.println("Inside get Heroes");
		LOGGER.info("from Logger Inside get Heroes");
		return heroRepo.getHeroes();
	}
	
	@GetMapping("/hero/{id}")
	@ResponseBody
	public Hero getHero(@PathVariable int id) {
		return heroRepo.getHero(id);
	}
	
	@PutMapping("/hero")
	public void updateHero(@RequestBody Hero hero) {
		
		heroRepo.updateHero(hero);
	}
	
	@PostMapping("/hero")
	@ResponseBody
	public Hero addHero(@RequestBody Hero hero) {
		return heroRepo.addHero(hero);
	}
	
	@DeleteMapping("/hero/{id}")
	public void addHero(@PathVariable int id) {
		heroRepo.delete(id);
	}
	
	@GetMapping("/hero/search")
	@ResponseBody
	public List<Hero> searchHero(@RequestParam("name") String name){
		return heroRepo.search(name);
	}
}
