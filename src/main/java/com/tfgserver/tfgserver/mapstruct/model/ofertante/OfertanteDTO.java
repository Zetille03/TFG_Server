package com.tfgserver.tfgserver.mapstruct.model.ofertante;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OfertanteDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("correo")
    private String email;

    @JsonProperty("contraseña")
    private String contraseña;

    @JsonProperty("listaActividadesOfertante")
    private List<ActividadOfertanteDTO> listaActividadesOfertante;




}