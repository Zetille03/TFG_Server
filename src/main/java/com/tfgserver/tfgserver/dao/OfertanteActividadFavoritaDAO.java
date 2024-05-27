package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.OfertanteActividadFavorita;
import com.tfgserver.tfgserver.repositories.OfertanteActividadFavoritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertanteActividadFavoritaDAO {
    @Autowired
    private OfertanteActividadFavoritaRepository repository;

    public OfertanteActividadFavorita save(OfertanteActividadFavorita entity) {
        return repository.save(entity);
    }

    public void delete(OfertanteActividadFavorita entity) {
        repository.delete(entity);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    public List<OfertanteActividadFavorita> getAllOfertanteActividadesFavoritas(){
        return Lists.newArrayList(repository.findAll());
    }

    public OfertanteActividadFavorita getById(int id) {
        return (repository.findById(id).isPresent())?repository.findById(id).get():null;
    }

}
