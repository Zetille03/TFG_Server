package com.tfgserver.tfgserver.entities;

import com.tfgserver.tfgserver.entities.consumidor.Consumidor;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "consumidoractividadofertante")
public class ConsumidorActividadOfertante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idConsumidorActividadOfertante")
    private int idConsumidorActividadOfertante;

    @ManyToOne
    @JoinColumn(name = "idActividadOfertante")
    private ActividadOfertante actividadOfertante;

    @ManyToOne
    @JoinColumn(name = "idConsumidor")
    private Consumidor consumidor;
}
