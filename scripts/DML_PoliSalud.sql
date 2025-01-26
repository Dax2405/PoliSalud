INSERT INTO paciente (
        id_paciente,
        nombre,
        apellido,
        codigo_unico,
        email,
        telefono,
        fecha_nacimiento,
        direccion
    )
VALUES (
        1,
        'Dax',
        'Navarrete',
        '2023201',
        'dax.navarrete@epn.edu.ec',
        '0991234567',
        '1990-05-10',
        'Quito'
    ),
    (
        2,
        'Emilia',
        'Moreno',
        '2023202',
        'emilia.moreno@epn.edu.ec',
        '0987654321',
        '1985-11-15',
        'Guayaquil'
    ),
    (
        3,
        'Patricio',
        'Paccha',
        '2023203',
        'patricio.paccha@epn.edu.ec',
        '0971122334',
        '1992-08-20',
        'Cuenca'
    ),
    (
        4,
        'Jorge',
        'Rosero',
        '2023204',
        'jorge.rosero@epn.edu.ec',
        '0965544332',
        '1988-01-25',
        'Ambato'
    ),
    (
        5,
        'María',
        'Vera',
        '2023205',
        'maria.vera@epn.edu.ec',
        '0989988776',
        '1995-03-30',
        'Loja'
    ),
    (
        6,
        'Luis',
        'Peralta',
        '2023206',
        'luis.peralta@epn.edu.ec',
        '0976543211',
        '1991-07-12',
        'Riobamba'
    ),
    (
        7,
        'Carla',
        'Mora',
        '2023207',
        'carla.mora@epn.edu.ec',
        '0981122334',
        '1989-10-04',
        'Manta'
    ),
    (
        8,
        'Daniela',
        'Cruz',
        '2023208',
        'daniela.cruz@epn.edu.ec',
        '0997766554',
        '1994-12-19',
        'Santo Domingo'
    ),
    (
        9,
        'Javier',
        'Santana',
        '2023209',
        'javier.santana@epn.edu.ec',
        '0969988775',
        '1993-09-18',
        'Machala'
    ),
    (
        10,
        'Elena',
        'Espinosa',
        '2023210',
        'elena.espinosa@epn.edu.ec',
        '0978877665',
        '1990-02-14',
        'Esmeraldas'
    ),
    (
        11,
        'Carlos',
        'Aguirre',
        '2023211',
        'carlos.aguirre@epn.edu.ec',
        '0956677889',
        '1986-06-23',
        'Ibarra'
    ),
    (
        12,
        'Mónica',
        'Quintana',
        '2023212',
        'monica.quintana@epn.edu.ec',
        '0994433221',
        '1987-11-11',
        'Tulcán'
    ),
    (
        13,
        'Santiago',
        'Benitez',
        '2023213',
        'santiago.benitez@epn.edu.ec',
        '0983322110',
        '1996-04-07',
        'Latacunga'
    ),
    (
        14,
        'Andrea',
        'Chávez',
        '2023214',
        'andrea.chavez@epn.edu.ec',
        '0975544332',
        '1993-08-09',
        'Otavalo'
    ),
    (
        15,
        'Francisco',
        'Segovia',
        '2023215',
        'francisco.segovia@epn.edu.ec',
        '0954433221',
        '1985-12-31',
        'Guaranda'
    ),
    (
        16,
        'Gabriela',
        'Sánchez',
        '2023216',
        'gabriela.sanchez@epn.edu.ec',
        '0998877665',
        '1992-03-27',
        'Portoviejo'
    ),
    (
        17,
        'Pablo',
        'Villavicencio',
        '2023217',
        'pablo.villavicencio@epn.edu.ec',
        '0987654433',
        '1994-07-15',
        'Quevedo'
    ),
    (
        18,
        'Diana',
        'Zambrano',
        '2023218',
        'diana.zambrano@epn.edu.ec',
        '0978899776',
        '1995-10-10',
        'Milagro'
    ),
    (
        19,
        'Ricardo',
        'Palacios',
        '2023219',
        'ricardo.palacios@epn.edu.ec',
        '0961234432',
        '1991-01-05',
        'Chone'
    ),
    (
        20,
        'Luisa',
        'Correa',
        '2023220',
        'luisa.correa@epn.edu.ec',
        '0976546789',
        '1988-09-12',
        'Salinas'
    );
INSERT INTO medico_especialidad (id_medico_especialidad, nombre_especialidad)
VALUES (1, 'Cardiología'),
    (2, 'Pediatría'),
    (3, 'Neurología'),
    (4, 'Traumatología'),
    (5, 'Dermatología');
INSERT INTO medico_rol (id_medico_rol, nombre_rol)
VALUES (1, 'Residente'),
    (2, 'Especialista'),
    (3, 'Jefe de Departamento');
INSERT INTO medico (
        id_medico,
        nombre,
        apellido,
        telefono,
        email,
        id_medico_especialidad,
        id_medico_rol
    )
VALUES (
        1,
        'Andrés',
        'Martínez',
        '0981122334',
        'andres.martinez@epn.edu.ec',
        1,
        2
    ),
    (
        2,
        'Mariana',
        'Paredes',
        '0995544332',
        'mariana.paredes@epn.edu.ec',
        2,
        3
    ),
    (
        3,
        'Carlos',
        'Gómez',
        '0978899776',
        'carlos.gomez@epn.edu.ec',
        3,
        1
    ),
    (
        4,
        'Sofía',
        'Torres',
        '0954433221',
        'sofia.torres@epn.edu.ec',
        4,
        2
    ),
    (
        5,
        'Juan',
        'Cevallos',
        '0965544332',
        'juan.cevallos@epn.edu.ec',
        5,
        1
    );
INSERT INTO sala (id_sala, numero_sala)
VALUES (1, 101),
    (2, 102),
    (3, 201),
    (4, 202),
    (5, 301);
INSERT INTO turno_estado (id_turno_estado, nombre_estado)
VALUES (1, 'Programado'),
    (2, 'Realizado'),
    (3, 'Cancelado');
INSERT INTO turno (
        id_turno,
        id_paciente,
        id_medico,
        id_sala,
        fecha_turno,
        id_turno_estado
    )
VALUES (1, 1, 1, 1, '2025-02-01 09:00:00', 1),
    (2, 2, 2, 2, '2025-02-01 10:00:00', 1),
    (3, 3, 3, 3, '2025-02-01 11:00:00', 1),
    (4, 4, 4, 4, '2025-02-01 12:00:00', 2),
    (5, 5, 5, 5, '2025-02-02 09:00:00', 3);
INSERT INTO paciente_historia_clinica (
        id_paciente_historia_clinica,
        id_paciente,
        diagnostico,
        tratamiento,
        id_medico
    )
VALUES (
        1,
        1,
        'Hipertensión',
        'Medicamentos antihipertensivos',
        1
    ),
    (
        2,
        2,
        'Asma',
        'Inhaladores y control ambiental',
        2
    ),
    (
        3,
        3,
        'Migraña',
        'Analgésicos y control del estrés',
        3
    ),
    (
        4,
        4,
        'Fractura de pierna',
        'Inmovilización y fisioterapia',
        4
    ),
    (
        5,
        5,
        'Dermatitis',
        'Cremas tópicas',
        5
    );
INSERT INTO medicamento_tipo (id_medicamento_tipo, nombre_tipo)
VALUES (1, 'Analgesico'),
    (2, 'Antibiotico'),
    (3, 'Antiinflamatorio');
INSERT INTO medicamento (
        id_medicamento,
        nombre_comercial,
        nombre_quimico,
        concentracion,
        id_medicamento_tipo
    )
VALUES (1, 'Paracetamol', 'Acetaminofén', 500, 1),
    (
        2,
        'Amoxicilina',
        'Amoxicilina Trihidrato',
        250,
        2
    ),
    (3, 'Ibuprofeno', 'Ibuprofeno', 200, 3);
INSERT INTO receta_medica (
        id_receta_medica,
        id_turno,
        indicaciones
    )
VALUES (
        1,
        1,
        'Tomar 1 comprimido cada 8 horas'
    ),
    (
        2,
        2,
        'Tomar 1 comprimido cada 12 horas'
    );
INSERT INTO medicamento_recetado (
        id_medicamento_recetado,
        id_receta_medica,
        id_medicamento
    )
VALUES (1, 1, 1),
    (2, 2, 2);
INSERT INTO factura (
        id_factura,
        id_turno,
        monto_total,
        estado_pago
    )
VALUES (1, 1, 50.00, 'Pagado'),
    (2, 2, 75.00, 'Pendiente');
INSERT INTO pago_metodo (id_pago_metodo, nombre_metodo)
VALUES (1, 'Efectivo'),
    (2, 'Tarjeta de Crédito');
INSERT INTO pago (id_pago, id_factura, id_pago_metodo)
VALUES (1, 1, 1),
    (2, 2, 2);