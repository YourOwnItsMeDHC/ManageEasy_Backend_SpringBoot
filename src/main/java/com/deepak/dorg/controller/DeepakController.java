package com.deepak.dorg.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DeepakController {
	
	@GetMapping("/api")
	public String getDeepak() {
		return "Deppak Chourasiya";
	}
}
