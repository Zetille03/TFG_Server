package com.tfgserver.tfgserver.entities.ofertante;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tfgserver.tfgserver.entities.OfertanteActividadFavorita;
import com.tfgserver.tfgserver.entities.consumidor.ActividadConsumidor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@Table(name = "ofertantes")
public class Ofertante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOfertante")
    private int idOfertante;

    @Basic
    @Column(unique = true,nullable = false)
    @NotEmpty
    private String username;

    @Basic
    @Column(unique = true,nullable = false)
    @NotEmpty
    private String email;

    @Basic
    @Column
    @NotEmpty
    private String password;

    @OneToMany(/*cascade = {CascadeType.MERGE} ,*/
            mappedBy = "ofertante",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("ofertante")
    private List<ActividadOfertante> listaActividadesOfertante;

    @OneToMany(/*cascade = {CascadeType.MERGE} ,*/
            mappedBy = "ofertanteActividadConsumidor",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("ofertanteActividadConsumidor")
    private List<ActividadConsumidor> listaActividadesConsumidor;

    @OneToMany(/*cascade = {CascadeType.MERGE} ,*/
            mappedBy = "ofertante", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("ofertante")
    private List<OfertanteActividadFavorita> listaOfertanteActividadesFavoritas;

}
