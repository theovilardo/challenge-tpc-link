package com.redlinktest.challenge.domain.repository;

import com.redlinktest.challenge.domain.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadosRepo extends JpaRepository<Empleado, String> {
    Optional<Empleado> findByDni(String dni); // optional es un tipo de dato que puede no estar (es nullable)
}
