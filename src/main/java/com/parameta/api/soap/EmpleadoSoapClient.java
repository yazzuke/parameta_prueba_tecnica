package com.parameta.api.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmpleadoSoapClient {
    
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoSoapClient.class);
    
    @Autowired
    private EmpleadoSoapService empleadoSoapService;
    
    public EmpleadoSoapResponse guardarEmpleado(EmpleadoSoapRequest request) {
        try {
            logger.info("Iniciando llamada SOAP para empleado: {}", request.getNumeroDocumento());
            

            EmpleadoSoapResponse response = empleadoSoapService.guardarEmpleado(request);
            
            logger.info("Respuesta SOAP recibida: exito={}, mensaje={}", 
                       response.isExito(), response.getMensaje());
            
            return response;
            
        } catch (Exception e) {
            logger.error("Error en llamada SOAP: ", e);
            return new EmpleadoSoapResponse(false, "Error en comunicación SOAP: " + e.getMessage(), null);
        }
    }
}