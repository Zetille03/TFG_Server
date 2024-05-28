package com.tfgserver.tfgserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import com.tfgserver.tfgserver.entities.ofertante.Ofertante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="ofertanteactividadfavorita")
public class OfertanteActividadFavorita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOfertanteActividadFavorita")
    private int idOfertanteActividadFavorita;

    @ManyToOne
    @JoinColumn(name = "idActividadConsumidor")
    @JsonIgnoreProperties({"listaOfertanteActividadesFavoritas","consumidor","ofertanteActividadConsumidor"})
    private ActividadConsumidor actividadConsumidor;

    @ManyToOne
    @JoinColumn(name = "idOfertante")
    @JsonIgnoreProperties({"listaOfertanteActividadesFavoritas","listaActividadesOfertante","listaActividadesConsumidor"})
    private Ofertante ofertante;
}
