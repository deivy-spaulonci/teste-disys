package com.br.testedisys.serviceImpl;

import com.br.testedisys.exception.IdNotFound;
import com.br.testedisys.model.Cargo;
import com.br.testedisys.repository.CargoRepository;
import com.br.testedisys.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Cargo findCargoById(int id) {
        return this.cargoRepository.findById(id).orElseThrow(IdNotFound::new);
    }

    @Override
    public List<Cargo> cargosList() {
        return cargoRepository.findAll();
    }

    @Override
    public Page<Cargo> cargosPage(Pageable page) {
        return cargoRepository.findAll(page);
    }
}