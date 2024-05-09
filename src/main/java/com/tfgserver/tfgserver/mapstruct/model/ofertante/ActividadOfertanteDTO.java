package com.tfgserver.tfgserver.mapstruct.model.ofertante;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ActividadOfertanteDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("fechaFin")
    private Date fechaFin;

    @JsonProperty("categoria")
    private String categoria;

    @JsonProperty("numeroPlazas")
    private int numeroPlazas;


    @JsonProperty("idOfertante")
    private int idOfertante;
}
