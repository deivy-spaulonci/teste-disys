package com.testedisys;

import com.testedisys.model.Departamento;
import com.testedisys.model.Funcionario;
import com.testedisys.repository.CargoRepository;
import com.testedisys.repository.DepartamentoRepository;
import com.testedisys.repository.FuncionarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@ComponentScan("com.br.testedisys")
@EnableJpaRepositories("com.testedisys.repository")
@EntityScan("com.testedisys.model")
public class TestedisysApplication {

	private static final Logger log = LoggerFactory.getLogger(TestedisysApplication.class);

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	DepartamentoRepository departamentoRepository;

	@Autowired
	CargoRepository cargoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestedisysApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("Iniciando sistema de teste Disys");
		};
	}

}
