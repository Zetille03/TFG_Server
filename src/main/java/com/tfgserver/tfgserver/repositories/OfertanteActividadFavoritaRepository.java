package com.tfgserver.tfgserver.repositories;

import com.tfgserver.tfgserver.entities.OfertanteActividadFavorita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertanteActividadFavoritaRepository extends CrudRepository<OfertanteActividadFavorita, Integer> {
}
