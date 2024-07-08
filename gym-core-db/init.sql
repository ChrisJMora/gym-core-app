-- Active: 1720195981834@@127.0.0.1@5432@gym
CREATE SCHEMA IF NOT EXISTS personas;
CREATE SCHEMA IF NOT EXISTS recursos_humanos;
CREATE SCHEMA IF NOT EXISTS clientes;
CREATE SCHEMA IF NOT EXISTS itinerario;

CREATE TABLE personas.persona(
	persona_id SERIAL,
	cedula_identidad NUMERIC(10,0) NOT NULL,
	nombres VARCHAR(50) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	PRIMARY KEY(persona_id)
);

CREATE TABLE recursos_humanos.empleado(
	empleado_id SERIAL,
	persona_id INT,
	cargo VARCHAR(50) NOT NULL,
	PRIMARY KEY(empleado_id),
	CONSTRAINT fk_persona
		FOREIGN KEY(persona_id)
			REFERENCES personas.persona(persona_id),
	CONSTRAINT cargo_check 
		CHECK (cargo IN ('Entrenador', 'Administrativo'))
);

CREATE TABLE itinerario.actividad(
	actividad_id SERIAL,
	nombre VARCHAR(50) NOT NULL,
	descripcion TEXT,
	PRIMARY KEY(actividad_id)
);

CREATE TABLE itinerario.evento(
	evento_id SERIAL,
	hora_inicio TIME NOT NULL,
	hora_fin TIME NOT NULL,
	dia VARCHAR(10) NOT NULL,
	PRIMARY KEY(evento_id),
	CONSTRAINT hora_check
		CHECK (hora_inicio < hora_fin),
	CONSTRAINT dia_check
		CHECK (dia IN ('Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'))
)

CREATE TABLE itinerario.clase(
	clase_id SERIAL,
	entrenador_id INT,
	actividad_id INT,
	evento_id INT,
	PRIMARY KEY(clase_id),
	CONSTRAINT fk_entrenador
		FOREIGN KEY(entrenador_id)
			REFERENCES recursos_humanos.empleado(empleado_id),
	CONSTRAINT fk_actividad
		FOREIGN KEY(actividad_id)
			REFERENCES itinerario.actividad(actividad_id),
	CONSTRAINT fk_evento
		FOREIGN KEY(evento_id)
			REFERENCES itinerario.evento(evento_id)
);

CREATE TABLE clientes.miembro(
	miembro_id SERIAL,
	persona_id INT,
	entrenador_id INT,
	experiencia VARCHAR(50) NOT NULL,
	altura DECIMAL(4,2),
	peso DECIMAL(4,2),
	PRIMARY KEY(miembro_id),
	CONSTRAINT fk_persona
		FOREIGN KEY(persona_id)
			REFERENCES personas.persona(persona_id),
	CONSTRAINT fk_entrenador
		FOREIGN KEY(entrenador_id)
			REFERENCES recursos_humanos.empleado(empleado_id),
	CONSTRAINT experiencia_check 
		CHECK (experiencia IN ('Principiante', 'Intermedio', 'Avanzado'))
);

CREATE TABLE itinerario.sesion(
	sesion_id SERIAL,
	miembro_id INT,
	evento_id INT,
	PRIMARY KEY(sesion_id),
	CONSTRAINT fk_miembro
		FOREIGN KEY(miembro_id)
			REFERENCES clientes.miembro(miembro_id),
	CONSTRAINT fk_evento
		FOREIGN KEY(evento_id)
			REFERENCES itinerario.evento(evento_id)
);

INSERT INTO personas.persona (persona_id, cedula_identidad, nombres, apellidos, fecha_nacimiento)
VALUES
    (1,		1721624250, 'Christian David',	'Jácome Mora',			'2003-09-29'),
    (2,		1894568020, 'Keanu Chris',		'Hemsworth Reeves',		'2001-10-29'),
    (3,		1823456789, 'Maria Fernanda',	'González Pérez',		'1995-05-15'),
    (4,		1945678901, 'Carlos Alberto',	'Martínez López',		'1988-03-20'),
    (5,		1765432109, 'Ana María',		'Ramírez Gómez',		'1999-12-05'),
    (6,		1887654321, 'Luis Antonio',		'Hernández García',		'1985-07-10'),
    (7,		1901234567, 'Laura Gabriela',	'Díaz Jiménez',			'2000-09-18'),
    (8,		1832109876, 'Juan Pablo',		'Torres Rodríguez',		'1992-11-30'),
    (9,		1956789012, 'Paola Andrea',		'Sánchez Morales',		'1997-04-25'),
    (10,	1798765432, 'Diego Alejandro',	'Ortega Herrera',		'1983-08-12'),
    (11,	1876543210, 'María José',		'López Suárez',			'1998-01-22'),
    (12,	1812345678, 'Andrés Felipe',	'Castañeda Martínez',	'1991-06-08'),
    (13,	1912345678, 'Fernanda Isabel',	'Gómez Ríos',			'2002-02-14'),
    (14,	1845678901, 'Jorge Eduardo',	'Vargas Rojas',			'1994-10-03'),
    (15,	1773677567, 'Lucía Daniela',	'Pérez Pérez',			'1996-07-01'),
    (16,	1987661121, 'Pedro José',		'Ramírez Soto',			'1987-09-28'),
    (17,	1754321098, 'Carmen Rosa',		'Torres Vargas',		'2004-03-12'),
    (18,	1024779910, 'Roberto Carlos',	'García Morales',		'1980-12-24'),
    (19,	1789012345, 'Sofía Alejandra',	'Martínez Jiménez',		'1993-04-17'),
    (20,	1809876543, 'Miguel Ángel',		'Hernández Pérez',		'1989-08-05');

INSERT INTO recursos_humanos.empleado (empleado_id, persona_id, cargo)
VALUES
	(1,	2,	'Entrenador'),
	(2,	20,	'Entrenador'),
	(3, 13,	'Entrenador'),
	(4, 3,	'Administrativo'),
	(5, 4,	'Administrativo'),
	(6, 5,	'Administrativo');
	
INSERT INTO itinerario.actividad (actividad_id, nombre, descripcion)
VALUES
	(1,		'Crossfit',		'Actividad de alta intensidad que combina ejercicios de fuerza y resistencia.'),
	(2,		'Zumba',		'Actividad de baile que combina ritmos latinos y ejercicios aeróbicos.'),
	(3,		'Pilates',		'Actividad de bajo impacto que combina ejercicios de fuerza y flexibilidad.'),
	(4,		'Yoga',			'Actividad de meditación y relajación que combina ejercicios de flexibilidad y equilibrio.'),
	(5,		'Box',			'Actividad de combate que combina ejercicios de fuerza y resistencia.');

INSERT INTO itinerario.evento (evento_id, hora_inicio, hora_fin, dia)
VALUES
	(1,		'08:00:00', '10:00:00', 'Martes'),  	-- Entrenador 1
	(2,		'12:00:00', '14:00:00', 'Sábado'),		-- Entrenador 1
	(3,		'16:00:00', '18:00:00', 'Martes'), 		-- Entrenador 2
	(4,		'20:00:00', '22:00:00', 'Sábado'),		-- Entrenador 2
	(5,		'08:00:00', '09:00:00', 'Miércoles'),	-- Entrenador 3
	(6,		'09:00:00', '10:00:00', 'Miércoles'),	-- Entrenador 3
	(7,		'09:00:00', '11:00:00', 'Jueves'),		-- Entrenador 3
	(8,		'06:00:00', '08:00:00', 'Lunes'),		-- Entrenador 1 - Miembro 1
	(9,		'06:00:00', '08:00:00', 'Miércoles'),	-- Entrenador 1 - Miembro 1
	(10,	'06:00:00', '08:00:00', 'Viernes'),		-- Entrenador 1 - Miembro 1
	(11,	'06:00:00', '07:00:00', 'Sábado'),		-- Entrenador 1 - Miembro 1
	(12,	'10:00:00', '12:00:00', 'Lunes'),		-- Entrenador 1 - Miembro 2
	(13,	'10:00:00', '12:00:00', 'Miércoles'),	-- Entrenador 1 - Miembro 2
	(14,	'10:00:00', '12:00:00', 'Viernes'),		-- Entrenador 1 - Miembro 2
	(15,	'07:00:00', '08:00:00', 'Sábado'),		-- Entrenador 1 - Miembro 2
	(16,	'12:00:00', '14:00:00', 'Lunes'),		-- Entrenador 1 - Miembro 3
	(17,	'12:00:00', '14:00:00', 'Miércoles'),	-- Entrenador 1 - Miembro 3
	(18,	'12:00:00', '14:00:00', 'Viernes'),		-- Entrenador 1 - Miembro 3
	(19,	'08:00:00', '09:00:00', 'Sábado'),		-- Entrenador 1 - Miembro 3
	(20,	'06:00:00', '08:00:00', 'Martes'),		-- Entrenador 1 - Miembro 4
	(21,	'08:00:00', '10:00:00', 'Miércoles'),	-- Entrenador 1 - Miembro 4
	(22,	'06:00:00', '08:00:00',	'Jueves'),		-- Entrenador 1 - Miembro 4
	(23,	'09:00:00',	'10:00:00',	'Sábado'),		-- Entrenador 1 - Miembro 4
	(24,	'08:00:00', '10:00:00', 'Martes'),		-- Entrenador 1 - Miembro 5
	(25,	'08:00:00', '10:00:00',	'Jueves'),		-- Entrenador 1 - Miembro 5
	(26,	'08:00:00', '10:00:00', 'Viernes'),		-- Entrenador 1 - Miembro 5
	(27,	'10:00:00',	'11:00:00',	'Sábado'),		-- Entrenador 1 - Miembro 5
	(30,	'08:00:00', '10:00:00', 'Lunes'),		-- Entrenador 1 - Miembro 6
	(28,	'10:00:00', '12:00:00', 'Martes'),		-- Entrenador 1 - Miembro 6
	(29,	'10:00:00', '12:00:00',	'Jueves'),		-- Entrenador 1 - Miembro 6
	(31,	'11:00:00',	'12:00:00',	'Sábado'),		-- Entrenador 1 - Miembro 6
	(32,	'14:00:00', '16:00:00', 'Lunes'),		-- Entrenador 2 - Miembro 1
	(33,	'14:00:00', '16:00:00', 'Miércoles'),	-- Entrenador 2 - Miembro 1
	(34,	'14:00:00', '16:00:00', 'Viernes'),		-- Entrenador 2 - Miembro 1
	(35,	'14:00:00', '15:00:00', 'Sábado'),		-- Entrenador 2 - Miembro 1
	(36,	'18:00:00', '20:00:00', 'Lunes'),		-- Entrenador 2 - Miembro 2
	(37,	'18:00:00', '20:00:00', 'Miércoles'),	-- Entrenador 2 - Miembro 2
	(38,	'18:00:00', '20:00:00', 'Viernes'),		-- Entrenador 2 - Miembro 2
	(39,	'15:00:00', '16:00:00', 'Sábado'),		-- Entrenador 2 - Miembro 2
	(40,	'20:00:00', '22:00:00', 'Lunes'),		-- Entrenador 2 - Miembro 3
	(41,	'20:00:00', '22:00:00', 'Miércoles'),	-- Entrenador 2 - Miembro 3
	(42,	'20:00:00', '22:00:00', 'Viernes'),		-- Entrenador 2 - Miembro 3
	(43,	'16:00:00', '17:00:00', 'Sábado'),		-- Entrenador 2 - Miembro 3
	(44,	'14:00:00', '16:00:00', 'Martes'),		-- Entrenador 2 - Miembro 4
	(45,	'16:00:00', '18:00:00', 'Miércoles'),	-- Entrenador 2 - Miembro 4
	(46,	'14:00:00', '16:00:00',	'Jueves'),		-- Entrenador 2 - Miembro 4
	(47,	'17:00:00',	'18:00:00',	'Sábado'),		-- Entrenador 2 - Miembro 4
	(48,	'16:00:00', '18:00:00', 'Martes'),		-- Entrenador 2 - Miembro 5
	(49,	'16:00:00', '18:00:00',	'Jueves'),		-- Entrenador 2 - Miembro 5
	(50,	'16:00:00', '18:00:00', 'Viernes'),		-- Entrenador 2 - Miembro 5
	(51,	'18:00:00',	'19:00:00',	'Sábado'),		-- Entrenador 2 - Miembro 5
	(52,	'16:00:00', '18:00:00', 'Lunes'),		-- Entrenador 2 - Miembro 6
	(53,	'18:00:00', '20:00:00', 'Martes'),		-- Entrenador 2 - Miembro 6
	(54,	'18:00:00', '20:00:00',	'Jueves'),		-- Entrenador 2 - Miembro 6
	(55,	'19:00:00',	'20:00:00',	'Sábado');		-- Entrenador 2 - Miembro 6


INSERT INTO itinerario.clase (clase_id, entrenador_id, actividad_id, evento_id)
VALUES
	(1,	1, 1, 1),
	(2,	1, 5, 2),
	(3, 2, 1, 3),
	(4, 2, 5, 4),
	(5, 3, 2, 5),
	(6, 3, 3, 6),
	(7, 3, 4, 7);

INSERT INTO clientes.miembro (miembro_id, persona_id, entrenador_id, experiencia, altura, peso)
VALUES
	(1,		1,	1,	'Principiante',	1.70,	70.0),
	(2,		6,	1,	'Principiante',	1.50,	55.5),
	(3,		7,	1,	'Intermedio',	1.65,	59.9),
	(4,		8,	1,	'Intermedio',	1.69,	65.1),
	(5,		9,	1,	'Avanzado',		1.80,	75.0),
	(6,		10,	1,	'Avanzado',		1.78,	51.9),
	(7,		11,	2,	'Principiante',	1.75,	60.0),
	(8,		12,	2,	'Principiante',	2.00,	75.0),
	(9,		14,	2,	'Intermedio',	1.85,	70.0),
	(10,	15,	2,	'Intermedio',	1.70,	65.0),
	(11,	16,	2,	'Avanzado',		1.90,	82.2),
	(12,	17,	2,	'Avanzado',		1.55,	50.0),
	(13,	18,	3,	'Principiante',	1.68,	62.0),
	(14,	19,	3,	'Principiante',	1.76,	66.6);

INSERT INTO itinerario.sesion (sesion_id, miembro_id, evento_id)
VALUES
	(1,	 1, 8),
	(2,	 1, 9),
	(3,	 1, 10),
	(4,	 1, 11),
	(5,	 2, 12),
	(6,	 2, 13),
	(7,	 2, 14),
	(8,	 2, 15),
	(9,	 3, 16),
	(10, 3, 17),
	(11, 3, 18),
	(12, 3, 19),
	(13, 4, 20),
	(14, 4, 21),
	(15, 4, 22),
	(16, 4, 23),
	(17, 5, 24),
	(18, 5, 25),
	(19, 5, 26),
	(20, 5, 27),
	(21, 6, 30),
	(22, 6, 28),
	(23, 6, 29),
	(24, 6, 31),
	(25, 7, 32),
	(26, 7, 33),
	(27, 7, 34),
	(28, 7, 35),
	(29, 8, 36),
	(30, 8, 37),
	(31, 8, 38),
	(32, 8, 39),
	(33, 9, 40),
	(34, 9, 41),
	(35, 9, 42),
	(36, 9, 43),
	(37, 10, 44),
	(38, 10, 45),
	(39, 10, 46),
	(40, 10, 47),
	(41, 11, 48),
	(42, 11, 49),
	(43, 11, 50),
	(44, 11, 51),
	(45, 12, 52),
	(46, 12, 53),
	(47, 12, 54),
	(48, 12, 55),
	(49, 13, 8),
	(50, 13, 9),
	(51, 13, 10),
	(52, 13, 11),
	(53, 14, 12),
	(54, 14, 13),
	(55, 14, 14),
	(56, 14, 15);
