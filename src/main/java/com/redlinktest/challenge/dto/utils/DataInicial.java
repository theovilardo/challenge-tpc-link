package com.redlinktest.challenge.dto.utils;

import com.redlinktest.challenge.domain.model.Empleado;
import com.redlinktest.challenge.domain.repository.EmpleadosRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataInicial {
    @Bean
    CommandLineRunner initDatabase(EmpleadosRepo empleadosRepo) {
        return args -> {
            empleadosRepo.saveAll(List.of(
                    new Empleado("42356578", new BigDecimal("15000.50")),   // Caso DNI válido con importe
                    new Empleado("32446698", new BigDecimal("150000.50")),  // Extra para le informe
                    new Empleado("22354321", BigDecimal.ZERO),                  // Caso DNI válido sin importe
                    new Empleado("55098342", null)                      // Caso DNI válido, pero sin datos de importe
                    // el invalido se testea manualmente
            ));
        };
    }
}