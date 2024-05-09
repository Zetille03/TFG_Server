package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import com.tfgserver.tfgserver.repositories.OfertanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertanteDAO {
    @Autowired
    private OfertanteRepository repository;

    public void save(Ofertante ofertante){
        repository.save(ofertante);
    }

    public void delete(Ofertante ofertante){
        repository.delete(ofertante);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

    public boolean exists(Ofertante ofertante){
        return existsById(ofertante.getIdOfertante());
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public List<Ofertante> getAllConsumidores(){
        return Lists.newArrayList(repository.findAll());
    }
}
