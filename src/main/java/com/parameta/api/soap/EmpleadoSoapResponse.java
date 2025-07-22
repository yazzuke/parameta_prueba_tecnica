package com.parameta.api.soap;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "guardarEmpleadoResponse", namespace = "http://parameta.com/empleado")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoSoapResponse {
    
    @XmlElement(required = true)
    private boolean exito;
    
    @XmlElement
    private String mensaje;
    
    @XmlElement
    private Long empleadoId;
}