package com.tfgserver.tfgserver.repositories;

import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadConsumidorRepository extends CrudRepository<ActividadConsumidor,Integer> {
}
