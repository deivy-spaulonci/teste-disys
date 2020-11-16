package com.testedisys.serviceImpl;

import com.testedisys.exception.IdNotFound;
import com.testedisys.model.Cargo;
import com.testedisys.model.Funcionario;
import com.testedisys.repository.FuncionarioRepository;
import com.testedisys.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario findFuncionarioById(int id) {
        return funcionarioRepository.findById(Integer.valueOf(id)).orElseThrow(IdNotFound::new);
    }

    @Override
    public void excluirFuncionario(int id) {
        funcionarioRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public List<Funcionario> funcionarioByCargo(Cargo cargo) {
        return null;
    }

    @Override
    public List<Funcionario> funcionarioList() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Page<Funcionario> funcionarioPage(Pageable pageable) {
        return funcionarioPage(pageable);
    }

    @Override
    public List<Funcionario> funcionarioByDepartamento(int departamento_id) {
        return null;
    }


}
