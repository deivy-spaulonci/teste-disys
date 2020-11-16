package com.testedisys.controller;

import com.testedisys.model.Departamento;
import com.testedisys.model.Funcionario;
import com.testedisys.serviceImpl.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController implements Serializable {

    @Autowired
    private final DepartamentoServiceImpl departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoServiceImpl departamentoService) {
        super();
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public Page<Departamento> get(Pageable pageable){
        Page<Departamento> resultPage = departamentoService.departamentosPage(pageable);
        return  resultPage;
    }

    @GetMapping("/departamentos")
    public List<Departamento> departamentos(){
        return departamentoService.departamentoList();
    }

    @GetMapping("/fucionariosPorDepartamento/{id}")
    public List<Funcionario> funcionariosByDepartamento(@PathVariable int id){
        return departamentoService.findDepartamentoById(id).getFuncionarios().stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Departamento findById(@PathVariable int id){
        return departamentoService.findDepartamentoById(id);
    }

    @PostMapping
    public ResponseEntity<Departamento> save(@Valid @RequestBody Departamento departamento){
        this.departamentoService.save(departamento);
        return new ResponseEntity<>(departamento, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Departamento> update(@Valid @RequestBody Departamento departamento){
        this.departamentoService.save(departamento);
        return new ResponseEntity<>(departamento, HttpStatus.GONE);
    }

}

