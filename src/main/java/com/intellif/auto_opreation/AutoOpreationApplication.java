package com.intellif.auto_opreation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AutoOpreationApplication {
	@RequestMapping("/")
	public String index(){
		return "get start";
	}
	public static void main(String[] args) {
		SpringApplication.run(AutoOpreationApplication.class, args);
	}
}
