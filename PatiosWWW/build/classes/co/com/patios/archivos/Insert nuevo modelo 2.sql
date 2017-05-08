INSERT INTO pais(codigo_pais, descripcion_pais)
    VALUES (90, 'Colombia');

INSERT INTO departamento(id_pais, codigo_departamento, 
            nombre_departamento)
    VALUES (1,5,'ANTIOQUIA');

INSERT INTO ciudad(id_departamento, codigo_div_politica, nombre_ciudad)
    VALUES (1, 5001000, 'MEDELLIN');


-- TIPOS DE DOCUMENTOS DE IDENTIDAD

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (1, 'CEDULA DE CIUDADANIA');

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (2, 'NIT');

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (3, 'NN');

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (4, 'PASAPORTE');

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (5, 'CEDULA DE EXTRANJERIA');

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (6, 'TARJETA DE IDENTIDAD');

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (7, 'REGISTRO CIVIL');

INSERT INTO tipo_identificacion(tipo_identificacion, descripcion_tipo_identificacion)
    VALUES (8, 'CARNET DIPLOMATICO');




INSERT INTO persona(id_tipo_identificacion, id_ciudad, numero_identificacion, 
            primer_nombre_persona, segundo_nombre_persona, primer_apellido_persona, 
            segundo_apellido_persona, nombre_comercial_persona, fecha_proceso)
    VALUES (1, 1, 1064991582, 
            'JULIO', 'EDUARDO', 'IZQUIERDO', 
            'OROZCO', '', CURRENT_DATE);


INSERT INTO usuario(id_persona, login_usuario, clave_usuario, estado_usuario)
    VALUES (1, 'julioizq', 'julio16', 'A');





  