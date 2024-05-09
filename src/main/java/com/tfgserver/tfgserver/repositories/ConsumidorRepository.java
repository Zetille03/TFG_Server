package com.tfgserver.tfgserver.repositories;

import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorRepository extends CrudRepository<Consumidor,Integer> {
}
