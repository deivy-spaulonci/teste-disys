package com.testedisys.controller;

import com.testedisys.model.Funcionario;
import com.testedisys.serviceImpl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController implements Serializable {

    @Autowired
    private final FuncionarioServiceImpl funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioServiceImpl funcionarioService) {
        super();
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public Page<Funcionario> get(Pageable pageable){
        Page<Funcionario> resultPage = funcionarioService.funcionarioPage(pageable);
        return  resultPage;
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> funcionarios(){
        return funcionarioService.funcionarioList();
    }

    @GetMapping("/{id}")
    public Funcionario findById(@PathVariable int id){
        return funcionarioService.findFuncionarioById(id);
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@Valid @RequestBody Funcionario funcionario){
        this.funcionarioService.save(funcionario);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(@Valid @RequestBody Funcionario funcionario){
        this.funcionarioService.save(funcionario);
        return new ResponseEntity<>(funcionario, HttpStatus.GONE);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.funcionarioService.findFuncionarioById(id);
        this.funcionarioService.excluirFuncionario(id);
    }
}
