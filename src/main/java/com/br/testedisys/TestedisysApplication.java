package com.br.testedisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.br.testedisys")
public class TestedisysApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestedisysApplication.class, args);
		System.out.println("utilizando o spring boot");
	}

}
