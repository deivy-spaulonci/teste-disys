package com.testedisys.service;

import com.testedisys.model.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CargoService {

    abstract Cargo save(Cargo cargo);

    abstract Cargo findCargoById(int id);

    abstract List<Cargo> cargosList();

    abstract Page<Cargo> cargosPage(Pageable pageable);

}
