package com.tfgserver.tfgserver.repositories;

import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorActividadFavoritaRepository extends CrudRepository<ConsumidorActividadFavorita, Integer> {
}
