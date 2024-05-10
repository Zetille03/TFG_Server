package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.repositories.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumidorDAO {

    @Autowired
    private ConsumidorRepository repository;

    public Consumidor save(Consumidor consumidor){
        return repository.save(consumidor);
    }

    public void delete(Consumidor consumidor){
        repository.delete(consumidor);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

    public boolean exists(Consumidor consumidor){
        return existsById(consumidor.getIdConsumidor());
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public List<Consumidor> getAllConsumidores(){
        return Lists.newArrayList(repository.findAll());
    }


}
