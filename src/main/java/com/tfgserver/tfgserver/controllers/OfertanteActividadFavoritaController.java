package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.OfertanteActividadFavoritaDAO;
import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import com.tfgserver.tfgserver.entities.OfertanteActividadFavorita;
import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name ="Ofertante Actividad Favorita")
public class OfertanteActividadFavoritaController {
    @Autowired
    private OfertanteActividadFavoritaDAO ofertanteActividadFavoritaDAO;

    @GetMapping("/ofertante-actividad-favorita/get-all")
    public List<OfertanteActividadFavorita> getAllConsumidorActividadesFavoritas(){
        return ofertanteActividadFavoritaDAO.getAllOfertanteActividadesFavoritas();
    }

    @PutMapping("/ofertante-actividad-favorita/update")
    public OfertanteActividadFavorita update(@RequestParam int id, @RequestBody OfertanteActividadFavorita entity){
        OfertanteActividadFavorita o = ofertanteActividadFavoritaDAO.getById(id);
        o.setOfertante(entity.getOfertante());
        o.setActividadConsumidor(entity.getActividadConsumidor());

        return ofertanteActividadFavoritaDAO.save(o);
    }

    @PostMapping("/ofertante-actividad-favorita/save")
    public OfertanteActividadFavorita save(@RequestParam int idActividad, @RequestParam int idOfertante){
        OfertanteActividadFavorita entity = new OfertanteActividadFavorita();
        Ofertante ofertante = new Ofertante();
        ofertante.setIdOfertante(idOfertante);
        ActividadConsumidor actividad = new ActividadConsumidor();
        actividad.setIdActividadConsumidor(idActividad);
        entity.setOfertante(ofertante);
        entity.setActividadConsumidor(actividad);
        return ofertanteActividadFavoritaDAO.save(entity);
    }

    @DeleteMapping("/ofertante-actividad-favorita/delete")
    public void deleteById(@RequestParam int id){
        ofertanteActividadFavoritaDAO.deleteById(id);
    }

    @DeleteMapping("/ofertante-actividad-favorita/delete-by-ids")
    public void deleteByIds(@RequestParam int idActividad,@RequestParam int idOfertante){
        List<OfertanteActividadFavorita> lista = ofertanteActividadFavoritaDAO.getAllOfertanteActividadesFavoritas();
        for(OfertanteActividadFavorita entity : lista){
            if(entity.getOfertante().getIdOfertante()==idOfertante && entity.getActividadConsumidor().getIdActividadConsumidor()==idActividad){
                deleteById(entity.getIdOfertanteActividadFavorita());
            }
        }
    }
}
