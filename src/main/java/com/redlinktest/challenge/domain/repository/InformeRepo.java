package com.redlinktest.challenge.domain.repository;

import com.redlinktest.challenge.domain.model.ImporteInforme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformeRepo extends JpaRepository<ImporteInforme, Long> {}
