package com.redlinktest.challenge;

import com.redlinktest.challenge.domain.model.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class DniValidoSinImporteTest extends TestIntegration {
    private static final String DNI_VALIDO_SIN_IMPORTE = "87654321";

    @BeforeEach
    void setUp() {
        empleadosRepo.deleteAll();
        informeRepo.deleteAll();
        empleadosRepo.save(new Empleado(DNI_VALIDO_SIN_IMPORTE, BigDecimal.ZERO));
    }

    @Test
    void testDniValidoSinImporte() {
        Map<String, Object> result = importeUseCase.disponibilidadDeImporte(DNI_VALIDO_SIN_IMPORTE);

        // el dni es válido
        assertTrue((Boolean) result.get("validez"));
        // no tiene importe asociado
        assertNull(result.get("importe"));
        // chequeo el mensaje correspondiente
        assertEquals("Préstamo no disponible", result.get("mensaje"));
        // chequeo que no se agregue al informe, ya que tiene un dni válido pero no un préstamo disponible
        assertEquals(0, informeRepo.count());
    }
}
