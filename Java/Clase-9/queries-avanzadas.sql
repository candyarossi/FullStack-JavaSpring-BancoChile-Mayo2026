CREATE DATABASE bancochile2026;

USE bancochile2026;

CREATE TABLE ciudades (
    id_ciudad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE personas (
    id_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(15) NOT NULL,
    edad INT,
    altura FLOAT,
    fecha_nacimiento DATE,
    ciudad INT,
    FOREIGN KEY (ciudad) REFERENCES ciudades (id_ciudad)
);

-- CONSULTAS CRUD

INSERT INTO ciudades (nombre) VALUES ("Tucuman");

INSERT INTO ciudades (nombre) VALUES ("Buenos Aires");

INSERT INTO ciudades (nombre) VALUES ("Caracas");

INSERT INTO ciudades (nombre) VALUES ("Santiago");

INSERT INTO ciudades (nombre) VALUES ("Lima");

INSERT INTO ciudades (nombre) VALUES ("Santa Cruz");

INSERT INTO
    personas (
        nombre,
        apellido,
        edad,
        altura,
        fecha_nacimiento,
        ciudad
    )
VALUES (
        'Lucas',
        'Álvarez',
        35,
        1.72,
        '1985-03-29',
        1
    ),
    (
        'Leo',
        'Sierras',
        24,
        1.57,
        '1996-06-10',
        1
    ),
    (
        'Romina',
        'Moyano',
        56,
        1.80,
        '1972-03-23',
        null
    ),
    (
        'Antonio',
        'López',
        47,
        1.65,
        '1981-09-15',
        2
    ),
    (
        'Cecilia',
        'Gutiérrez',
        44,
        1.67,
        '1983-12-08',
        4
    ),
    (
        'Luis',
        'Pinki',
        22,
        1.58,
        '1999-08-05',
        5
    ),
    (
        'Antonio',
        'López',
        38,
        1.64,
        '1989-10-31',
        null
    ),
    (
        'Luis',
        'Barboza',
        53,
        1.72,
        '1973-11-09',
        null
    ),
    (
        'Carmen',
        'Solano',
        75,
        1.56,
        '1945-09-02',
        1
    ),
    (
        'Diego',
        'Palacios',
        35,
        1.76,
        '1990-01-26',
        2
    );

SELECT * FROM ciudades;

SELECT * FROM personas;

UPDATE personas SET edad = 67, ciudad = 5 WHERE id_persona = 5;

DELETE FROM personas WHERE id_persona = 8;

-- FUNCIONES INTEGRADAS

SELECT
    concat(apellido, ", ", nombre) AS nombre_completo,
    edad,
    altura,
    fecha_nacimiento
FROM personas;

SELECT nombre, length(nombre) AS length_nombre FROM personas;

SELECT upper(apellido) AS apellido, lower(nombre) AS nombre
FROM personas;

SELECT sum(edad) AS suma_edades FROM personas;

SELECT avg(edad) AS promedio_edad FROM personas;

SELECT
    min(altura) AS minimo_altura,
    max(altura) AS maximo_altura
FROM personas;

SELECT round(altura, 1) AS altura, nombre, apellido FROM personas;

SELECT nombre, apellido, date_format(fecha_nacimiento, '%d/%m/%Y') AS nacimiento
FROM personas;

SELECT
    nombre,
    apellido,
    day(fecha_nacimiento) AS dia,
    month(fecha_nacimiento) AS mes,
    year(fecha_nacimiento) AS anio
FROM personas;

SELECT count(*) AS cantidad_antonios
FROM personas
WHERE
    nombre = "Antonio";

SELECT nombre, apellido, IF(ciudad, ciudad, 'N/A') AS ciudad
FROM personas;

-- JOINS

SELECT *
FROM personas
    LEFT JOIN ciudades ON ciudades.id_ciudad = personas.ciudad;

SELECT *
FROM personas
    RIGHT JOIN ciudades ON ciudades.id_ciudad = personas.ciudad;

SELECT *
FROM ciudades
    INNER JOIN personas ON ciudades.id_ciudad = personas.ciudad;

SELECT *
FROM personas
    JOIN ciudades ON ciudades.id_ciudad = personas.ciudad;

SELECT * FROM personas FULL JOIN ciudades;

SELECT * FROM personas CROSS JOIN ciudades;