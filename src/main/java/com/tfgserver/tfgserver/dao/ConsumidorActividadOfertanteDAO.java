package com.tfgserver.tfgserver.dao;

import com.google.common.collect.Lists;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import com.tfgserver.tfgserver.repositories.ActividadOfertanteRepository;
import com.tfgserver.tfgserver.repositories.ConsumidorActividadOfertanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumidorActividadOfertanteDAO {
    @Autowired
    private ConsumidorActividadOfertanteRepository repository;

    public ConsumidorActividadOfertante save(ConsumidorActividadOfertante consumidorActividadOfertante){
        return repository.save(consumidorActividadOfertante);
    }

    public void delete(ConsumidorActividadOfertante consumidorActividadOfertante){
        repository.delete(consumidorActividadOfertante);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

    public boolean exists(ConsumidorActividadOfertante consumidorActividadOfertante){
        return existsById(consumidorActividadOfertante.getIdConsumidorActividadOfertante());
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public List<ConsumidorActividadOfertante> getAllConsumidorActividadOfertantes(){
        return Lists.newArrayList(repository.findAll());
    }
}
