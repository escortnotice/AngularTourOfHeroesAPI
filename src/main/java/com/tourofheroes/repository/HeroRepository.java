package com.tourofheroes.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.tourofheroes.model.Hero;

@Repository
public class HeroRepository {

	Hero[] heroesArray = { new Hero("Batman", 1), new Hero("Narco", 2), new Hero("Bombasto", 3),
			new Hero("Celeritas", 4), new Hero("Magneta", 5), new Hero("RubberMan", 6), new Hero("Magma", 7),
			new Hero("SuperMan", 8) };

	public List<Hero> heroesList = new ArrayList<>(Arrays.asList(heroesArray));

	
	
	public List<Hero> getHeroes() {
		return heroesList;
	}

	
	public Hero getHero(int id) {
		
		return heroesList.stream()
				.filter(hero -> id == hero.getId())
				.findAny()
				.orElse(null);
	}

	public Hero addHero(Hero hero) {
		hero.setId((int)(11 + (10 * Math.random())));
		heroesList.add(hero);
		return hero;
	}
	
	public void updateHero(Hero hero) {
		int index = 0;
		for (Hero heroElement : heroesList) {
			
			if (heroElement.getId() == hero.getId()) {
				heroesList.set(index, hero);
				break;
			}
				
			index++;
		}
		

	}


	public void delete(int id) {
		int index = 0;
		for(Hero heroElement : heroesList) {
			if(id == heroElement.getId()) {
				heroesList.remove(index);
				break;
			}
				
			index++;
		}
		
	}


	public List<Hero> search(String name) {
		
		return heroesList.stream().filter(element -> element.getName().startsWith(name)).collect(Collectors.toList());
		
	}
}
