package com.br.testedisys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.br.testedisys")
@EnableJpaRepositories("com.br.testedisys.repository")
@EntityScan("com.br.testedisys.model")
public class TestedisysApplication {

	private static final Logger log = LoggerFactory.getLogger(TestedisysApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestedisysApplication.class, args);
		System.out.println("utilizando o spring boot");
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("Iniciando sistema de teste Disys");
		};
	}

}
