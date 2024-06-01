package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.*;
import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="Consumidor Actividad Ofertante")
public class ConsumidorActividadOfertanteController {

    @Autowired
    private ConsumidorActividadOfertanteDAO consumidorActividadOfertanteDAO;
    @Autowired
    private ActividadOfertanteDAO actividadOfertanteDAO;
    @Autowired
    private ConsumidorDAO consumidorDAO;
    @Autowired
    private OfertanteDAO ofertanteDAO;
    @Autowired
    private ActividadConsumidorDao actividadConsumidorDao;


    @GetMapping("/consumidor-actividad-ofertante/get-all")
    public List<ConsumidorActividadOfertante> getAllConsumidoresActividadesOfertantes(){
        return consumidorActividadOfertanteDAO.getAllConsumidoresActividadesOfertantes();
    }

    @PostMapping("/consumidor-actividad-ofertante/save")
    public ConsumidorActividadOfertante save(@RequestParam int idActividad, @RequestParam int idConsumidor){
        ConsumidorActividadOfertante consumidorActividadOfertante = new ConsumidorActividadOfertante();
        Consumidor consumidor = new Consumidor();
        consumidor.setIdConsumidor(idConsumidor);
        ActividadOfertante actividadOfertante = new ActividadOfertante();
        actividadOfertante.setIdActividadOfertante(idActividad);
        consumidorActividadOfertante.setConsumidor(consumidor);
        consumidorActividadOfertante.setActividadOfertante(actividadOfertante);
        ActividadOfertante actComprobarSize = actividadOfertanteDAO.getById(idActividad);
        if(actComprobarSize==null || actComprobarSize.getListaConsumidoresActividadOfertantes().size() >= actComprobarSize.getNumeroPlazas()){
            return null;
        }else{
            ConsumidorActividadOfertante c = consumidorActividadOfertanteDAO.save(consumidorActividadOfertante);
            if(c != null){
                c.setActividadOfertante(actividadOfertanteDAO.getById(c.getActividadOfertante().getIdActividadOfertante()));
                c.setConsumidor(consumidorDAO.getById(c.getConsumidor().getIdConsumidor()));
                Ofertante o = ofertanteDAO.getById(c.getActividadOfertante().getOfertante().getIdOfertante());
                c.getActividadOfertante().setOfertante(o);
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/consumidor-actividad-ofertante/delete")
    public void deleteById(@RequestParam int id){
        consumidorActividadOfertanteDAO.deleteById(id);
    }



    @DeleteMapping("/consumidor-actividad-ofertante/delete-by-ids")
    public ConsumidorActividadOfertante deleteByIds(@RequestParam int idActividad, @RequestParam int idConsumidor){
        List<ConsumidorActividadOfertante> lista = getAllConsumidoresActividadesOfertantes();
        ConsumidorActividadOfertante actividadDevolver = null;
        for(ConsumidorActividadOfertante c : lista){
            if(c.getConsumidor().getIdConsumidor()==idConsumidor && c.getActividadOfertante().getIdActividadOfertante()==idActividad){
                actividadDevolver = c;
                deleteById(c.getIdConsumidorActividadOfertante());
            }
        }
        return actividadDevolver;
    }
    @Async
    @PutMapping("/consumidor-actividad-ofertante/update")
    public ConsumidorActividadOfertante update(@RequestParam int id,@RequestBody ConsumidorActividadOfertante consumidorActividadOfertante){
        ConsumidorActividadOfertante updateConsumidorActividadOfertante = consumidorActividadOfertanteDAO.getById(id);

        updateConsumidorActividadOfertante.setConsumidor(consumidorActividadOfertante.getConsumidor());
        updateConsumidorActividadOfertante.setActividadOfertante(consumidorActividadOfertante.getActividadOfertante());

        return consumidorActividadOfertanteDAO.save(updateConsumidorActividadOfertante);
    }

}
