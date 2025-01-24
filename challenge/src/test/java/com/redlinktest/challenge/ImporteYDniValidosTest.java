package com.redlinktest.challenge;

import com.redlinktest.challenge.domain.model.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class ImporteYDniValidosTest extends TestIntegration {
	private static final String DNI_VALIDO = "12345678";

	@BeforeEach
	void setUp() {
		empleadosRepo.deleteAll();
		informeRepo.deleteAll();
		empleadosRepo.save(new Empleado(DNI_VALIDO, new BigDecimal("500000.00")));
	}

	@Test
	void testImporteYDniValidos() {
		Map<String, Object> result = importeUseCase.disponibilidadDeImporte(DNI_VALIDO);

		// el dni es válido
		assertTrue((Boolean) result.get("validez"));
		// coinciden los importes
		assertEquals(new BigDecimal("500000.00"), result.get("importe"));
		// chequeo el mensaje correspondiente
		assertEquals("Préstamo disponible", result.get("mensaje"));
		// chequeo que se agregue al informe
		assertEquals(1, informeRepo.count());
	}
}
