package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ActividadOfertanteDAO;
import com.tfgserver.tfgserver.dao.ConsumidorActividadFavoritaDAO;
import com.tfgserver.tfgserver.dao.ConsumidorDAO;
import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="Consumidor Actividad Favorita")
public class ConsumidorActividadFavoritaController {
    @Autowired
    private ConsumidorActividadFavoritaDAO consumidorActividadFavoritaDAO;
    @Autowired
    private ConsumidorDAO consumidorDAO;
    @Autowired
    private ActividadOfertanteDAO actividadOfertanteDAO;

    @GetMapping("/consumidor-actividad-favorita/get-all")
    public List<ConsumidorActividadFavorita> getAllConsumidorActividadesFavoritas(){
        return consumidorActividadFavoritaDAO.getAllConsumidorActividadesFavoritas();
    }

    @PutMapping("/consumidor-actividad-favorita/update")
    public ConsumidorActividadFavorita update(@RequestParam int id, @RequestBody ConsumidorActividadFavorita entity){
        ConsumidorActividadFavorita c = consumidorActividadFavoritaDAO.getById(id);
        c.setConsumidor(entity.getConsumidor());
        c.setActividadOfertante(entity.getActividadOfertante());

        return consumidorActividadFavoritaDAO.save(c);
    }

    @PostMapping("/consumidor-actividad-favorita/save")
    public ConsumidorActividadFavorita save(@RequestParam int idActividad,@RequestParam int idConsumidor){
        ConsumidorActividadFavorita entity = new ConsumidorActividadFavorita();
        Consumidor consumidor = new Consumidor();
        consumidor.setIdConsumidor(idConsumidor);
        ActividadOfertante actividad = new ActividadOfertante();
        actividad.setIdActividadOfertante(idActividad);
        entity.setConsumidor(consumidor);
        entity.setActividadOfertante(actividad);
        return consumidorActividadFavoritaDAO.save(entity);
    }

    @DeleteMapping("/consumidor-actividad-favorita/delete")
    public void deleteById(@RequestParam int id){
        consumidorActividadFavoritaDAO.deleteById(id);
    }

    @DeleteMapping("/consumidor-actividad-favorita/delete-by-ids")
    public void deleteByIds(@RequestParam int idActividad,@RequestParam int idConsumidor){
        List<ConsumidorActividadFavorita> lista = consumidorActividadFavoritaDAO.getAllConsumidorActividadesFavoritas();
        for(ConsumidorActividadFavorita entity : lista){
            if(entity.getConsumidor().getIdConsumidor()==idConsumidor && entity.getActividadOfertante().getIdActividadOfertante()==idActividad){
                deleteById(entity.getIdConsumidorActividadFavorita());
            }
        }
    }


}
