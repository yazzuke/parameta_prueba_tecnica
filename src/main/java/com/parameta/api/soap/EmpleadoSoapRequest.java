package com.parameta.api.soap;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@XmlRootElement(name = "guardarEmpleadoRequest", namespace = "http://parameta.com/empleado")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoSoapRequest {
    
    @XmlElement(required = true)
    private String nombres;
    
    @XmlElement(required = true)
    private String apellidos;
    
    @XmlElement(required = true)
    private String tipoDocumento;
    
    @XmlElement(required = true)
    private String numeroDocumento;
    
    @XmlElement(required = true)
    private LocalDate fechaNacimiento;
    
    @XmlElement(required = true)
    private LocalDate fechaVinculacion;
    
    @XmlElement(required = true)
    private String cargo;
    
    @XmlElement(required = true)
    private Double salario;
}