package com.testedisys.service;

import com.testedisys.model.Cargo;
import com.testedisys.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FuncionarioService {

    abstract Funcionario save(Funcionario funcionario);

    abstract Funcionario findFuncionarioById(int id);

    abstract void excluirFuncionario(int id);

    abstract List<Funcionario> funcionarioByDepartamento(int departamento_id);

    abstract List<Funcionario> funcionarioByCargo(Cargo cargo);

    abstract List<Funcionario> funcionarioList();

    abstract Page<Funcionario> funcionarioPage(Pageable pageable);
}
