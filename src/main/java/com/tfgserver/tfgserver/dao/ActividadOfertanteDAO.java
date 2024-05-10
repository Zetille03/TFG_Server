package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import com.tfgserver.tfgserver.repositories.ActividadOfertanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadOfertanteDAO {
    @Autowired
    private ActividadOfertanteRepository repository;

    public ActividadOfertante save(ActividadOfertante actividadOfertante){
        return repository.save(actividadOfertante);
    }

    public void delete(ActividadOfertante actividadOfertante){
        repository.delete(actividadOfertante);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

    public boolean exists(ActividadOfertante actividadOfertante){
        return existsById(actividadOfertante.getIdActividadOfertante());
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public List<ActividadOfertante> getAllConsumidores(){
        return Lists.newArrayList(repository.findAll());
    }

}
