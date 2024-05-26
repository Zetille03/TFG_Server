package com.tfgserver.tfgserver.entities.consumidor;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tfgserver.tfgserver.entities.ConsumidorActividadOfertante;
import com.tfgserver.tfgserver.entities.ofertante.ActividadOfertante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@Table(name = "consumidores")
public class Consumidor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idConsumidor")
    private int idConsumidor;

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

    @OneToMany(cascade = {/*CascadeType.PERSIST,*/ CascadeType.MERGE} ,
            mappedBy = "consumidor", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("consumidor")
    private List<ActividadConsumidor> listaActividadesDeConsumidor;


    @OneToMany(cascade = {/*CascadeType.PERSIST,*/ CascadeType.MERGE} ,
            mappedBy = "consumidor", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("consumidor")
    private List<ConsumidorActividadOfertante> listaConsumidoresActividadOfertantes;

//    @Override
//    public String toString() {
//        return "Consumidor{" +
//                "idConsumidor=" + idConsumidor +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", listaActividadesDeConsumidor=" + ((listaActividadesDeConsumidor!=null)?listaActividadesDeConsumidor.size():0) +
//                ", listaConsumidoresActividadOfertantes=" +  ((listaConsumidoresActividadOfertantes!=null)?listaConsumidoresActividadOfertantes.size():0) +
//                '}';
//    }
}
