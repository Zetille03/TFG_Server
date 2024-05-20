package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ConsumidorActividadOfertanteDAO;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsumidorActividadOfertanteController {

    @Autowired
    private ConsumidorActividadOfertanteDAO consumidorActividadOfertanteDAO;

    @GetMapping("/consumidor-actividad-ofertante/get-all")
    public List<ConsumidorActividadOfertante> getAllConsumidoresActividadesOfertantes(){
        return consumidorActividadOfertanteDAO.getAllConsumidoresActividadesOfertantes();
    }

    @PostMapping("/consumidor-actividad-ofertante/save")
    public ConsumidorActividadOfertante save(@RequestBody ConsumidorActividadOfertante consumidorActividadOfertante){
        return consumidorActividadOfertanteDAO.save(consumidorActividadOfertante);
    }

    @DeleteMapping("/consumidor-actividad-ofertante/delete")
    public void deleteById(@RequestParam int id){
        consumidorActividadOfertanteDAO.deleteById(id);
    }

    @PutMapping("/consumidor-actividad-ofertante/update")
    public ConsumidorActividadOfertante update(@RequestParam int id,@RequestBody ConsumidorActividadOfertante consumidorActividadOfertante){
        ConsumidorActividadOfertante updateConsumidorActividadOfertante = consumidorActividadOfertanteDAO.getById(id);

        updateConsumidorActividadOfertante.setConsumidor(consumidorActividadOfertante.getConsumidor());
        updateConsumidorActividadOfertante.setActividadOfertante(consumidorActividadOfertante.getActividadOfertante());

        return consumidorActividadOfertanteDAO.save(updateConsumidorActividadOfertante);
    }

}
