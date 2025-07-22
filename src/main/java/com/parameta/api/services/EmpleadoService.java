package com.parameta.api.services;

import com.parameta.api.dto.EmpleadoResponseDto;
import com.parameta.api.soap.EmpleadoSoapClient;
import com.parameta.api.soap.EmpleadoSoapRequest;
import com.parameta.api.soap.EmpleadoSoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoSoapClient empleadoSoapClient;

    public EmpleadoResponseDto procesarEmpleado(String nombres, String apellidos,
            String tipoDocumento, String numeroDocumento,
            LocalDate fechaNacimiento, LocalDate fechaVinculacion,
            String cargo, Double salario) {

                
        validarMayorDeEdad(fechaNacimiento);


        EmpleadoSoapRequest soapRequest = new EmpleadoSoapRequest(
            nombres, apellidos, tipoDocumento, numeroDocumento,
            fechaNacimiento, fechaVinculacion, cargo, salario
        );

        EmpleadoSoapResponse soapResponse = empleadoSoapClient.guardarEmpleado(soapRequest);
        
        if (!soapResponse.isExito()) {
            throw new RuntimeException("Error al guardar empleado via SOAP: " + soapResponse.getMensaje());
        }

        // Calcular tiempos
        String tiempoVinculacion = calcularTiempo(fechaVinculacion, LocalDate.now());
        String edadActual = calcularTiempo(fechaNacimiento, LocalDate.now());

        return new EmpleadoResponseDto(nombres, apellidos, tipoDocumento, numeroDocumento,
                fechaNacimiento, fechaVinculacion, cargo, salario,
                tiempoVinculacion, edadActual);
    }

    private void validarMayorDeEdad(LocalDate fechaNacimiento) {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad < 18) {
            throw new IllegalArgumentException("El empleado debe ser mayor de edad");
        }
    }

    private String calcularTiempo(LocalDate fechaInicio, LocalDate fechaFin) {
        Period periodo = Period.between(fechaInicio, fechaFin);
        return String.format("%d años, %d meses y %d días",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}