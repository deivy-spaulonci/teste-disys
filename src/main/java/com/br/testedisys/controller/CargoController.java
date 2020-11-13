package com.br.testedisys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @GetMapping()
    public String testewebservice(){
        return "teste de conteudo de webservice";
    }
}
