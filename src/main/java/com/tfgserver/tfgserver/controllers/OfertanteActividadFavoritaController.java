package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.OfertanteActividadFavoritaDAO;
import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import com.tfgserver.tfgserver.entities.OfertanteActividadFavorita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public OfertanteActividadFavorita save(@RequestBody OfertanteActividadFavorita entity){
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