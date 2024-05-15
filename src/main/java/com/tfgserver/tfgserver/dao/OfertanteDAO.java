package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import com.tfgserver.tfgserver.repositories.OfertanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertanteDAO {
    @Autowired
    private OfertanteRepository repository;

    public Ofertante save(Ofertante ofertante){
        return repository.save(ofertante);
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

    public List<Ofertante> getAllOfertantes(){
        return Lists.newArrayList(repository.findAll());
    }

    public Ofertante getById(int id){
        return (repository.findById(id).isPresent())?repository.findById(id).get():null;
    }


    public Ofertante checkLogin(String user, String password){
        for(Ofertante ofertante : repository.findAll())
        {
            if(ofertante.getUsername().equals(user) && ofertante.getPassword().equals(password)) return ofertante;
        }
        return null;
    }
}
