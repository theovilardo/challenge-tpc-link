package com.redlinktest.challenge.dto;

import com.redlinktest.challenge.application.ImporteUseCase;
import com.redlinktest.challenge.dto.utils.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/prestamos")
public class DprController {

    @Autowired
    private ImporteUseCase importeUseCase;

    @GetMapping("/{dni}")
    public Reporte checkLoanAvailability(@PathVariable String dni) {
        return importeUseCase.disponibilidadDeImporte(dni);
    }

    @PostMapping("/{informe}")
    public Reporte checkInforme(@PathVariable String informe) {
        return importeUseCase.disponibilidadDeImporte(informe);
    }
}
