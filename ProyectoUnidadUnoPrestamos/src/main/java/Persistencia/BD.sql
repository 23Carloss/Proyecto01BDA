
CREATE DATABASE SistemaPrestamos;
USE SistemaPrestamos;

CREATE TABLE CuentaMoral (
    clabeMoral VARCHAR(18) PRIMARY KEY,
    saldoPresupuestal DECIMAL(10,2) NOT NULL,
    nombreBanco VARCHAR(20) NOT NULL
);

CREATE TABLE CuentaFisica (
    clabeFisica VARCHAR(18) PRIMARY KEY,
    nombreBanco VARCHAR(20) NOT NULL,
    estatus BOOLEAN NOT NULL
);

CREATE TABLE Departamento (
    idDepartamento VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    clabeMoral VARCHAR(18),
    FOREIGN KEY (clabeMoral) REFERENCES CuentaMoral(clabeMoral)
);

CREATE TABLE Empleado (
    idEmpleado VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidoPaterno VARCHAR(50) NOT NULL,
    apellidoMaterno VARCHAR(50) NOT NULL,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasenia VARCHAR(50) NOT NULL,
    idDepartamento VARCHAR(50) NOT NULL,
    clabeFisica VARCHAR(18) NOT NULL,
    FOREIGN KEY (idDepartamento) REFERENCES Departamento(idDepartamento),
    FOREIGN KEY (clabeFisica) REFERENCES CuentaFisica(clabeFisica)
);

CREATE TABLE TipoPrestamo (
    idTipoPrestamo VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    cantidadMaximaParcialidades INT NOT NULL
);


CREATE TABLE Prestamo (
    idPrestamo VARCHAR(50) PRIMARY KEY,
    adeudo DECIMAL(10,2),
    idTipoPrestamo VARCHAR(50),
    FOREIGN KEY (idTipoPrestamo) REFERENCES TipoPrestamo(idTipoPrestamo)
);

CREATE TABLE Abono (
    idAbono VARCHAR(50) PRIMARY KEY,
    monto DECIMAL(10,2) NOT NULL,
    fechaHora DATETIME NOT NULL,
    idPrestamo VARCHAR(50) NOT NULL,
    FOREIGN KEY (idPrestamo) REFERENCES Prestamo(idPrestamo)
);


CREATE TABLE DetallesPrestamo (
    idDetallesPrestamo VARCHAR(50) PRIMARY KEY,
    idEmpleado VARCHAR(50),
    idDepartamento VARCHAR(50),
    fechaHora DATETIME NOT NULL,
    estatus VARCHAR(50) NOT NULL,
    idPrestamo VARCHAR(50),
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado),
    FOREIGN KEY (idDepartamento) REFERENCES Departamento(idDepartamento),
    FOREIGN KEY (idPrestamo) REFERENCES Prestamo(idPrestamo)
);

DELIMITER $$

CREATE PROCEDURE RegistrarPrestamo (
    IN pidPrestamo VARCHAR(50),
    IN pAdeudo DECIMAL(10,2),
    IN pTipoPrestamo VARCHAR(50),
    IN pEmpleado VARCHAR(50),
    IN pDepartamento VARCHAR(50),
    IN pCuentaMoral VARCHAR(18),
    IN pFecha DATETIME
)
BEGIN
    DECLARE saldo_actual DECIMAL(10,2);

    START TRANSACTION;

    -- Validar saldo disponible
    SELECT saldoPresupuestal INTO saldo_actual
    FROM CuentaMoral
    WHERE clabeMoral = pCuentaMoral;

    IF saldo_actual < pAdeudo THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Saldo insuficiente en la cuenta moral';
    END IF;

    -- Insertar préstamo
    INSERT INTO Prestamo VALUES (pidPrestamo, pAdeudo, pTipoPrestamo);

    -- Insertar detalles del préstamo
    INSERT INTO DetallesPrestamo VALUES (CONCAT('DET_', pidPrestamo), pEmpleado, pDepartamento, pFecha, 'CREADO', pidPrestamo);

    -- Descontar del saldo
    UPDATE CuentaMoral
    SET saldoPresupuestal = saldoPresupuestal - pAdeudo
    WHERE clabeMoral = pCuentaMoral;

    COMMIT;
END $$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER validar_saldo_moral
BEFORE UPDATE ON CuentaMoral
FOR EACH ROW
BEGIN
    IF NEW.saldoPresupuestal < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede tener saldo negativo en la cuenta moral';
    END IF;
END $$

DELIMITER ;

-- Cuentas físicas (empleados)
INSERT INTO CuentaFisica VALUES
('032180000123456789', 'BBVA', TRUE),
('014180000112233445', 'Santander', TRUE),
('014180000444555666', 'Santander', TRUE),
('032180000123321456', 'BBVA', TRUE),
('002180000111222333', 'HSBC', TRUE),
('014180000147258369', 'Santander', TRUE),
('032180000963852741', 'BBVA', TRUE),
('014180000876543210', 'Santander', TRUE),
('072180000135792468', 'Banorte', TRUE),
('021180000123123123', 'Banamex', TRUE),
('072180000456456456', 'Banorte', TRUE);

-- Departamentos (clave moral corresponde a CuentaMoral que ya debes tener cargada)
INSERT INTO Departamento VALUES
('00004567', 'Recursos Humanos', '032180000123456789'),
('00005678', 'Finanzas', '014180000444555666'),
('00007890', 'Académico', '014180000147258369'),
('00001234', 'Inovación', '014180000876543210'),
('00009987', 'Tecnología', '021180000123123123');

-- Empleados jefes (uno por departamento)
INSERT INTO Empleado VALUES
('00004567', 'Oprah', 'Winfrey', '', 'oprah.winfrey', 'winfrey2025', '00004567', '032180000123456789'),
('00005678', 'Elon', 'Musk', '', 'elon.musk', 'teslaX2025', '00005678', '014180000444555666'),
('00007890', 'Albert', 'Einstein', '', 'albert.einstein', 'relatividad1', '00007890', '014180000147258369'),
('00001234', 'William', 'Henry Gates', '', 'bill.gates', '1234', '00001234', '014180000876543210'),
('00009987', 'Ada', 'Lovelace', '', 'ada.lovelace', 'lovelace42', '00009987', '021180000123123123');