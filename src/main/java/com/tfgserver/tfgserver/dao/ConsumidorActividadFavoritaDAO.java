package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import com.tfgserver.tfgserver.repositories.ConsumidorActividadFavoritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsumidorActividadFavoritaDAO {
    @Autowired
    private ConsumidorActividadFavoritaRepository repository;

    public ConsumidorActividadFavorita save(ConsumidorActividadFavorita entity) {
        return repository.save(entity);
    }

    public void delete(ConsumidorActividadFavorita entity) {
        repository.delete(entity);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    public List<ConsumidorActividadFavorita> getAllConsumidorActividadesFavoritas(){
        return Lists.newArrayList(repository.findAll());
    }

    public ConsumidorActividadFavorita getById(int id) {
        return (repository.findById(id).isPresent())?repository.findById(id).get():null;
    }
}
