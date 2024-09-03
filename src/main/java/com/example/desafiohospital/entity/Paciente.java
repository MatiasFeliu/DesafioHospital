package com.example.desafiohospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pacientes")


public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 80)
    private String name;

    @Column(name="apellido", nullable = false, length = 80)
    private String surname;

    @Column(name="numero_sala", nullable = false)
    private int numRoom;

    @Column(name = "numero_cama", nullable = false)
    private int numBed;

}
