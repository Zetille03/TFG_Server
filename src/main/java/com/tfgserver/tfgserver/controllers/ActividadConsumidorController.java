package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ActividadConsumidorDao;
import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActividadConsumidorController {
    @Autowired
    private ActividadConsumidorDao actividadConsumidorDAO;

    @GetMapping("/actividad-consumidor/get-all")
    public List<ActividadConsumidor> getAllActividadesConsumidor(){
        return actividadConsumidorDAO.getAllActividadesConsumidores();
    }

    @PostMapping("actividad-consumidor/save")
    public ActividadConsumidor save(@RequestBody ActividadConsumidor actividadConsumidor){
        return actividadConsumidorDAO.save(actividadConsumidor);
    }

    @DeleteMapping("actividad-consumidor/delete")
    public void deleteById(@RequestParam int id){
        actividadConsumidorDAO.deleteById(id);
    }



//    @PutMapping("/actividad-consumidor/update")
//    public ActividadConsumidor update(@RequestBody ActividadConsumidor actividadConsumidor){
//        return  actividadConsumidorDAO.save(actividadConsumidor);
//    }

}
