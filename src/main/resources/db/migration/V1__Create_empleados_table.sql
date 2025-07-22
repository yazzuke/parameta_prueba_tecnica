CREATE TABLE empleados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL,
    numero_documento VARCHAR(50) NOT NULL UNIQUE,
    fecha_nacimiento DATE NOT NULL,
    fecha_vinculacion DATE NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    salario DECIMAL(15,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Índices para mejorar el rendimiento
CREATE INDEX idx_numero_documento ON empleados(numero_documento);
CREATE INDEX idx_fecha_nacimiento ON empleados(fecha_nacimiento);
CREATE INDEX idx_fecha_vinculacion ON empleados(fecha_vinculacion);