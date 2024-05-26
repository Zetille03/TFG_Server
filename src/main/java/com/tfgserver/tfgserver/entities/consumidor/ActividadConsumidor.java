package com.tfgserver.tfgserver.entities.consumidor;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Data
@Table(name = "actividadesconsumidores")
public class ActividadConsumidor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idActividadesConsumidores")
    private int idActividadConsumidor;

    @Basic
    @Column
    private String titulo;

    @Basic
    @Column
    private String descripcion;

    @Basic
    @Column
    private Date dueDate;

    @Basic
    @Column
    private String categoria;


    @ManyToOne(cascade = {/*CascadeType.PERSIST,*/CascadeType.MERGE} )
    @JsonIgnoreProperties("listaActividadesDeConsumidor")
    @JoinColumn(name="idConsumidor")
    private Consumidor consumidor;

    @ManyToOne(cascade = {/*CascadeType.PERSIST,*/CascadeType.MERGE} )
    @JoinColumn(name="idOfertante")
    @JsonIgnoreProperties("listaActividadesConsumidor")
    private Ofertante ofertanteActividadConsumidor;





}
