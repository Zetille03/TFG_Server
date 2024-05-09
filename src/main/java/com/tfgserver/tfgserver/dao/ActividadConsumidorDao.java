package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import com.tfgserver.tfgserver.repositories.ActividadConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadConsumidorDao {
    @Autowired
    private ActividadConsumidorRepository repository;

    public void save(ActividadConsumidor actividadConsumidor){
        repository.save(actividadConsumidor);
    }

    public void delete(ActividadConsumidor actividadConsumidor){
        repository.delete(actividadConsumidor);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

    public boolean exists(ActividadConsumidor actividadConsumidor){
        return existsById(actividadConsumidor.getIdActividadConsumidor());
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public List<ActividadConsumidor> getAllConsumidores(){
        return Lists.newArrayList(repository.findAll());
    }

}
