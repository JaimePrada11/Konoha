CREATE DATABASE IF NOT EXISTS Konoha;

USE Konoha;

CREATE TABLE IF NOT EXISTS Rangos(
	IDRango INT PRIMARY KEY AUTO_INCREMENT,
	Nombre VARCHAR(100) NOT NULL
);

INSERT INTO Rangos(Nombre) VALUES
('A'), ('B'), ('C'), ('D');


CREATE TABLE IF NOT EXISTS Aldeas(
	IDAldea INT PRIMARY KEY AUTO_INCREMENT,
	Nombre VARCHAR(100) NOT NULL
);


INSERT INTO  Aldeas(Nombre) VALUES
('Konoha'), ('Aldea de la Arena'), ('Aldea del Sonido'), ('Aldea de la Roca');



CREATE TABLE IF NOT EXISTS Habilidades(
	IDHabilidad INT PRIMARY KEY AUTO_INCREMENT,
	Nombre VARCHAR(100) NOT NULL
);

INSERT INTO Habilidades (Nombre) VALUES
('Rasengan'), ('Jutsus'), ('Rinnegan');
 
CREATE TABLE IF NOT EXISTS Ninjas(
	IDNinja INT PRIMARY KEY AUTO_INCREMENT,
	Nombre VARCHAR(100) NOT NULL,
	idIdentificacion VARCHAR(25) NOT NULL UNIQUE,
	IDRango INT NOT NULL,
	IDAldea INT NOT NULL,
	FOREIGN KEY (IDRango) REFERENCES Rangos(IDRango),
	FOREIGN KEY (IDAldea) REFERENCES Aldeas(IDAldea)
);


INSERT INTO Ninjas (Nombre, idIdentificacion, IDRango, IDAldea) VALUES 
('Naruto', '12456', 1,1), ('Sasuke','459787', 1,2),('Sakura', '36484', 1,2);

CREATE TABLE IF NOT EXISTS HabilidadesNinjas(
	IDHabilidad INT NOT NULL,
	IDNinja INT NOT NULL,
	FOREIGN KEY (IDHabilidad) REFERENCES Habilidades(IDHabilidad),
	FOREIGN KEY (IDNinja) REFERENCES Ninjas(IDNinja)
);

INSERT INTO HabilidadesNinjas(IDHabilidad, IDNinja) VALUES
(1,1), (1,2), (2,2),(2,3), (3,2);


CREATE TABLE IF NOT EXISTS Misiones(
	IDMision INT PRIMARY KEY AUTO_INCREMENT,
	Descripcion VARCHAR(100) NOT NULL,
	IDRango INT NOT NULL,
	Recompensa VARCHAR(100) NOT NULL,	
	FechaInicio DATE NOT NULL,
	FechaFin DATE NULL,
	FOREIGN KEY (IDRango) REFERENCES Rangos(IDRango)
);

INSERT INTO Misiones(Descripcion, IDRango, Recompensa,FechaInicio,FechaFin  ) VALUES 
('Rescatar a Gara', 1, 'Amistad', '2020-01-15', '2021-10-25'),
('Infiltrarse en campamento enemigo', 1, 'Money', '2024-11-15', NULL );

CREATE TABLE IF NOT EXISTS MisionNinja(
	IDMision INT NOT NULL,
	IDNinja INT NOT NULL,
	PRIMARY KEY(IDMision, IDNinja),
	FOREIGN KEY (IDMision) REFERENCES Misiones(IDMision),
	FOREIGN KEY (IDNinja) REFERENCES Ninjas(IDNinja)
);

INSERT INTO MisionNinja(IDMision, IDNinja) VALUES
(1,1), (1,2),(2,3);
