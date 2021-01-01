package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class HelloController {

	@GetMapping("/home")
	public String index() {
		return "Hello ";
	}

}
