package com.example.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloworldApplication {

	@Value("${TARGET:World}")
	String target;

	@RestController
	class HelloworldController {
		@GetMapping("/")
		String hello() { 
			return "Hello " + target + "!";
		}

		@GetMapping("/test")
		String redeploy() {
			return "app was re-deployed again!";
		}

		@GetMapping("/testing")
		String redeployagain() {
			return "app was re-deployed again! look!";
		}

		@GetMapping("/testingv2")
		String redeployagainv2() {
			return "app was re-deployed again now";
		}

		@GetMapping("/testingv3")
		String redeployagainv3() {
			return "app was re-deployed again now right now";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

}
