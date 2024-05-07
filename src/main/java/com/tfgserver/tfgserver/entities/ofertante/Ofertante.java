package com.tfgserver.tfgserver.entities.ofertante;


import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ofertantes")
public class Ofertante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idConsumidor;

    @Basic
    @Column
    private String username;

    @Basic
    @Column
    private String email;

    @Basic
    @Column
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,
            mappedBy = "ofertantes")
    private List<ActividadConsumidor> listaActividadesOfertante;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,
            mappedBy = "ofertantes")
    private List<ActividadConsumidor> listaActividadesConsumidor;

}
