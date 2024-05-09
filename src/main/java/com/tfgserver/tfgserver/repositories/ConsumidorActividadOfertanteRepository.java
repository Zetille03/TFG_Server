package com.tfgserver.tfgserver.repositories;

import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorActividadOfertanteRepository extends CrudRepository<ConsumidorActividadOfertante,Integer> {
}
