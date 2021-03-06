package com.testedisys.service;

import com.testedisys.model.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartamentoService {

    abstract Departamento save(Departamento departameto);

    abstract Departamento findDepartamentoById(int id);

    abstract List<Departamento> departamentoList();

    abstract Page<Departamento> departamentosPage(Pageable pageable);
}

