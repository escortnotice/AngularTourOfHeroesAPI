package com.tourofheroes.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourofheroes.customexception.CustomBaseException;
import com.tourofheroes.model.APIResponse;
import com.tourofheroes.model.Hero;
import com.tourofheroes.service.TestErrorService;
import com.tourofheroes.service.TestSuccessService;

@RestController
public class TestRestController {
	
	@Autowired
	TestErrorService testErrorService;
	
	@Autowired
	TestSuccessService testSuccessService;

	@GetMapping("/")
	public String test() {
		return "Spring Boot Application is Working Fine";
	}
	
	/*
	 * Handling exception occurred in Service layer
	 */
	@GetMapping("/test-error-service")
	public APIResponse testErrorService() throws CustomBaseException {
		
		testErrorService.testBusinessServiceException();
		
		//in case of success
		APIResponse apiResp = new APIResponse();
		apiResp.setSuccess(true);
		return apiResp;
		
	}
	
	/*
	 * Handling exception occurred in Repository Layer
	 */
	@GetMapping("/test-error-repo")
	public APIResponse testErrorRepo() throws CustomBaseException {
		
		testErrorService.testRepoServiceException();
		
		//in case of success
		APIResponse apiResp = new APIResponse();
		apiResp.setSuccess(true);
		return apiResp;
			
	}
	
	/*
	 * Handling success
	 * Single Object as response
	 */
	@GetMapping("/test-success")
	public APIResponse testSuccess() {
		
		Hero hero = testSuccessService.testSuccessMessage();
		return buildSuccessResponseObject(hero, "Hero Fetched Successfully");
	}
	
	/*
	 * Handling success
	 * List of Objects as response
	 */
	@GetMapping("/test-success-list")
	public APIResponse testSuccessList() {
		
		Hero hero = testSuccessService.testSuccessMessage();
		List<Hero> heroList = new ArrayList<>();
		heroList.add(hero);
		heroList.add(hero);
		return buildSuccessResponseObject(heroList,"Hero List Fetched Successfully");
	}
	
	
	/*
	 * Handling success
	 * Map as response
	 */
	@GetMapping("/test-success-map")
	public APIResponse testSuccessMap() {
		
		Hero hero = testSuccessService.testSuccessMessage();
		Map<String, Hero> heroMap = new HashMap<>();
		heroMap.put("1", hero);
		heroMap.put("2", hero);
		return buildSuccessResponseObject(heroMap, "Hero Map Fetched Successfully");
	}
	
	
	//Build the success Response
	private APIResponse buildSuccessResponseObject(Object result, String message) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(message);
		apiResponse.setSuccess(true);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // ex: 2016/11/16 12:08:43
		
		apiResponse.setData(result);
		
		return apiResponse;
	
	}
}
