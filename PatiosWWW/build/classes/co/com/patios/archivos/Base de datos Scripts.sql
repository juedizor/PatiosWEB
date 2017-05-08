drop table  if exists patio cascade;
drop table  if exists marca_vehiculo cascade;
drop table  if exists modelo_vehiculo cascade;
drop table  if exists vehiculo cascade;
drop table  if exists entrada_vehiculo_patio cascade;
drop table  if exists usuario cascade;
drop table if exists autorizacion_salida_patio cascade;
drop table if exists valor_patio cascade;
drop table if exists estado_vehiculo cascade;
drop table if exists consecutivo_volante cascade;
drop table if exists volante_patio cascade;
drop table if exists detalle_volante_patio cascade;
drop table if exists tipo_identificacion cascade;
drop table if exists usuario_patio cascade;



CREATE TABLE tipo_identificacion(
id_tipo_identificacion SERIAL NOT NULL,
tipo_identificacion INTEGER NOT NULL, 
descripcion_tipo_identificacion VARCHAR NOT NULL
);

ALTER TABLE tipo_identificacion ADD CONSTRAINT PK_id_tipo_identificacion
	PRIMARY KEY (tipo_identificacion)
;

ALTER TABLE tipo_identificacion
	ADD CONSTRAINT UQ_tipo_identificacion UNIQUE (tipo_identificacion)
;



CREATE TABLE usuario ( 
	id_usuario SERIAL NOT NULL,
	tipo_identificacion INTEGER NOT NULL,
	identificacion_usuario INTEGER NOT NULL,
	nombre_usuario VARCHAR(255) NOT NULL,
	apellido_usuario VARCHAR(255) NOT NULL,
	fecha_nacimiento_usuario DATE NOT NULL,
	clave_usuario VARCHAR(255) NOT NULL
)
;

ALTER TABLE usuario
	ADD CONSTRAINT UQ_usuario_identificacion_usuario UNIQUE (tipo_identificacion, identificacion_usuario)
;
ALTER TABLE usuario ADD CONSTRAINT PK_usuario 
	PRIMARY KEY (id_usuario)
;

ALTER TABLE usuario ADD CONSTRAINT FK_usuario_tipo_identificacion
	FOREIGN KEY (tipo_identificacion) REFERENCES tipo_identificacion (tipo_identificacion)
;



CREATE TABLE patio ( 
	id_patio SERIAL NOT NULL,
	codigo_patio VARCHAR(10) NOT NULL,
	nombre_patio VARCHAR(255) NOT NULL,
	direccion_patio VARCHAR(255) NOT NULL,
	telefono_patio BIGINT  NOT NULL,
	capacidad_patio INTEGER NOT NULL,
	fecha_registro_patio DATE NOT NULL,
	id_usuario INTEGER NOT NULL
)
;

ALTER TABLE patio ADD CONSTRAINT PK_patios 
	PRIMARY KEY (id_patio)
;

ALTER TABLE patio ADD CONSTRAINT FK_patio_usuario
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

CREATE TABLE usuario_patio(
id_usuario_patio SERIAL NOT NULL, 
id_usuario INTEGER NOT NULL, 
id_patio INTEGER NOT NULL, 
fecha_inicio DATE NOT NULL, 
fecha_final DATE 
);

ALTER TABLE usuario_patio ADD CONSTRAINT PK_usuario_patio
	PRIMARY KEY (id_usuario_patio)
;

ALTER TABLE usuario_patio ADD CONSTRAINT FK_usuario_patio_01
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE usuario_patio ADD CONSTRAINT FK_usuario_patio_02
	FOREIGN KEY (id_patio) REFERENCES patio (id_patio)
;


CREATE TABLE marca_vehiculo ( 
	id_marca_vehiculo serial NOT NULL,
	nombre_marca_vehiculo VARCHAR(255) NOT NULL
)
;

ALTER TABLE marca_vehiculo ADD CONSTRAINT PK_marca_vehiculo 
	PRIMARY KEY (id_marca_vehiculo)
;


CREATE TABLE modelo_vehiculo ( 
	id_modelo SERIAL NOT NULL,
	id_marca_vehiculo INTEGER NOT NULL, 
	modelo_vehiculo VARCHAR(255) NOT NULL,
	anio_modelo VARCHAR(4) NOT NULL
)
;

ALTER TABLE modelo_vehiculo ADD CONSTRAINT PK_modelo_vehiculo 
	PRIMARY KEY (id_modelo)
;

ALTER TABLE modelo_vehiculo ADD CONSTRAINT FK_marca_vehiculo_modelo 
	FOREIGN KEY (id_marca_vehiculo) REFERENCES marca_vehiculo (id_marca_vehiculo)
;


CREATE TABLE estado_vehiculo (
	id_estado_vehiculo serial NOT NULL, 
	codigo_alfa_estado_vehiculo CHAR(1) NOT NULL, 
	descripcion_estado_vehiculo VARCHAR NOT NULL
	

)
;

ALTER TABLE estado_vehiculo ADD CONSTRAINT PK_estado_vehiculo
	PRIMARY KEY (id_estado_vehiculo)
;


CREATE TABLE vehiculo ( 
	id_vehiculo SERIAL NOT NULL,
	id_marca_vehiculo INTEGER NOT NULL,
	id_modelo INTEGER NOT NULL,
	id_estado_vehiculo INTEGER NOT NULL,
	id_usuario INTEGER NOT NULL,
	placa_vehiculo VARCHAR(50) NOT NULL,
	numero_motor_vehiculo VARCHAR, 
	numero_chasis_vehiculo VARCHAR,
	numero_serie_vehiculo VARCHAR
	
)
;

ALTER TABLE vehiculo
	ADD CONSTRAINT UQ_vehiculo_placa_vehiculo UNIQUE (placa_vehiculo)
;
ALTER TABLE vehiculo ADD CONSTRAINT PK_vehiculo 
	PRIMARY KEY (id_vehiculo)
;


ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_modelo_vehiculo 
	FOREIGN KEY (id_modelo) REFERENCES modelo_vehiculo (id_modelo)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_marca_vehiculo 
	FOREIGN KEY (id_marca_vehiculo) REFERENCES marca_vehiculo (id_marca_vehiculo)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_estado
	FOREIGN KEY (id_estado_vehiculo) REFERENCES estado_vehiculo (id_estado_vehiculo)
;





CREATE TABLE entrada_vehiculo_patio ( 
	id_entrada_vehiculo_patio SERIAL NOT NULL,
	id_patio INTEGER NOT NULL,
	id_vehiculo INTEGER NOT NULL,
	id_usuario INTEGER NOT NULL,
	fecha_entrada_vehiculo DATE NOT NULL, 
	estado_entrada CHAR(1) not null
)
;

ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT PK_entrada_vehiculo_patio 
	PRIMARY KEY (id_entrada_vehiculo_patio)
;


ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT FK_entrada_vehiculo_patio_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT FK_entrada_vehiculo_patio_vehiculo 
	FOREIGN KEY (id_vehiculo) REFERENCES vehiculo (id_vehiculo)
;

ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT FK_entrada_vehiculo_patio_01 
	FOREIGN KEY (id_patio) REFERENCES patio (id_patio)
;

CREATE TABLE valor_patio (
	id_valor_patio SERIAL NOT NULL, 
	id_patio INTEGER NOT NULL, 
	fecha_desde_valor_patio DATE NOT NULL, 
	fecha_hasta_valor_patio DATE NOT NULL,
	tarifa_patio BIGINT NOT NULL
);


ALTER TABLE valor_patio ADD CONSTRAINT PK_valor_patio
	PRIMARY KEY (id_valor_patio)
;

ALTER TABLE valor_patio ADD CONSTRAINT FK_valor_patio_pat
	FOREIGN KEY (id_patio) REFERENCES patio (id_patio)
;



CREATE TABLE autorizacion_salida_patio(
	id_autorizacion_salida_patio SERIAL NOT NULL, 
	id_entrada_vehiculo_patio INTEGER NOT NULL, 
	fecha_salida_patio DATE NOT NULL, 
	observacion_salida_patio VARCHAR NOT NULL,
	id_usuario INTEGER NOT NULL
);


ALTER TABLE autorizacion_salida_patio ADD CONSTRAINT PK_autorizacion_salida_patio
	PRIMARY KEY (id_autorizacion_salida_patio)
;

ALTER TABLE autorizacion_salida_patio ADD CONSTRAINT FK_autorizacion_salida_patio_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE autorizacion_salida_patio ADD CONSTRAINT FK_autorizacion_salida_patio_entrada
	FOREIGN KEY (id_entrada_vehiculo_patio) REFERENCES entrada_vehiculo_patio (id_entrada_vehiculo_patio)
;


CREATE TABLE consecutivo_volante(
id_consecutivo_volante SERIAL NOT NULL, 
numero_volante INTEGER NOT NULL, 
fecha_consecutivo_volante DATE NOT NULL, 
id_usuario INTEGER NOT NULL
);

ALTER TABLE consecutivo_volante ADD CONSTRAINT PK_consecutivo_volante
	PRIMARY KEY (id_consecutivo_volante)
;

ALTER TABLE consecutivo_volante
	ADD CONSTRAINT UQ_numero_volante_fecha UNIQUE (numero_volante, fecha_consecutivo_volante)
;

ALTER TABLE consecutivo_volante ADD CONSTRAINT FK_consecutivo_volante
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;



CREATE TABLE volante_patio(
id_volante_patio SERIAL NOT NULL,
numero_volante INTEGER NOT NULL, 
fecha_volante DATE NOT NULL, 
id_entrada_vehiculo_patio integer NOT NULL
);

ALTER TABLE volante_patio ADD CONSTRAINT PK_id_volante_patio
	PRIMARY KEY (id_volante_patio)
;

ALTER TABLE volante_patio
	ADD CONSTRAINT UQ_volante_patio_id_fecha_volante UNIQUE (numero_volante, fecha_volante)
;

ALTER TABLE volante_patio ADD CONSTRAINT FK_id_entrada_vehiculo_patio
	FOREIGN KEY (id_entrada_vehiculo_patio) REFERENCES entrada_vehiculo_patio (id_entrada_vehiculo_patio)
;

ALTER TABLE volante_patio
	ADD CONSTRAINT UQ_volante_patio_id_fecha UNIQUE (numero_volante, fecha_volante)
;


CREATE TABLE detalle_volante_patio(
id_detalle_volante_patio SERIAL NOT NULL, 
id_volante_patio INTEGER NOT NULL, 
anio_liquidacion VARCHAR NOT NULL, 
dias_liquidacion INTEGER NOT NULL,
valor_liquidacion_anio DECIMAL NOT NULL, 
valor_liquidacion DECIMAL NOT NULL
);

ALTER TABLE detalle_volante_patio ADD CONSTRAINT PK_id_detalle_volante_patio
	PRIMARY KEY (id_detalle_volante_patio)
;

ALTER TABLE detalle_volante_patio ADD CONSTRAINT FK_detalle_volante_patio
	FOREIGN KEY (id_volante_patio) REFERENCES volante_patio (id_volante_patio)
;


CREATE TABLE organismo_transito(
id_organismo_transito SERIAL NOT NULL, 
divi_politica BIGINT NOT NULL,
nombre_organismo VARCHAR NOT NULL, 



);












