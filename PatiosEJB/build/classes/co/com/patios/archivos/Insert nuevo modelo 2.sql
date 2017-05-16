INSERT INTO pais(id_pais, codigo_pais, descripcion_pais)
    VALUES (1, 90, 'Colombia');

INSERT INTO departamento(id_departamento, id_pais, codigo_departamento, 
            nombre_departamento)
    VALUES (1, 1,5,'ANTIOQUIA');

INSERT INTO ciudad(id_ciudad, id_departamento, codigo_div_politica, nombre_ciudad)
    VALUES (1, 1, 5001000, 'MEDELLIN');


-- TIPOS DE DOCUMENTOS DE IDENTIDAD

INSERT INTO tipo_identificacion(id_tipo_identificacion, codigo_tipo_identificacion,  descripcion_tipo_identificacion)
    VALUES (1, 'CC', 'CEDULA DE CIUDADANIA');

INSERT INTO tipo_identificacion(id_tipo_identificacion,codigo_tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (2, 'NIT' ,'NIT');

INSERT INTO tipo_identificacion(id_tipo_identificacion,codigo_tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (3, 'NN', 'NN');

INSERT INTO tipo_identificacion(id_tipo_identificacion,codigo_tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (4, 'PAS', 'PASAPORTE');

INSERT INTO tipo_identificacion(id_tipo_identificacion,codigo_tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (5, 'CE', 'CEDULA DE EXTRANJERIA');

INSERT INTO tipo_identificacion(id_tipo_identificacion,codigo_tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (6, 'TI', 'TARJETA DE IDENTIDAD');

INSERT INTO tipo_identificacion(id_tipo_identificacion,codigo_tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (7, 'RC', 'REGISTRO CIVIL');

INSERT INTO tipo_identificacion(id_tipo_identificacion,codigo_tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (8, 'CD', 'CARNET DIPLOMATICO');




INSERT INTO persona(id_tipo_identificacion, id_ciudad, numero_identificacion, 
            primer_nombre_persona, segundo_nombre_persona, primer_apellido_persona, 
            segundo_apellido_persona, nombre_comercial_persona, fecha_proceso)
    VALUES (1, 1, 1064991582, 
            'JULIO', 'EDUARDO', 'IZQUIERDO', 
            'OROZCO', '', CURRENT_DATE);


INSERT INTO usuario(id_persona, login_usuario, clave_usuario, estado_usuario)
    VALUES (1, 'julioizq', 'julio16', 'A');




INSERT INTO tipo_menu
values (1, 'P');
INSERT INTO tipo_menu
values (2, 'S');
INSERT INTO tipo_menu
values (3, 'I');


INSERT INTO menu 
values (1, 'GESTIONAR PATIOS', 1,  '');

INSERT INTO menu 
values (2, 'Patios', 2, '');

INSERT INTO menu 
values (3, 'Entrada a Patios', 3, '/jsf/patios/entradaPatios.xhtml');

INSERT INTO menu 
values (4, 'Registrar Patios', 3, '/jsf/patios/registrarPatio.xhtml');

INSERT INTO menu 
values (5, 'Asignar usuario a Patios', 3, '/jsf/patios/listadoPatios.xhtml');

INSERT INTO menu 
values (6, 'Usuarios', 2, '');

INSERT INTO menu 
values (7, 'Listado de Usuarios', 3, '');


INSERT INTO menu_item 
values (1, 1, 2);

INSERT INTO menu_item 
values (2, 2, 3);

INSERT INTO menu_item 
values (3, 2, 4);

INSERT INTO menu_item 
values (4, 2, 5);

INSERT INTO menu_item 
values (5, 1, 6);

INSERT INTO menu_item 
values (6, 6, 7);
