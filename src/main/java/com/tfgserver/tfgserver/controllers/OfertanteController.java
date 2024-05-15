package com.tfgserver.tfgserver.controllers;

import com.tfgserver.tfgserver.dao.OfertanteDAO;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfertanteController {
    @Autowired
    private OfertanteDAO ofertanteDAO;

    @GetMapping("/ofertante/get-all")
    public List<Ofertante> getAll() {
        return ofertanteDAO.getAllOfertantes();
    }

    @PostMapping("ofertante/save")
    public Ofertante save(@RequestBody Ofertante ofertante) {
        return ofertanteDAO.save(ofertante);
    }

    @GetMapping("/ofertante/comprobar-login")
    public Ofertante checkLogin(@RequestParam String user, @RequestParam String password){
        return ofertanteDAO.checkLogin(user, password);
    }

    @DeleteMapping("/ofertante/delete")
    public void delete(@RequestParam int id){
        ofertanteDAO.deleteById(id);
    }

    @PutMapping("/ofertante/update")
    public Ofertante update(@RequestParam int id,@RequestBody Ofertante ofertante){
        Ofertante updateOfertante = ofertanteDAO.getById(id);

        updateOfertante.setEmail(ofertante.getEmail());
        updateOfertante.setUsername(ofertante.getUsername());
        updateOfertante.setPassword(ofertante.getPassword());
        updateOfertante.setListaActividadesOfertante(ofertante.getListaActividadesOfertante());
        updateOfertante.setListaActividadesConsumidor(ofertante.getListaActividadesConsumidor());


        return ofertanteDAO.save(updateOfertante);
    }

}
