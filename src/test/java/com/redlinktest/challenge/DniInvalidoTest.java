package com.redlinktest.challenge;

import com.redlinktest.challenge.domain.model.Empleado;
import com.redlinktest.challenge.controller.utils.Reporte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

// extiendo TestIntegration para cada caso específico

public class DniInvalidoTest extends TestIntegration {
    private static final String DNI_INVALIDO = "00000000";
    private static final String DNI_VALIDO = "12345678";

    @BeforeEach
    void setUp() {
        empleadosRepo.deleteAll();
        informeRepo.deleteAll();
        empleadosRepo.save(new Empleado(DNI_VALIDO, new BigDecimal("592749.99"))); // esta medio de adorno
    }

    @Test
    void testDniInvalido() {
        Reporte result = importeUseCase.disponibilidadDeImporte(DNI_INVALIDO);

        // el dni es inválido
        assertFalse((Boolean) result.getValidez());
        // el importe es nulo
        assertNull(result.getImporte());
        // chequeo el mensaje correspondiente
        assertEquals("DNI Inválido", result.getMensaje());
        // el informe no se ve afectado por este caso
        assertEquals(0, informeRepo.count());
    }
}
