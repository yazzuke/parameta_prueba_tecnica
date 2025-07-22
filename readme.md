# Parameta Prueba Tecnica

De antemano, gracias por darme la oportunidad de presentar esta prueba tecnica, es todo un honor para mi.

# Prueba a implementar:
Implementar en Java un servicio Rest que reciba como parámetros los atributos del objeto
empleado (que será descrito más adelante) al ser invocado mediante el método GET.
El servicio deberá validar los formatos de las fechas y que los atributos no vengan vacíos,
adicionalmente deberá validar que el empleado sea mayor de edad.
Una vez se hayan superado estas validaciones se deberá invocar un servicio web SOAP
pasando como parámetro el objeto empleado, este último servicio deberá almacenar la
información en una base de datos mysql.
El método REST responderá con el objeto en estructura JSON, en el que se deberá adicionar
la siguiente información:
• Tiempo de Vinculación a la compañía (años, meses y días).
• Edad actual del empleado (años, meses y días)

Atributos del objeto empleado:
• Nombres (String)
• Apellidos (String)
• Tipo de Documento (String)
• Número de Documento (String)
• Fecha de Nacimiento (Date)
• Fecha de Vinculación a la Compañía (Date)
• Cargo (String)
• Salario (Double)

## Endpoint Principal
```bash
GET /api/empleados?nombres=Felipe&apellidos=Avila&tipoDocumento=CC&numeroDocumento=1001296937&fechaNacimiento=2002-08-12&fechaVinculacion=2020-01-01&cargo=Desarrollador&salario=5000000
```

## Respuesta
```json
{
    "nombres": "Felipe",
    "apellidos": "Avila", 
    "tipoDocumento": "CC",
    "numeroDocumento": "1001296937",
    "fechaNacimiento": "2002-08-12",
    "fechaVinculacion": "2020-01-01",
    "cargo": "Desarrollador",
    "salario": 5000000.0,
    "tiempoVinculacion": "5 años, 6 meses y 21 días",
    "edadActual": "22 años, 11 meses y 10 días"
}
```

## Validaciones
- Mayor de edad (18+ años)
- Campos obligatorios
- Formato de fechas (yyyy-MM-dd)
- Salario positivo

## Arquitectura SOAP
REST → SOAP Client → SOAP Service → MySQL