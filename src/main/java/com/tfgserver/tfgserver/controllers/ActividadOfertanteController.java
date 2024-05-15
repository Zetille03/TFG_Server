package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.ActividadOfertanteDAO;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActividadOfertanteController {
    @Autowired
    private ActividadOfertanteDAO actividadOfertanteDAO;

    @GetMapping("/actividad-ofertante/get-all")
    public List<ActividadOfertante> getAllActividadesOfertanes(){
        return actividadOfertanteDAO.getAllActividadesOfertantes();
    }

    @PostMapping("/actividad-ofertante/save")
    public ActividadOfertante save(@RequestBody ActividadOfertante actividadOfertante){
        return actividadOfertanteDAO.save(actividadOfertante);
    }

    @DeleteMapping("/actividad-ofertante/delete")
    public void deleteById(@RequestParam int id){
        actividadOfertanteDAO.deleteById(id);
    }

//    @PutMapping("/actividad-ofertante/update")
//    public ActividadOfertante update(@RequestBody ActividadOfertante actividadOfertante){
//        return actividadOfertanteDAO.save(actividadOfertante);
//    }
}
