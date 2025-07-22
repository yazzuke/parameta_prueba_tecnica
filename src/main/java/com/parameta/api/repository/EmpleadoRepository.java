package com.parameta.api.repository;

import com.parameta.api.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByNumeroDocumento(String numeroDocumento);
    boolean existsByNumeroDocumento(String numeroDocumento);
}