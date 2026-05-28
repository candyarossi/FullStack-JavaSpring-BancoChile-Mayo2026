-- CREAR DB
CREATE DATABASE bancoChile2026;

USE bancoChile2026;

-- CREAR TABLA
CREATE TABLE usuarios (
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(15) NOT NULL,
    edad INT,
    altura FLOAT,
    fecha_nacimiento DATE
);

-- Consultas CRUD -> (Create - Read - Update - Delete)

-- CREATE
INSERT INTO usuarios (nombre, apellido, edad, altura, fecha_nacimiento)
VALUES ('Lucas', 'Álvarez', 35, 1.72, '1985-03-29');

INSERT INTO usuarios (nombre, apellido, edad, altura, fecha_nacimiento)
VALUES ('Leo', 'Sierras', 24, 1.57, '1996-06-10'),
       ('Romina', 'Moyano', 56, 1.80, '1972-03-23'),
       ('Antonio', 'López', 47, 1.65, '1981-09-15'),
       ('Cecilia', 'Gutiérrez', 44, 1.67, '1983-12-08'),
       ('Luis', 'Pinki', 22, 1.58, '1999-08-05'),
       ('Antonio', 'López', 38, 1.64, '1989-10-31'),
       ('Luis', 'Barboza', 53, 1.72, '1973-11-09'),
       ('Carmen', 'Solano', 75, 1.56, '1945-09-02'),
       ('Diego', 'Palacios', 35, 1.76, '1990-01-26');

-- READ
SELECT * FROM usuarios;

SELECT nombre, apellido, edad FROM usuarios;

SELECT id_usuario, nombre, apellido, edad FROM usuarios WHERE id_usuario = 3;

SELECT * FROM usuarios WHERE nombre = 'Antonio' AND apellido = 'López';

SELECT * FROM usuarios WHERE edad > 40;

SELECT * FROM usuarios ORDER BY nombre ASC;

SELECT * FROM usuarios ORDER BY fecha_nacimiento DESC;

SELECT * FROM usuarios ORDER BY nombre ASC LIMIT 5 OFFSET 5;

SELECT * FROM usuarios WHERE nombre LIKE '%i%';

-- UPDATE
SELECT * FROM usuarios WHERE id_usuario = 5;

UPDATE usuarios SET edad = 56, altura = 1.55 WHERE id_usuario = 5;

-- DELETE
SELECT * FROM usuarios;

DELETE FROM usuarios WHERE id_usuario = 8;


