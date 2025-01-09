CREATE DATABASE IF NOT EXISTS Konoha;

USE Konoha;

CREATE TABLE Aldeas (
    IDAldea INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Rangos (
    IDRango INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Tipo ENUM('Ninja', 'Mision') 
);

CREATE TABLE Ninjas (
    IDNinja INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Identificacion VARCHAR(25),
    IDRango INT,
    IDAldea INT,
    FOREIGN KEY (IDRango) REFERENCES Rangos(IDRango),
    FOREIGN KEY (IDAldea) REFERENCES Aldeas(IDAldea)
);

CREATE TABLE Misiones (
    IDMision INT AUTO_INCREMENT PRIMARY KEY,
    Descripcion vARCHAR(255) NOT NULL,
    IDRango INT,
    Recompensa DECIMAL(10, 2),
    FechaInicio DATE,
    FechaFin DATE,
    Estado BOOLEAN DEFAULT 0,
    FOREIGN KEY (IDRango) REFERENCES Rangos(IDRango)
);

CREATE TABLE MisionNinja (
    IDNinja INT,
    IDMision INT,
    PRIMARY KEY(IDNinja, IDMision),
    FOREIGN KEY (IDNinja) REFERENCES Ninjas(IDNinja),
    FOREIGN KEY (IDMision) REFERENCES Misiones(IDMision)
);

CREATE TABLE Habilidades (
    IDHabilidad INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS HabilidadesNinjas(
	IDHabilidad INT NOT NULL,
	IDNinja INT NOT NULL,
    PRIMARY KEY(IDHabilidad, IDNinja ),
	FOREIGN KEY (IDHabilidad) REFERENCES Habilidades(IDHabilidad),
	FOREIGN KEY (IDNinja) REFERENCES Ninjas(IDNinja)
);

INSERT INTO Aldeas (Nombre) VALUES
('Aldea de la Hoja'),
('Aldea de la Arena'),
('Aldea del Sonido'),
('Aldea del Rayo');

INSERT INTO Rangos (Nombre, Tipo) VALUES
('Genin', 'Ninja'),
('Chuunin', 'Ninja'),
('Jounin', 'Ninja'),
('Kage', 'Ninja'),
('D', 'Mision'),
('C', 'Mision'),
('B', 'Mision'),
('A', 'Mision');

INSERT INTO Ninjas (Nombre, Identificacion, IDRango, IDAldea) VALUES
('Naruto Uzumaki', '12345', 1, 1),
('Sasuke Uchiha', '12346', 2, 1),
('Sakura Haruno', '12347', 2, 1),
('Kakashi Hatake', '12348', 3, 1),
('Gaara', '12349', 4, 2),
('Temari', '12350', 2, 2);

INSERT INTO Misiones (Descripcion, IDRango, Recompensa, FechaInicio, FechaFin, Estado) VALUES
('Proteger la Aldea de la Hoja', 5, 5000.00, '2025-01-10', NULL, 0),
('Recuperar un pergamino robado', 6, 10000.00, '2025-01-12', NULL, 0),
('Eliminación de una banda de bandidos', 6, 15000.00, '2025-01-15', '2025-01-16', 1),
('Rescate de prisioneros en la frontera', 7, 25000.00, '2025-01-20', NULL, 0);

INSERT INTO MisionNinja (IDNinja, IDMision) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

INSERT INTO Habilidades (Nombre) VALUES
('Rasengan'),
('Chidori'),
('Kunai'),
('Sello de la Torta'),
('Ojo de la Luna');

INSERT INTO HabilidadesNinjas (IDHabilidad, IDNinja) VALUES
(1, 1), 
(2, 2), 
(3, 3),
(4, 4), 
(5, 5); 

DELIMITER $$

CREATE TRIGGER actualizar_estado_mision
AFTER UPDATE ON Misiones
FOR EACH ROW
BEGIN
    IF NEW.FechaFin IS NOT NULL THEN
        UPDATE Misiones
        SET Estado = 1
        WHERE IDMision = NEW.IDMision;
    END IF;
END $$

DELIMITER ;

