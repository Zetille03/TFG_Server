package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.*;
import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActividadOfertanteController {
    @Autowired
    private ActividadOfertanteDAO actividadOfertanteDAO;

    @Autowired
    private OfertanteDAO ofertanteDAO;

    @Autowired
    private ConsumidorActividadOfertanteDAO consumidorActividadOfertanteDAO;
    @Autowired
    private ConsumidorDAO consumidorDAO;

    @Autowired
    private ConsumidorActividadFavoritaDAO consumidorActividadFavoritaDAO;

    @GetMapping("/actividad-ofertante/get-all")
    public List<ActividadOfertante> getAllActividadesOfertanes(){
        return actividadOfertanteDAO.getAllActividadesOfertantes();
    }

    @GetMapping("/actividad-ofertante/get-by-ofertante")
    public List<ActividadOfertante> getActividadesOfertantesByOfertante(@RequestParam("ofertanteId") int ofertanteId){
        List<ActividadOfertante> actividades = new ArrayList<>();
        Ofertante ofertante = ofertanteDAO.getById(ofertanteId);
        for(ActividadOfertante a : actividadOfertanteDAO.getAllActividadesOfertantes()){
            if(a.getOfertante().equals(ofertante))actividades.add(a);
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

    @GetMapping("/actividad-ofertante/get-favoritas")
    public List<ActividadOfertante> getActividadesFavoritasByConsumidor(@RequestParam("consumidorId") int consumidorId){
        List<ActividadOfertante> actividades = new ArrayList<>();
        for(ConsumidorActividadFavorita act: consumidorActividadFavoritaDAO.getAllConsumidorActividadesFavoritas()){
            if(act.getConsumidor().getIdConsumidor()==consumidorId){
                actividades.add(actividadOfertanteDAO.getById(act.getActividadOfertante().getIdActividadOfertante()));
            }
        }
        return actividades;
    }


    @PostMapping("/actividad-ofertante/save")
    public ActividadOfertante save(@RequestBody ActividadOfertante actividadOfertante){
        return actividadOfertanteDAO.save(actividadOfertante);
    }

    @DeleteMapping("/actividad-ofertante/delete")
    public void deleteById(@RequestParam int id){
        actividadOfertanteDAO.deleteById(id);
    }

    @PutMapping("/actividad-ofertante/update")
    public ActividadOfertante update(@RequestParam int id,@RequestBody ActividadOfertante actividadOfertante){
        ActividadOfertante updateActividadOfertante = actividadOfertanteDAO.getById(id);

        updateActividadOfertante.setTitulo(actividadOfertante.getTitulo());
        updateActividadOfertante.setDescripcion(actividadOfertante.getDescripcion());
        updateActividadOfertante.setCategoria(actividadOfertante.getCategoria());
        updateActividadOfertante.setDueDate(actividadOfertante.getDueDate());
        updateActividadOfertante.setNumeroPlazas(actividadOfertante.getNumeroPlazas());
        updateActividadOfertante.setOfertante(actividadOfertante.getOfertante());

        return actividadOfertanteDAO.save(updateActividadOfertante);
    }
}
