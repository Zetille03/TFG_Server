package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ConsumidorDAO;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumidorController {

    @Autowired
    private ConsumidorDAO consumidorDAO;

    @GetMapping("/consumidor/get-all")
    public List<Consumidor> getAllConsumidores(){
        return consumidorDAO.getAllConsumidores();
    }

}
