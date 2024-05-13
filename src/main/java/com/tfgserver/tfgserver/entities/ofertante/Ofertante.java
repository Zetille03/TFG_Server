package com.tfgserver.tfgserver.entities.ofertante;


import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@Table(name = "ofertantes")
public class Ofertante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOfertante")
    private int idOfertante;

    @Basic
    @Column(unique = true,nullable = false)
    private String username;

    @Basic
    @Column(unique = true,nullable = false)
    private String email;

    @Basic
    @Column
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,
            mappedBy = "ofertante",fetch = FetchType.EAGER)
    private List<ActividadOfertante> listaActividadesOfertante;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,
            mappedBy = "ofertanteActividadConsumidor",fetch = FetchType.EAGER)
    private List<ActividadConsumidor> listaActividadesConsumidor;

}
