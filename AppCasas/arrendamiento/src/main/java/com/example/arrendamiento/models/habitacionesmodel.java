package com.example.arrendamiento.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Habitaciones")
public class habitacionesmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Num_Habitacion")
    private String numHabitacion;

    @Column(name="Disponibilidad")
    private String disponibilidad;

    


    
}
