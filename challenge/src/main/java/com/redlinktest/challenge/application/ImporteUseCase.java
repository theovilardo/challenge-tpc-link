package com.redlinktest.challenge.application;

import com.redlinktest.challenge.domain.model.Empleado;
import com.redlinktest.challenge.domain.model.ImporteInforme;
import com.redlinktest.challenge.domain.repository.EmpleadosRepo;
import com.redlinktest.challenge.domain.repository.InformeRepo;
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

    // al usar Object class puedo devolver el tipo que quiera (POO trick!)
    public Map<String, Object> disponibilidadDeImporte(String dni) {
        Optional<Empleado> empleadoOpt = empleadosRepo.findByDni(dni);

        //separo los casos
        if (empleadoOpt.isPresent()) {
            // si el dni del empleado está registrado
            return actualizarInforme(empleadoOpt.get());
        } else {
            // si el dni no esta registrado (es invalido)
            return respuestaDniInvalido();
        }
    }

    // se puede hacerlo funcional pero me parece mejor que sea mas declarativo
//    public Map<String, Object> disponibilidadDeImporte(String dni) {
//        Optional<Empleado> empleadoOpt = empleadosRepo.findByDni(dni);
//
//        return empleadoOpt.map(this::actualizarInforme).orElseGet(this::createInvalidDniResponse);
//    }


    private Map<String, Object> actualizarInforme(Empleado empleado) {
        // si el empleado tiene dni válido y tiene importe asociado queda asentado en el informe
        if (tieneImporteValido(empleado)) {
            informeRepo.save(new ImporteInforme(empleado.getDni())); // guardo el dni dle empleado en el informe
            return Map.of(
                    "validez", true,
                    "importe", empleado.getImporte(),
                    "mensaje", "Préstamo disponible"
            );
        } else {
            // si el dni es válido y no tiene importe asociado (BigDecimal.ZERO)
            return Map.of(
                    "validez", true,
                    "mensaje", "Préstamo no disponible"
            );
        }
    }

    private boolean tieneImporteValido(@NotNull Empleado empleado) {
        return empleado.getImporte() != null &&
                empleado.getImporte().doubleValue() > 0;
    }

    private Map<String, Object> respuestaDniInvalido() {
        return Map.of(
                "validez", false,
                "mensaje", "DNI Invalido"
        );
    }
}
