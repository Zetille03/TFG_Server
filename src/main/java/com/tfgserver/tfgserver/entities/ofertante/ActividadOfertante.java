package com.tfgserver.tfgserver.entities.ofertante;

import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
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
    private String categoria;

    @Basic
    @Column
    private int numeroPlazas;


    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
    @JoinColumn(name="idOfertante")
    private Ofertante ofertante;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,
            mappedBy = "actividadOfertante",fetch = FetchType.EAGER)
    private List<ConsumidorActividadOfertante> listaConsumidoresActividadOfertantes;
}