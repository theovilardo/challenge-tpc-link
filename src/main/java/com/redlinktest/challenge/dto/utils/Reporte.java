package com.redlinktest.challenge.dto.utils;

import java.math.BigDecimal;

public class Reporte {
    private final boolean validez;
    private final BigDecimal importe;
    private final String mensaje;

    public Reporte(boolean validez, BigDecimal importe, String mensaje) {
        this.validez = validez;
        this.importe = importe;
        this.mensaje = mensaje;
    }

    // Getters - Setters

    public boolean getValidez() {
        return validez;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public String getMensaje() {
        return mensaje;
    }
}
