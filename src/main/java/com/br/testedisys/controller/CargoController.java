package com.br.testedisys.controller;

import com.br.testedisys.model.Cargo;
import com.br.testedisys.serviceImpl.CargoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController implements Serializable {

    @Autowired
    private final CargoServiceImpl cargoService;

    @Autowired
    public CargoController(CargoServiceImpl cargoService) {
        super();
        this.cargoService = cargoService;
    }

    @GetMapping
    public Page<Cargo> get(Pageable pageable){
        Page<Cargo> resultPage = cargoService.cargosPage(pageable);
        return resultPage;
    }

    @GetMapping("/cargos")
    public List<Cargo> cargos(){
        return cargoService.cargosList();
    }

    @GetMapping("/{id}")
    public Cargo findById(@PathVariable int id){
        return this.cargoService.findCargoById(id);
    }

    @PostMapping
    public ResponseEntity<Cargo> save(@Valid @RequestBody Cargo cargo){
        this.cargoService.save(cargo);
        return new ResponseEntity<>(cargo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cargo> update(@Valid @RequestBody Cargo cargo){
        this.cargoService.save(cargo);
        return new ResponseEntity<>(cargo, HttpStatus.GONE);
    }

}
