package com.testedisys.serviceImpl;

import com.testedisys.exception.IdNotFound;
import com.testedisys.model.Departamento;
import com.testedisys.repository.DepartamentoRepository;
import com.testedisys.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DepartamentoRepository departamentoRepository;


    @Override
    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento findDepartamentoById(int id) {
        return departamentoRepository.findById(Integer.valueOf(id)).orElseThrow(IdNotFound::new);
    }

    @Override
    public List<Departamento> departamentoList() {
        return departamentoRepository.findAll();
    }

    @Override
    public Page<Departamento> departamentosPage(Pageable pageable) {
        return departamentoRepository.findAll(pageable);
    }
}
