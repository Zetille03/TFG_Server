package com.tfgserver.tfgserver.mapstruct.mappers;

import com.tfgserver.tfgserver.entities.consumidor.*;
import com.tfgserver.tfgserver.entities.ofertante.*;
import com.tfgserver.tfgserver.mapstruct.model.ofertante.*;
import com.tfgserver.tfgserver.mapstruct.model.consumidor.*;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    OfertanteDTO ofertanteToOfertanteDTO(Ofertante ofertante);

    ConsumidorDTO consumidorToConsumidorDTO(Consumidor consumidor);

    Ofertante ofertanteDTOToOfertante(OfertanteDTO ofertanteDTO);

    Consumidor consumidorDTOToConsumidor(ConsumidorDTO consumidorDTO);

    ActividadConsumidorDTO actividadConsumidorToActividadConsumidorDTO(ActividadConsumidor actividadConsumidor);

    ActividadOfertanteDTO actividadOfertanteToActividadOfertanteDTO(ActividadOfertante actividadOfertante);

    ActividadConsumidor actividadConsumidorDTOToActividadConsumidor(ActividadConsumidorDTO actividadConsumidorDTO);

    ActividadOfertante actividadOfertanteDTOToActividadOfertante(ActividadOfertanteDTO actividadOfertanteDTO);


}
