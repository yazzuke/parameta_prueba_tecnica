package com.parameta.api.soap;

import com.parameta.api.model.Empleado;
import com.parameta.api.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmpleadoSoapService {
    
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoSoapService.class);
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    public EmpleadoSoapResponse guardarEmpleado(EmpleadoSoapRequest request) {
        try {
            logger.info("Procesando empleado via SOAP: {}", request.getNumeroDocumento());
            
            // Verificar si ya existe
            if (empleadoRepository.existsByNumeroDocumento(request.getNumeroDocumento())) {
                return new EmpleadoSoapResponse(false, 
                    "Ya existe un empleado con el documento: " + request.getNumeroDocumento(), null);
            }
            
            Empleado empleado = new Empleado();
            empleado.setNombres(request.getNombres());
            empleado.setApellidos(request.getApellidos());
            empleado.setTipoDocumento(request.getTipoDocumento());
            empleado.setNumeroDocumento(request.getNumeroDocumento());
            empleado.setFechaNacimiento(request.getFechaNacimiento());
            empleado.setFechaVinculacion(request.getFechaVinculacion());
            empleado.setCargo(request.getCargo());
            empleado.setSalario(request.getSalario());
            
            Empleado empleadoGuardado = empleadoRepository.save(empleado);
            
            logger.info("Empleado guardado exitosamente via SOAP con ID: {}", empleadoGuardado.getId());
            
            return new EmpleadoSoapResponse(true, 
                "Empleado guardado exitosamente via SOAP", empleadoGuardado.getId());
            
        } catch (Exception e) {
            logger.error("Error al guardar empleado via SOAP: ", e);
            return new EmpleadoSoapResponse(false, 
                "Error en servicio SOAP: " + e.getMessage(), null);
        }
    }
}