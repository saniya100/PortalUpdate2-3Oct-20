package com.altran.hack100.app.portal;

import org.springframework.boot.SpringApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableSwagger2
public class AltranHackAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AltranHackAppApplication.class, args);
	}

}
