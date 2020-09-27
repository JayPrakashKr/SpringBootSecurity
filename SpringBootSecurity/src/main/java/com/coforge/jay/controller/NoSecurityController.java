package com.coforge.jay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/noauth")
public class NoSecurityController {
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Good Morning";
	}
}
