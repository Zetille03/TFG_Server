package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ActividadConsumidorDao;
import com.tfgserver.tfgserver.dao.ActividadOfertanteDAO;
import com.tfgserver.tfgserver.dao.ConsumidorActividadOfertanteDAO;
import com.tfgserver.tfgserver.dao.ConsumidorDAO;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActividadConsumidorController {
    @Autowired
    private ActividadConsumidorDao actividadConsumidorDAO;

    @Autowired
    private ConsumidorDAO consumidorDAO;

    @Autowired
    private ConsumidorActividadOfertanteDAO consumidorActividadOfertanteDAO;
    @Autowired
    private ActividadOfertanteDAO actividadOfertanteDAO;

    @GetMapping("/actividad-consumidor/get-all")
    public List<ActividadConsumidor> getAllActividadesConsumidor(){
        return actividadConsumidorDAO.getAllActividadesConsumidores();
    }

    @GetMapping("/actividad-consumidor/get-by-consumidor")
    public List<ActividadConsumidor> getActividadesOfertantesByOfertante(@RequestParam("consumidorId") int consumidorId){
        List<ActividadConsumidor> actividades = new ArrayList<>();
        Consumidor consumidor = consumidorDAO.getById(consumidorId);
        for(ActividadConsumidor a : actividadConsumidorDAO.getAllActividadesConsumidores()){
            if(a.getConsumidor().equals(consumidor))actividades.add(a);
        }
        return actividades;
    }



    @GetMapping("/actividad-ofertante/get-apuntado")
    public List<ActividadOfertante> getActividadesOfertantesByConsumidor(@RequestParam("consumidorId") int idConsumidor){
        List<ConsumidorActividadOfertante> actividadesRelaciones = consumidorActividadOfertanteDAO.getAllConsumidoresActividadesOfertantes();
        List<ActividadOfertante> actividadesOfertantes = new ArrayList<>();
        for(ConsumidorActividadOfertante a : actividadesRelaciones){
            if(a.getConsumidor().getIdConsumidor()==idConsumidor)
                actividadesOfertantes.add(actividadOfertanteDAO.getById(a.getActividadOfertante().getIdActividadOfertante()));
        }
        return actividadesOfertantes;
    }


    @PostMapping("/actividad-consumidor/save")
    public ActividadConsumidor save(@RequestBody ActividadConsumidor actividadConsumidor){
        return actividadConsumidorDAO.save(actividadConsumidor);
    }

    @DeleteMapping("/actividad-consumidor/delete")
    public void deleteById(@RequestParam int id){
        actividadConsumidorDAO.deleteById(id);
    }



    @PutMapping("/actividad-consumidor/update")
    public ActividadConsumidor update(@RequestParam int id,@RequestBody ActividadConsumidor actividadConsumidor){
        ActividadConsumidor updateActividadConsumidor = actividadConsumidorDAO.getById(id);

        updateActividadConsumidor.setTitulo(actividadConsumidor.getTitulo());
        updateActividadConsumidor.setDescripcion(actividadConsumidor.getDescripcion());
        updateActividadConsumidor.setCategoria(actividadConsumidor.getCategoria());
        updateActividadConsumidor.setDueDate(actividadConsumidor.getDueDate());
        updateActividadConsumidor.setNumeroPlazas(actividadConsumidor.getNumeroPlazas());
        updateActividadConsumidor.setConsumidor(actividadConsumidor.getConsumidor());

        return  actividadConsumidorDAO.save(updateActividadConsumidor);
    }

}
