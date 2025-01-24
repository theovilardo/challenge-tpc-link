package com.redlinktest.challenge.application;

import com.redlinktest.challenge.domain.model.Empleado;
import com.redlinktest.challenge.domain.model.ImporteInforme;
import com.redlinktest.challenge.domain.repository.EmpleadosRepo;
import com.redlinktest.challenge.domain.repository.InformeRepo;
import com.redlinktest.challenge.dto.utils.Reporte;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class ImporteUseCase {
    private final EmpleadosRepo empleadosRepo;
    private final InformeRepo informeRepo;

    public ImporteUseCase(EmpleadosRepo empleadosRepo, InformeRepo informeRepo) {
        this.empleadosRepo = empleadosRepo;
        this.informeRepo = informeRepo;
    }

    public Reporte disponibilidadDeImporte(String dni) {
        Optional<Empleado> empleadoOpt = empleadosRepo.findByDni(dni);

        if (empleadoOpt.isPresent()) {
            // Si el DNI del empleado está registrado
            return actualizarInforme(empleadoOpt.get());
        } else {
            // Si el DNI no está registrado (es inválido)
            return respuestaDniInvalido();
        }
    }

    // se puede hacerlo funcional pero me parece mejor que sea mas declarativo
//    public Map<String, Object> disponibilidadDeImporte(String dni) {
//        Optional<Empleado> empleadoOpt = empleadosRepo.findByDni(dni);
//
//        return empleadoOpt.map(this::actualizarInforme).orElseGet(this::createInvalidDniResponse);
//    }

    private Reporte actualizarInforme(Empleado empleado) {
        // Si el empleado tiene DNI válido y tiene importe asociado, queda asentado en el informe
        if (tieneImporteValido(empleado)) {
            informeRepo.save(new ImporteInforme(empleado.getDni())); // Guardo el DNI del empleado en el informe
            return new Reporte(true, empleado.getImporte(), "Préstamo disponible");
        } else {
            // Si el DNI es válido y no tiene importe asociado (BigDecimal.ZERO)
            return new Reporte(true, null, "Préstamo no disponible");
        }
    }

    private boolean tieneImporteValido(@NotNull Empleado empleado) {
        return empleado.getImporte() != null && empleado.getImporte().doubleValue() > 0;
    }

    private Reporte respuestaDniInvalido() {
        return new Reporte(false, null, "DNI Inválido");
    }
}
