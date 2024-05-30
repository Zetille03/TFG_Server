package com.tfgserver.tfgserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "consumidoractividadofertante")
public class ConsumidorActividadOfertante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idConsumidorActividadOfertante")
    private int idConsumidorActividadOfertante;

    @ManyToOne
    @JoinColumn(name = "idActividadOfertante")
    @JsonIgnoreProperties({"listaConsumidoresActividadOfertantes"})
    private ActividadOfertante actividadOfertante;

    @ManyToOne
    @JoinColumn(name = "idConsumidor")
    @JsonIgnoreProperties("listaConsumidoresActividadOfertantes")
    private Consumidor consumidor;
}
