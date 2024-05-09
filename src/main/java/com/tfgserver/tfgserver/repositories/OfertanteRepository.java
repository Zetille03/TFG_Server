package com.tfgserver.tfgserver.repositories;

import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertanteRepository extends CrudRepository<Ofertante,Integer> {
}
