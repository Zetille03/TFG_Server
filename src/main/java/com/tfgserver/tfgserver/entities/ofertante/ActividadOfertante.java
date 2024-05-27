package com.tfgserver.tfgserver.entities.ofertante;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tfgserver.tfgserver.entities.ConsumidorActividadFavorita;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@Table(name = "actividadesofertantes")
public class ActividadOfertante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idActividadOfertante")
    private int idActividadOfertante;

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

    @Basic
    @Column
    private int numeroPlazas;


    @ManyToOne(cascade = {/*CascadeType.PERSIST,*/CascadeType.MERGE} )
    @JoinColumn(name="idOfertante")
    @JsonIgnoreProperties("listaActividadesOfertante")
    private Ofertante ofertante;

    @OneToMany(cascade = {/*CascadeType.PERSIST,*/ CascadeType.MERGE} ,
            mappedBy = "actividadOfertante",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("actividadOfertante")
    private List<ConsumidorActividadOfertante> listaConsumidoresActividadOfertantes;

    @OneToMany(cascade = {CascadeType.MERGE} ,
            mappedBy = "actividadOfertante", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("consumidor")
    private List<ConsumidorActividadFavorita> listaConsumidorActivadesFavoritas;
}