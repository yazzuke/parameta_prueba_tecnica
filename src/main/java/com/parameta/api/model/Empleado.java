package com.parameta.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Los nombres son obligatorios")
    @Column(nullable = false)
    private String nombres;
    
    @NotBlank(message = "Los apellidos son obligatorios")
    @Column(nullable = false)
    private String apellidos;
    
    @NotBlank(message = "El tipo de documento es obligatorio")
    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento;
    
    @NotBlank(message = "El número de documento es obligatorio")
    @Column(name = "numero_documento", nullable = false, unique = true)
    private String numeroDocumento;
    
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    
    @NotNull(message = "La fecha de vinculación es obligatoria")
    @PastOrPresent(message = "La fecha de vinculación no puede ser futura")
    @Column(name = "fecha_vinculacion", nullable = false)
    private LocalDate fechaVinculacion;
    
    @NotBlank(message = "El cargo es obligatorio")
    @Column(nullable = false)
    private String cargo;
    
    @NotNull(message = "El salario es obligatorio")
    @Positive(message = "El salario debe ser positivo")
    @Column(nullable = false)
    private Double salario;
}