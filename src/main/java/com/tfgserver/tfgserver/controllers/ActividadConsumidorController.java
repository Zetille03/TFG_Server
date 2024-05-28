package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.*;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.OfertanteActividadFavorita;
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
    private OfertanteDAO ofertanteDAO;

    @Autowired
    private OfertanteActividadFavoritaDAO ofertanteActividadFavoritaDAO;
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




    @GetMapping("/actividad-consumidor/get-apuntado")
    public List<ActividadConsumidor> getActividadesConsumidoresByOfertante(@RequestParam("ofertanteId") int ofertanteId){
        List<ActividadConsumidor> actividades = new ArrayList<>();
        for(ActividadConsumidor actividad : actividadConsumidorDAO.getAllActividadesConsumidores()){
            if (actividad.getOfertanteActividadConsumidor() != null && actividad.getOfertanteActividadConsumidor().getIdOfertante() == ofertanteId) {
                actividades.add(actividad);
            }
        }
        return actividades;
    }

    @GetMapping("/actividad-consumidor/get-favoritas")
    public List<ActividadConsumidor> getActividadesFavoritasByOfertante(@RequestParam("ofertanteId") int ofertanteId){
        List<OfertanteActividadFavorita> listaRelaciones = ofertanteActividadFavoritaDAO.getAllOfertanteActividadesFavoritas();
        List<ActividadConsumidor> actividades = new ArrayList<>();
        for(OfertanteActividadFavorita act: listaRelaciones){
            if(act.getOfertante().getIdOfertante()==ofertanteId){
                actividades.add(actividadConsumidorDAO.getById(act.getActividadConsumidor().getIdActividadConsumidor()));
            }
        }
        return actividades;
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

        return  actividadConsumidorDAO.save(updateActividadConsumidor);
    }

    @PutMapping("/actividad-consumidor/update-ofertante")
    public ActividadConsumidor updateOfertante(@RequestParam int idActividad, @RequestParam int idOfertante){
        ActividadConsumidor updateActividadConsumidor = actividadConsumidorDAO.getById(idActividad);
        Ofertante ofertante = ofertanteDAO.getById(idOfertante);

        updateActividadConsumidor.setOfertanteActividadConsumidor(ofertante);

        return actividadConsumidorDAO.save(updateActividadConsumidor);
    }

    @PutMapping("/actividad-consumidor/delete-ofertante")
    public ActividadConsumidor deleteOfertante(@RequestParam int idActividad){
        ActividadConsumidor updateActividadConsumidor = actividadConsumidorDAO.getById(idActividad);

        updateActividadConsumidor.setOfertanteActividadConsumidor(null);

        return actividadConsumidorDAO.save(updateActividadConsumidor);
    }

}
