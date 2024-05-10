package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ConsumidorDAO;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsumidorController {

    @Autowired
    private ConsumidorDAO consumidorDAO;

    @GetMapping("/consumidor/get-all")
    public List<Consumidor> getAllConsumidores(){
        return consumidorDAO.getAllConsumidores();
    }

    @PostMapping("/consumidor/save")
    public Consumidor save(@RequestBody Consumidor consumidor){
        return consumidorDAO.save(consumidor);
    }

    @DeleteMapping("/consumidor/deletebyid")
    public void delete(@RequestParam int id){
        consumidorDAO.deleteById(id);
    }

}
