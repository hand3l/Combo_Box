CREATE DATABASE calendario;
USE calendario;

CREATE TABLE meses (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50)
);

-- Insertar los meses del año en la tabla
INSERT INTO meses (Nombre) VALUES ('Enero');
INSERT INTO meses (Nombre) VALUES ('Febrero');
INSERT INTO meses (Nombre) VALUES ('Marzo');
INSERT INTO meses (Nombre) VALUES ('Abril');
INSERT INTO meses (Nombre) VALUES ('Mayo');
INSERT INTO meses (Nombre) VALUES ('Junio');
INSERT INTO meses (Nombre) VALUES ('Julio');
INSERT INTO meses (Nombre) VALUES ('Agosto');
INSERT INTO meses (Nombre) VALUES ('Septiembre');
INSERT INTO meses (Nombre) VALUES ('Octubre');
INSERT INTO meses (Nombre) VALUES ('Noviembre');
INSERT INTO meses (Nombre) VALUES ('Diciembre');
INSERT INTO meses (Nombre) VALUES ("Viernebes");
