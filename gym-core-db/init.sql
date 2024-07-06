CREATE SCHEMA IF NOT EXISTS personas;
CREATE SCHEMA IF NOT EXISTS recursos_humanos;
CREATE SCHEMA IF NOT EXISTS clientes;
CREATE SCHEMA IF NOT EXISTS actividades;

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

CREATE TABLE actividades.actividad(
	actividad_id SERIAL,
	nombre VARCHAR(50) NOT NULL,
	descripcion TEXT,
	PRIMARY KEY(actividad_id)
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

INSERT INTO actividades.actividad (actividad_id, nombre, descripcion)
VALUES
	(1,		'Crossfit',		'Actividad de alta intensidad que combina ejercicios de fuerza y resistencia.'),
	(2,		'Zumba',		'Actividad de baile que combina ritmos latinos y ejercicios aeróbicos.'),
	(3,		'Pilates',		'Actividad de bajo impacto que combina ejercicios de fuerza y flexibilidad.'),
	(4,		'Yoga',			'Actividad de meditación y relajación que combina ejercicios de flexibilidad y equilibrio.'),
	(5,		'Box',			'Actividad de combate que combina ejercicios de fuerza y resistencia.');
