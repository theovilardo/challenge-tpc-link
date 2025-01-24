package com.redlinktest.challenge;

import com.redlinktest.challenge.domain.model.Empleado;
import com.redlinktest.challenge.controller.utils.Reporte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
		Reporte result = importeUseCase.disponibilidadDeImporte(DNI_VALIDO);

		// el dni es válido
		assertTrue((Boolean) result.getValidez());
		// coinciden los importes
		assertEquals(new BigDecimal("500000.00"), result.getImporte());
		// chequeo el mensaje correspondiente
		assertEquals("Préstamo disponible", result.getMensaje());
		// chequeo que se agregue al informe
		assertEquals(1, informeRepo.count());
	}
}
