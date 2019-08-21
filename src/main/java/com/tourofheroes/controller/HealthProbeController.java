package com.tourofheroes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthProbeController {

	@GetMapping("/health")
	@ResponseBody
	public String checkApplicationhealth() {
		return "OK";
	}
}
