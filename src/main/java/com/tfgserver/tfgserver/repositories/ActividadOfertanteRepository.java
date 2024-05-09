package com.tfgserver.tfgserver.repositories;

import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadOfertanteRepository extends CrudRepository<ActividadOfertante,Integer> {
}
