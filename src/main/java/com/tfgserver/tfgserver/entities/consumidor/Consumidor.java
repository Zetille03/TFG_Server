package com.tfgserver.tfgserver.entities.consumidor;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "consumidores")
public class Consumidor {
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
            mappedBy = "consumidores")
    private List<ActividadConsumidor> listaActividadesConsumidor;

}
