-- SQLite
DROP TABLE IF EXISTS pago;
DROP TABLE IF EXISTS pago_metodo;
DROP TABLE IF EXISTS factura;
DROP TABLE IF EXISTS medicamento_recetado;
DROP TABLE IF EXISTS receta_medica;
DROP TABLE IF EXISTS paciente_historia_clinica;
DROP TABLE IF EXISTS turno;
DROP TABLE IF EXISTS turno_estado;
DROP TABLE IF EXISTS sala;
DROP TABLE IF EXISTS medicamento;
DROP TABLE IF EXISTS medicamento_tipo;
DROP TABLE IF EXISTS medico;
DROP TABLE IF EXISTS medico_rol;
DROP TABLE IF EXISTS medico_especialidad;
DROP TABLE IF EXISTS paciente;
CREATE TABLE paciente (
    id_paciente INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    codigo_unico TEXT UNIQUE NOT NULL,
    email TEXT UNIQUE NOT NULL,
    telefono TEXT,
    fecha_nacimiento DATE,
    direccion TEXT,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE medico_especialidad (
    id_medico_especialidad INTEGER PRIMARY KEY,
    nombre_especialidad TEXT UNIQUE NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE medico_rol (
    id_medico_rol INTEGER PRIMARY KEY,
    nombre_rol TEXT UNIQUE NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE medico (
    id_medico INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    telefono TEXT,
    id_medico_especialidad INTEGER NOT NULL,
    id_medico_rol INTEGER NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_medico_especialidad) REFERENCES medico_especialidad (id_medico_especialidad),
    FOREIGN KEY (id_medico_rol) REFERENCES medico_rol (id_medico_rol)
);
CREATE TABLE paciente_historia_clinica (
    id_paciente_historia_clinica INTEGER PRIMARY KEY,
    id_paciente INTEGER NOT NULL,
    diagnostico TEXT,
    tratamiento TEXT,
    id_medico INTEGER NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
    FOREIGN KEY (id_medico) REFERENCES medico (id_medico)
);
CREATE TABLE receta_medica (
    id_receta_medica INTEGER PRIMARY KEY,
    id_turno INTEGER NOT NULL,
    indicaciones TEXT,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_turno) REFERENCES turno (id_turno)
);
CREATE TABLE medicamento_recetado (
    id_medicamento_recetado INTEGER PRIMARY KEY,
    id_receta_medica INTEGER NOT NULL,
    id_medicamento INTEGER NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_receta_medica) REFERENCES receta_medica (id_receta_medica),
    FOREIGN KEY (id_medicamento) REFERENCES medicamento (id_medicamento)
);
CREATE TABLE medicamento_tipo (
    id_medicamento_tipo INTEGER PRIMARY KEY,
    nombre_tipo TEXT UNIQUE NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE medicamento (
    id_medicamento INTEGER PRIMARY KEY,
    nombre_comercial TEXT NOT NULL,
    nombre_quimico TEXT,
    concentracion FLOAT,
    id_medicamento_tipo INTEGER NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_medicamento_tipo) REFERENCES medicamento_tipo (id_medicamento_tipo)
);
CREATE TABLE factura (
    id_factura INTEGER PRIMARY KEY,
    id_turno INTEGER NOT NULL,
    monto_total FLOAT NOT NULL,
    estado_pago TEXT NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_turno) REFERENCES turno (id_turno)
);
CREATE TABLE turno_estado (
    id_turno_estado INTEGER PRIMARY KEY,
    nombre_estado TEXT UNIQUE NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE sala (
    id_sala INTEGER PRIMARY KEY,
    numero_sala INTEGER UNIQUE NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE turno (
    id_turno INTEGER PRIMARY KEY,
    id_paciente INTEGER NOT NULL,
    id_medico INTEGER NOT NULL,
    id_sala INTEGER NOT NULL,
    fecha_turno DATETIME NOT NULL,
    id_turno_estado INTEGER NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_paciente) REFERENCES paciente (id_paciente),
    FOREIGN KEY (id_medico) REFERENCES medico (id_medico),
    FOREIGN KEY (id_sala) REFERENCES sala (id_sala),
    FOREIGN KEY (id_turno_estado) REFERENCES turno_estado (id_turno_estado)
);
CREATE TABLE pago_metodo (
    id_pago_metodo INTEGER PRIMARY KEY,
    nombre_metodo TEXT UNIQUE NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE pago (
    id_pago INTEGER PRIMARY KEY,
    id_factura INTEGER NOT NULL,
    id_pago_metodo INTEGER NOT NULL,
    estado TEXT DEFAULT 'A',
    fecha_crea DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modifica DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_factura) REFERENCES factura (id_factura),
    FOREIGN KEY (id_pago_metodo) REFERENCES pago_metodo (id_pago_metodo)
);