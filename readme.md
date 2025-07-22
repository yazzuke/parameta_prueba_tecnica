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

## 🌐 Demo en Producción
**URL Base:** https://pruebaparameta.zeabur.app

 
## Casos de Prueba
### Caso 1: Empleado válido (Felipe)
```bash
https://pruebaparameta.zeabur.app/api/empleados?nombres=Felipe&apellidos=Avila&tipoDocumento=CC&numeroDocumento=1001296937&fechaNacimiento=2002-08-12&fechaVinculacion=2020-01-01&cargo=Desarrollador&salario=5000000
```

### Caso 2: Empleado válido
```bash
https://pruebaparameta.zeabur.app/api/empleados?nombres=Juana&apellidos=Rodriguez&tipoDocumento=CC&numeroDocumento=39748748&fechaNacimiento=1995-03-15&fechaVinculacion=2022-06-01&cargo=Analista&salario=4500000
```

### Caso 3: Empleado válido
```bash
https://pruebaparameta.zeabur.app/api/empleados?nombres=Carlos&apellidos=Martinez&tipoDocumento=TI&numeroDocumento=456789123&fechaNacimiento=1988-11-20&fechaVinculacion=2021-03-15&cargo=Manager&salario=8000000
```

### Caso 4: Error - Menor de edad
```bash
https://pruebaparameta.zeabur.app/api/empleados?nombres=Juan&apellidos=Perez&tipoDocumento=CC&numeroDocumento=123456789&fechaNacimiento=2010-01-01&fechaVinculacion=2023-01-01&cargo=Asistente&salario=2000000
```
**Respuesta esperada:** Error 500 - "El empleado debe ser mayor de edad"

### Caso 5: Error - Campo vacío (nombres)
```bash
https://pruebaparameta.zeabur.app/api/empleados?nombres=&apellidos=Lopez&tipoDocumento=CC&numeroDocumento=789123456&fechaNacimiento=1990-05-10&fechaVinculacion=2020-08-01&cargo=Coordinador&salario=6000000
```
**Respuesta esperada:** Error 400 - Validation error

### Caso 6: Error - Salario negativo
```bash
https://pruebaparameta.zeabur.app/api/empleados?nombres=Ana&apellidos=Garcia&tipoDocumento=CC&numeroDocumento=321654987&fechaNacimiento=1992-07-25&fechaVinculacion=2021-10-01&cargo=Diseñadora&salario=-1000
```
**Respuesta esperada:** Error 400 - "El salario debe ser positivo"

## 📊 Respuesta Exitosa (Ejemplo)
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

## ✅ Validaciones Implementadas
- ✅ Mayor de edad (18+ años)
- ✅ Campos obligatorios (@NotBlank, @NotNull)
- ✅ Formato de fechas (yyyy-MM-dd)
- ✅ Salario positivo (@Positive)
- ✅ Validación de documentos únicos

## 🏗️ Arquitectura SOAP
```
REST API → SOAP Client → SOAP Service → MySQL Database
```

**Flujo de procesamiento:**
1. Recepción de parámetros via GET
2. Validaciones de negocio (mayor de edad, campos obligatorios)
3. Llamada a servicio SOAP (simulado internamente)
4. Persistencia en base de datos MySQL
5. Cálculo de tiempo de vinculación y edad actual
6. Respuesta JSON con todos los datos + cálculos

## Stack Tecnológico
- **Java 17** + **Spring Boot 3.5.3**
- **REST API** con Spring Web
- **SOAP Integration** con Spring WS
- **MySQL** + **Spring Data JPA**
- **Flyway** para migraciones de BD
- **Docker** para containerización
- **Zeabur** para deployment en la nube
- **Lombok** para clean code


### Prerequisitos
- Java 17+
- MySQL 8.0+
- Maven 3.6+

### Variables de entorno
```properties
DATABASE_URL=jdbc:mysql://localhost:3306/parameta
DATABASE_USERNAME=root
DATABASE_PASSWORD=your_password
```

## 📝 Notas Técnicas

### Simulación de SOAP
Para efectos de esta prueba técnica, el servicio SOAP está simulado internamente. En un ambiente productivo real, sería un microservicio independiente con su propio endpoint y WSDL.


### Validaciones
- Las validaciones se implementan usando Bean Validation (JSR-303)
- La validación de mayor de edad es una regla de negocio custom
- Los formatos de fecha siguen el estándar ISO 8601 (yyyy-MM-dd)

