package com.tfgserver.tfgserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="consumidoractividadfavorita")
public class ConsumidorActividadFavorita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsumidorActividadFavorita")
    private int idConsumidorActividadFavorita;

    @ManyToOne
    @JoinColumn(name = "idActividadOfertante")
    @JsonIgnoreProperties("listaConsumidorActivadesFavoritas")
    private ActividadOfertante actividadOfertante;

    @ManyToOne
    @JoinColumn(name = "idConsumidor")
    @JsonIgnoreProperties("listaConsumidorActivadesFavoritas")
    private Consumidor consumidor;
}
