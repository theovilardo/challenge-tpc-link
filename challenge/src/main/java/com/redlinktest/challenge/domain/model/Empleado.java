package com.redlinktest.challenge.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Empleado {
    @Id
    private String dni;
    private BigDecimal importe;

    public Empleado() {}

    public Empleado(String dni, BigDecimal importe) {
        this.dni = dni;
        this.importe = importe;
    }

    // Getters - Setters, en este caso solo getters

    public String getDni() {
        return dni;
    }

    public BigDecimal getImporte() {
        return importe;
    }
}
