package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ConsumidorDAO;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
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

    @GetMapping("/consumidor/comprobar-login")
    public Consumidor checkLogin(@RequestParam String user, @RequestParam String password){
        return consumidorDAO.checkLogin(user, password);
    }

    @PostMapping("/consumidor/save")
    public Consumidor save(@RequestBody Consumidor consumidor){
        return consumidorDAO.save(consumidor);
    }

    @DeleteMapping("/consumidor/delete")
    public void delete(@RequestParam int id){
        consumidorDAO.deleteById(id);
    }

    @PutMapping("/consumidor/update")
    public Consumidor update(@RequestParam int id,@RequestBody Consumidor consumidor){
        Consumidor updateOfertante = consumidorDAO.getById(id);

        updateOfertante.setEmail(consumidor.getEmail());
        updateOfertante.setUsername(consumidor.getUsername());
        updateOfertante.setPassword(consumidor.getPassword());

        return consumidorDAO.save(updateOfertante);
    }

}
