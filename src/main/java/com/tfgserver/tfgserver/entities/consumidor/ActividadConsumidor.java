package com.tfgserver.tfgserver.entities.consumidor;


import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "actividadesconsumidores")
public class ActividadConsumidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idActividadesConsumidores")
    private int idActividadConsumidor;

    @Basic
    @Column
    private String descripcion;

    @Basic
    @Column
    private Timestamp dueDate;

    @Basic
    @Column
    private int numeroPlazas;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
    @JoinColumn(name="idConsumidor")
    private Consumidor consumidor;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
    @JoinColumn(name="idOfertante")
    private Ofertante ofertante;

}
