package com.parameta.api.controller;

import com.parameta.api.dto.EmpleadoResponseDto;
import com.parameta.api.services.EmpleadoService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/empleados")
@Validated
@CrossOrigin(origins = "*")  // permite solicitudes desde cualquier origen just for this test  
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping
    public ResponseEntity<EmpleadoResponseDto> crearEmpleado(
        @RequestParam @NotBlank(message = "Los nombres son obligatorios") String nombres,
        @RequestParam @NotBlank(message = "Los apellidos son obligatorios") String apellidos,
        @RequestParam @NotBlank(message = "El tipo de documento es obligatorio") String tipoDocumento,
        @RequestParam @NotBlank(message = "El número de documento es obligatorio") String numeroDocumento,
        @RequestParam @NotNull(message = "La fecha de nacimiento es obligatoria") 
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaNacimiento,
        @RequestParam @NotNull(message = "La fecha de vinculación es obligatoria")
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaVinculacion,
        @RequestParam @NotBlank(message = "El cargo es obligatorio") String cargo,
        @RequestParam @NotNull(message = "El salario es obligatorio") 
        @Positive(message = "El salario debe ser positivo") Double salario) {
        
        EmpleadoResponseDto response = empleadoService.procesarEmpleado(
            nombres, apellidos, tipoDocumento, numeroDocumento,
            fechaNacimiento, fechaVinculacion, cargo, salario);
            
        return ResponseEntity.ok(response);
    }
}