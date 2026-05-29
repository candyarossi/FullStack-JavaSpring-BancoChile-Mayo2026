USE gestionbiblioteca;

INSERT INTO libros (titulo, autor, editorial, stock, fecha_lanzamiento, genero)
VALUES ('Drácula', 'Bram Stoker', 'Archibald CC', 4, '1897-05-26', 'Fantasía'),
	   ('Crónica de una muerte anunciada', 'Gabriel García Márquez', 'Bruguera', 12, '1981-04-15', 'Novela'),
       ('Papelucho', 'Marcela Paz', 'Universitaria', 7, '1947-01-01', 'Infantil'),
       ('Siddharta', 'Hermann Hesse', 'S. Fischer Verlag', 6, '1922-10-01', 'Novela Filosófica'),
       ('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Juan de la Cuesta', 5, '1605-01-16', 'Novela de aventuras');
       
INSERT INTO clientes (nombre, apellido, telefono, direccion, email)
VALUES ('Juan', 'Pérez', '2234567890', 'Av. Colón 1234', 'juan.perez@email.com'),
	   ('María', 'Gómez', '2235123456', 'San Martín 456', 'maria.gomez@email.com'),
       ('Lucas', 'Fernández', '2234789123', 'Rivadavia 789', 'lucas.fernandez@email.com'),
       ('Sofía', 'López', '2236345678', 'Belgrano 321', 'sofia.lopez@email.com'),
       ('Martín', 'Rodríguez', '2235987412', 'Independencia 654', 'martin.rodriguez@email.com');
       
INSERT INTO prestamos (fecha_inicio, fecha_fin, libros_id_libro, clientes_id_cliente)
VALUES ('2026-01-07', '2026-05-19', 3, 1),
	   ('2025-11-27', '2026-01-02', 4, 5),
       ('2025-08-14', '2025-10-12', 1, 3),
       ('2025-09-15', '2025-12-31', 5, 2),
       ('2025-12-14', '2026-02-05', 3, 1);
       
SELECT * FROM libros;
SELECT * FROM clientes;
SELECT * FROM prestamos;

-- Proyecta (consulta) todos los libros disponibles.
SELECT * FROM libros WHERE stock > 0;

-- Proyecta (consulta) únicamente el título y el stock de los libros disponibles.
SELECT titulo, stock FROM libros WHERE stock > 0;

-- Proyecta (consulta) todos los clientes ordenados de forma ascendente por nombre.
SELECT * FROM clientes ORDER BY nombre ASC;

-- Proyecta (consulta) los libros con stock menor a 10 unidades.
SELECT * FROM libros WHERE stock < 10;

-- Actualiza el stock del libro con ID = 2.
UPDATE libros SET stock = 8 WHERE id_libro = 2;
SELECT * FROM libros;

-- Elimina el libro que tenga ID = 3.
DELETE FROM prestamos WHERE libros_id_libro = 3;
SELECT * FROM prestamos;
DELETE FROM libros WHERE id_libro = 3;
SELECT * FROM libros;
