package com.tfgserver.tfgserver.entities.ofertante;

import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "actividadesofertantes")
public class ActividadOfertante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idActividadesOfertantes")
    private int idActividadOfertante;

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
    @JoinColumn(name="idOfertante")
    private Consumidor ofertante;


}