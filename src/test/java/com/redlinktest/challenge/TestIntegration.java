package com.redlinktest.challenge;

import com.redlinktest.challenge.application.ImporteUseCase;
import com.redlinktest.challenge.domain.repository.EmpleadosRepo;
import com.redlinktest.challenge.domain.repository.InformeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Necesario para los tests (inyección de dependencias con autowired)
@SpringBootTest
public abstract class TestIntegration {
    @Autowired
    protected ImporteUseCase importeUseCase;

    @Autowired
    protected EmpleadosRepo empleadosRepo;

    @Autowired
    protected InformeRepo informeRepo;
}
