package com.tfgserver.tfgserver.mapstruct.model.consumidor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConsumidorDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("correo")
    private String email;

    @JsonProperty("contraseña")
    private String contraseña;

    @JsonProperty("listaActividadesConsumidor")
    private List<ActividadConsumidorDTO> listaActividadesConsumidor;


}
