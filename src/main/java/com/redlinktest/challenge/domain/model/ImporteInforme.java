package com.redlinktest.challenge.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class ImporteInforme {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private LocalDateTime fechaDeRegistro;

    public ImporteInforme() {}

    public ImporteInforme(String dni) {
        this.dni = dni;
        this.fechaDeRegistro = LocalDateTime.now(); // se podría agregar una función para buscar por fecha
    }

    // Getters - Setters, en este caso solo getters

    public Long getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public LocalDateTime getFechaDeRegistro() {
        return fechaDeRegistro;
    }
}