package com.tfgserver.tfgserver.mapstruct.model.consumidor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ActividadConsumidorDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("fechaFin")
    private Date fechaFin;

    @JsonProperty("numeroPlazas")
    private int numeroPlazas;

    @JsonProperty("idConsumidor")
    private int idConsumidor;

    @JsonProperty("idOfertante")
    private int idOfertante;
}
