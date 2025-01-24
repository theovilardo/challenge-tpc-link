package com.redlinktest.challenge.controller;

import com.redlinktest.challenge.application.ImporteUseCase;
import com.redlinktest.challenge.domain.model.ImporteInforme;
import com.redlinktest.challenge.controller.utils.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class DprController {

    @Autowired
    private ImporteUseCase importeUseCase;

    @GetMapping("/{dni}")
    public Reporte disponibilidadDeImporte(@PathVariable String dni) {
        return importeUseCase.disponibilidadDeImporte(dni);
    }

    @PostMapping("/informe")
    public List<ImporteInforme> generarInformeDiario() {
        return importeUseCase.generarInformeDiario();
    }
}
