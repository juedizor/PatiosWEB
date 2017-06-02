drop table  if exists entrada_vehiculo_patio cascade;
drop table  if exists estado_vehiculo cascade;
drop table  if exists modelo_vehiculo cascade;
drop table  if exists clase_vehiculo cascade;
drop table  if exists color_vehiculo cascade;
drop table  if exists marca_vehiculo cascade;
drop table  if exists vehiculo cascade;
drop table  if exists jurisdiccion_organismo_transito cascade;
drop table  if exists categoria_organismo_transito cascade;
drop table  if exists organismo_transito cascade;
drop table  if exists usuario_patio cascade;
drop table  if exists patio cascade;
drop table  if exists telefono_persona cascade;
drop table  if exists direccion_persona cascade;
drop table  if exists departamento cascade;
drop table  if exists pais cascade;
drop table  if exists ciudad cascade;
drop table  if exists persona cascade;
drop table  if exists usuario cascade;
drop table  if exists tipo_identificacion cascade;
drop table  if exists valor_patio cascade;
drop table if exists volante_patio cascade;
drop table if exists consecutivo_volante cascade;
drop table if exists detalle_volante_patio cascade;
drop table if exists tipo_menu cascade;
drop table if exists menu_item cascade;
drop table if exists menu cascade;



CREATE TABLE valor_patio ( 
	id_valor_patio serial NOT NULL,
	id_patio integer NOT NULL,
	id_clase_vehiculo integer NOT NULL,
	fecha_desde date NOT NULL,
	fecha_hasta date NOT NULL,
	valor_tarifa decimal(16) NOT NULL
)
;

CREATE TABLE entrada_vehiculo_patio ( 
	id_entrada_vehiculo_patio serial NOT NULL,
	id_patio integer NOT NULL,
	id_vehiculo integer NOT NULL,
	id_usuario integer NOT NULL,
	fecha_entrada_vehiculo timestamp NOT NULL,
	estado_entrada_vehiculo char(1) NOT NULL
)
;

CREATE TABLE estado_vehiculo ( 
	id_estado_vehiculo serial NOT NULL,
	codigo_alfa_estado_vehiculo char(1) NOT NULL,
	descripcion_estado_vehiculo varchar(255) NOT NULL
)
;

CREATE TABLE modelo_vehiculo ( 
	id_modelo_vehiculo serial NOT NULL,
	id_marca_vehiculo integer NOT NULL,
	modelo_vehiculo varchar(255) NOT NULL,
	anio_modelo_vehiculo bigint
)
;

CREATE TABLE clase_vehiculo ( 
	id_clase_vehiculo serial NOT NULL,
	codigo_clase_vehiculo integer NOT NULL,
	descripcion_clase_vehiculo varchar(50) NOT NULL
)
;

CREATE TABLE color_vehiculo ( 
	id_color_vehiculo serial NOT NULL,
	codigo_color_vehiculo integer NOT NULL,
	descripcion_color_vehiculo varchar(255) NOT NULL
)
;

CREATE TABLE marca_vehiculo ( 
	id_marca_vehiculo serial NOT NULL,
	codigo_marca_vehiculo bigint NOT NULL,
	descripcion_marca_vehiculo varchar(255) NOT NULL
)
;

CREATE TABLE vehiculo ( 
	id_vehiculo serial NOT NULL,
	id_clase_vehiculo integer NOT NULL,
	id_color_vehiculo integer NOT NULL,
	id_modelo_vehiculo integer NOT NULL,
	id_organismo_transito integer,
	id_estado_vehiculo integer NOT NULL,
	id_persona integer,
	placa_vehiculo varchar(255) NOT NULL,
	numero_motor_vehiculo varchar(255),
	numero_serie_vehiculo varchar(255),
	numero_chasis_vehiculo varchar(255),
	fecha_proceso timestamp NOT NULL,
	id_usuario integer NOT NULL
)
;

CREATE TABLE jurisdiccion_organismo_transito ( 
	id_jurisdiccion_organismo_transito serial NOT NULL,
	jurisdiccion_organismo_transito varchar(255) NOT NULL
)
;

CREATE TABLE categoria_organismo_transito ( 
	id_categoria_organismo_transito serial NOT NULL,
	categoria_organismo char(1) NOT NULL
)
;

CREATE TABLE organismo_transito ( 
	id_organismo_transito serial NOT NULL,
	codigo_division_politica bigint NOT NULL,
	nombre_organismo_transito varchar(255) NOT NULL,
	nombre_abreviado varchar(255) NOT NULL,
	id_ciudad integer NOT NULL,
	id_categoria_organismo_transito integer NOT NULL,
	id_jurisdiccion_organismo_transito integer NOT NULL,
	estado_organismo_transito char(1) NOT NULL,
	fecha_proceso timestamp NOT NULL,
	id_usuario integer NOT NULL
)
;

CREATE TABLE usuario_patio ( 
	id_usuario_patio serial NOT NULL,
	id_usuario integer NOT NULL,
	id_patio integer NOT NULL,
	fecha_inicio date NOT NULL,
	fecha_final date,
	fecha_proceso timestamp NOT NULL,
	id_usuario_asigna integer NOT NULL
)
;


CREATE TABLE patio ( 
	id_patio serial NOT NULL,
	codigo_patio varchar(255) NOT NULL,
	nombre_patio varchar(255) NOT NULL,
	direccion_patio varchar(255) NOT NULL,
	telefono_patio varchar(255) NOT NULL,
	capacidad_patio integer NOT NULL,
	fecha_registro_patio timestamp NOT NULL,
	id_usuario integer NOT NULL
)
;

CREATE TABLE telefono_persona ( 
	id_telefono_persona serial NOT NULL,
	id_persona integer NOT NULL,
	numero_telefono_persona varchar(255) NOT NULL,
	fecha_proceso timestamp NOT NULL,
	id_usuario integer NOT NULL
)
;

CREATE TABLE direccion_persona ( 
	id_direccion_persona serial NOT NULL,
	id_persona integer NOT NULL,
	descripcion_direccion varchar(255) NOT NULL,
	fecha_inicio_direccion date NOT NULL,
	fecha_final_direccion date,
	fecha_proceso timestamp NOT NULL,
	id_usuario integer NOT NULL
)
;

CREATE TABLE departamento ( 
	id_departamento integer NOT NULL,
	id_pais integer NOT NULL,
	codigo_departamento integer NOT NULL,
	nombre_departamento varchar(255) NOT NULL
)
;

CREATE TABLE ciudad ( 
	id_ciudad integer NOT NULL,
	id_departamento integer NOT NULL,
	codigo_div_politica bigint NOT NULL,
	nombre_ciudad varchar(255) NOT NULL
)
;

CREATE TABLE pais ( 
	id_pais integer NOT NULL,
	codigo_pais integer NOT NULL,
	descripcion_pais varchar(255) NOT NULL
)
;

CREATE TABLE persona ( 
	id_persona serial NOT NULL,
	id_tipo_identificacion integer NOT NULL,	
	numero_identificacion decimal(16) NOT NULL,
	primer_nombre_persona varchar(255) NOT NULL,
	segundo_nombre_persona varchar(255),
	primer_apellido_persona varchar(255) NOT NULL,
	segundo_apellido_persona varchar(255),
	nombre_comercial_persona varchar(255),
	id_ciudad integer NOT NULL,
	fecha_proceso timestamp NOT NULL
)
;

CREATE TABLE usuario ( 
	id_usuario serial NOT NULL,
	id_persona integer NOT NULL,
	login_usuario varchar(255) NOT NULL,
	clave_usuario varchar(255) NOT NULL,
	estado_usuario char(1) NOT NULL
)
;

CREATE TABLE tipo_menu(
	id_tipo_menu INTEGER NOT NULL, 
	tipo VARCHAR NOT NULL
);

ALTER TABLE tipo_menu ADD CONSTRAINT PK_tipo_menu
	PRIMARY KEY (id_tipo_menu)
;

CREATE TABLE menu (
	id_menu INTEGER NOT NULL, 
	nombre_menu VARCHAR NOT NULL, 
	id_tipo_menu INTEGER NOT NULL, 
	url VARCHAR

);

ALTER TABLE menu ADD CONSTRAINT PK_menu
	PRIMARY KEY (id_menu)
;

ALTER TABLE menu ADD CONSTRAINT FK_menu_tipo_menu
	FOREIGN KEY (id_tipo_menu) REFERENCES tipo_menu (id_tipo_menu)
;

CREATE TABLE menu_item (
	id_menu_item INTEGER NOT NULL, 
	id_menu_principal INTEGER NOT NULL, 
	id_menu_secundario INTEGER NOT NULL 
	
);

ALTER TABLE menu_item ADD CONSTRAINT PK_menu_item
	PRIMARY KEY (id_menu_item)
;

ALTER TABLE menu_item ADD CONSTRAINT FK_menu_item_menu_01
	FOREIGN KEY (id_menu_principal) REFERENCES menu (id_menu)
;

ALTER TABLE menu_item ADD CONSTRAINT FK_menu_item_menu_02
	FOREIGN KEY (id_menu_secundario) REFERENCES menu (id_menu)
;


CREATE TABLE tipo_identificacion ( 
	id_tipo_identificacion integer NOT NULL,
	codigo_tipo_identificacion varchar not null,
	descripcion_tipo_identificacion varchar(255) NOT NULL
)
;

CREATE TABLE consecutivo_volante ( 
	id_consecutivo_volante serial NOT NULL,
	numero_volante integer NOT NULL,
	fecha_consecutivo_volante timestamp NOT NULL,
	id_usuario integer
)
;

CREATE TABLE volante_patio ( 
	id_volante_patio serial NOT NULL,
	numero_volante integer NOT NULL,
	fecha_volante timestamp NOT NULL,
	id_entrada_vehiculo_patio integer NOT NULL,
	id_usuario integer
)
;

CREATE TABLE detalle_volante_patio ( 
	id_detalle_volante_patio serial NOT NULL,
	id_volante_patio integer NOT NULL,
	anio_liquidacion varchar(4) NOT NULL,
	dias_liquidacion integer NOT NULL,
	valor_liquidacion_anio decimal(16) NOT NULL,
	valor_liquidacion decimal(16) NOT NULL,
	id_usuario integer NOT NULL
)
;


ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT PK_entrada_vehiculo_patio 
	PRIMARY KEY (id_entrada_vehiculo_patio)
;


ALTER TABLE estado_vehiculo ADD CONSTRAINT PK_estado_vehiculo 
	PRIMARY KEY (id_estado_vehiculo)
;


ALTER TABLE modelo_vehiculo ADD CONSTRAINT PK_modelo_vehiculo 
	PRIMARY KEY (id_modelo_vehiculo)
;


ALTER TABLE clase_vehiculo ADD CONSTRAINT PK_clase_vehiculo 
	PRIMARY KEY (id_clase_vehiculo)
;


ALTER TABLE color_vehiculo ADD CONSTRAINT PK_color_vehiculo 
	PRIMARY KEY (id_color_vehiculo)
;


ALTER TABLE marca_vehiculo ADD CONSTRAINT PK_marca_vehiculo 
	PRIMARY KEY (id_marca_vehiculo)
;


ALTER TABLE vehiculo ADD CONSTRAINT PK_vehiculo 
	PRIMARY KEY (id_vehiculo)
;


ALTER TABLE jurisdiccion_organismo_transito ADD CONSTRAINT PK_jurisdiccion_organismo_transito 
	PRIMARY KEY (id_jurisdiccion_organismo_transito)
;


ALTER TABLE categoria_organismo_transito ADD CONSTRAINT PK_categoria_organismo_transito 
	PRIMARY KEY (id_categoria_organismo_transito)
;


ALTER TABLE organismo_transito ADD CONSTRAINT PK_organismo_transito 
	PRIMARY KEY (id_organismo_transito)
;


ALTER TABLE usuario_patio ADD CONSTRAINT PK_usuario_patio 
	PRIMARY KEY (id_usuario_patio)
;


ALTER TABLE patio ADD CONSTRAINT PK_patio 
	PRIMARY KEY (id_patio)
;


ALTER TABLE telefono_persona ADD CONSTRAINT PK_telefono_persona 
	PRIMARY KEY (id_telefono_persona)
;


ALTER TABLE direccion_persona ADD CONSTRAINT PK_direccion_persona 
	PRIMARY KEY (id_direccion_persona)
;


ALTER TABLE departamento ADD CONSTRAINT PK_departamento 
	PRIMARY KEY (id_departamento)
;


ALTER TABLE ciudad ADD CONSTRAINT PK_Ciudad 
	PRIMARY KEY (id_ciudad)
;


ALTER TABLE pais ADD CONSTRAINT PK_paises 
	PRIMARY KEY (id_pais)
;


ALTER TABLE persona ADD CONSTRAINT PK_persona 
	PRIMARY KEY (id_persona)
;


ALTER TABLE usuario ADD CONSTRAINT PK_usuario 
	PRIMARY KEY (id_usuario)
;


ALTER TABLE tipo_identificacion ADD CONSTRAINT PK_tipo_identificacion 
	PRIMARY KEY (id_tipo_identificacion)
;



ALTER TABLE clase_vehiculo
	ADD CONSTRAINT UQ_clase_vehiculo_codigo_clase_vehiculo UNIQUE (codigo_clase_vehiculo)
;
ALTER TABLE color_vehiculo
	ADD CONSTRAINT UQ_color_vehiculo_codigo_color_vehiculo UNIQUE (codigo_color_vehiculo)
;
ALTER TABLE marca_vehiculo
	ADD CONSTRAINT UQ_marca_vehiculo_codigo_marca_vehiculo UNIQUE (codigo_marca_vehiculo)
;
ALTER TABLE vehiculo
	ADD CONSTRAINT UQ_vehiculo_placa_vehiculo UNIQUE (placa_vehiculo)
;
ALTER TABLE patio
	ADD CONSTRAINT UQ_patio_codigo_patio UNIQUE (codigo_patio)
;
ALTER TABLE pais
	ADD CONSTRAINT UQ_paises_codigo_pais UNIQUE (codigo_pais)
;
ALTER TABLE persona
	ADD CONSTRAINT UQ_persona_numero_identificacion UNIQUE (numero_identificacion)
;
ALTER TABLE usuario
	ADD CONSTRAINT UQ_usuario_login_usuario UNIQUE (login_usuario)
;

ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT FK_entrada_vehiculo_patio_patio 
	FOREIGN KEY (id_patio) REFERENCES patio (id_patio)
;

ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT FK_entrada_vehiculo_patio_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE entrada_vehiculo_patio ADD CONSTRAINT FK_entrada_vehiculo_patio_vehiculo 
	FOREIGN KEY (id_vehiculo) REFERENCES vehiculo (id_vehiculo)
;

ALTER TABLE modelo_vehiculo ADD CONSTRAINT FK_modelo_vehiculo_marca_vehiculo 
	FOREIGN KEY (id_marca_vehiculo) REFERENCES marca_vehiculo (id_marca_vehiculo)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_clase_vehiculo 
	FOREIGN KEY (id_clase_vehiculo) REFERENCES clase_vehiculo (id_clase_vehiculo)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_color_vehiculo 
	FOREIGN KEY (id_color_vehiculo) REFERENCES color_vehiculo (id_color_vehiculo)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_estado_vehiculo 
	FOREIGN KEY (id_estado_vehiculo) REFERENCES estado_vehiculo (id_estado_vehiculo)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_modelo_vehiculo 
	FOREIGN KEY (id_modelo_vehiculo) REFERENCES modelo_vehiculo (id_modelo_vehiculo)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_organismo_transito 
	FOREIGN KEY (id_organismo_transito) REFERENCES organismo_transito (id_organismo_transito)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_persona 
	FOREIGN KEY (id_persona) REFERENCES persona (id_persona)
;

ALTER TABLE vehiculo ADD CONSTRAINT FK_vehiculo_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE organismo_transito ADD CONSTRAINT FK_organismo_transito_categoria_organismo_transito 
	FOREIGN KEY (id_categoria_organismo_transito) REFERENCES categoria_organismo_transito (id_categoria_organismo_transito)
;

ALTER TABLE organismo_transito ADD CONSTRAINT FK_organismo_transito_ciudad 
	FOREIGN KEY (id_ciudad) REFERENCES ciudad (id_ciudad)
;

ALTER TABLE organismo_transito ADD CONSTRAINT FK_organismo_transito_jurisdiccion_organismo_transito 
	FOREIGN KEY (id_jurisdiccion_organismo_transito) REFERENCES jurisdiccion_organismo_transito (id_jurisdiccion_organismo_transito)
;

ALTER TABLE organismo_transito ADD CONSTRAINT FK_organismo_transito_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE usuario_patio ADD CONSTRAINT FK_usuario_patio_01 
	FOREIGN KEY (id_patio) REFERENCES patio (id_patio)
;

ALTER TABLE usuario_patio ADD CONSTRAINT FK_usuario_patio_02 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE usuario_patio ADD CONSTRAINT FK_usuario_patio_03 
	FOREIGN KEY (id_usuario_asigna) REFERENCES usuario (id_usuario)
;

ALTER TABLE patio ADD CONSTRAINT FK_patio_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE telefono_persona ADD CONSTRAINT FK_telefono_persona_persona 
	FOREIGN KEY (id_persona) REFERENCES persona (id_persona)
;

ALTER TABLE telefono_persona ADD CONSTRAINT FK_telefono_persona_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE direccion_persona ADD CONSTRAINT FK_direccion_persona_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE direccion_persona ADD CONSTRAINT FK_direccion_persona_01 
	FOREIGN KEY (id_persona) REFERENCES persona (id_persona)
;

ALTER TABLE departamento ADD CONSTRAINT FK_departamento_pais 
	FOREIGN KEY (id_pais) REFERENCES pais (id_pais)
;

ALTER TABLE ciudad ADD CONSTRAINT FK_Ciudad_departamento 
	FOREIGN KEY (id_departamento) REFERENCES departamento (id_departamento)
;

ALTER TABLE persona ADD CONSTRAINT FK_persona_ciudad 
	FOREIGN KEY (id_ciudad) REFERENCES ciudad (id_ciudad)
;

ALTER TABLE persona ADD CONSTRAINT FK_persona_tipo_identificacion 
	FOREIGN KEY (id_tipo_identificacion) REFERENCES tipo_identificacion (id_tipo_identificacion)
;

ALTER TABLE usuario ADD CONSTRAINT FK_usuario_persona 
	FOREIGN KEY (id_persona) REFERENCES persona (id_persona)
;
ALTER TABLE valor_patio ADD CONSTRAINT PK_valor_patio 
	PRIMARY KEY (id_valor_patio)
;


ALTER TABLE valor_patio ADD CONSTRAINT FK_valor_patio_clase_vehiculo 
	FOREIGN KEY (id_clase_vehiculo) REFERENCES clase_vehiculo (id_clase_vehiculo)
;

ALTER TABLE valor_patio ADD CONSTRAINT FK_valor_patio_patio 
	FOREIGN KEY (id_patio) REFERENCES patio (id_patio)
;

ALTER TABLE consecutivo_volante
	ADD CONSTRAINT UQ_consecutivo_volante_numero_volante UNIQUE (numero_volante, fecha_consecutivo_volante)
;
ALTER TABLE consecutivo_volante ADD CONSTRAINT PK_consecutivo_volante 
	PRIMARY KEY (id_consecutivo_volante)
;


ALTER TABLE consecutivo_volante ADD CONSTRAINT FK_consecutivo_volante_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE volante_patio
	ADD CONSTRAINT UQ_volante_patio_numero_volante UNIQUE (numero_volante, fecha_volante)
;
ALTER TABLE volante_patio ADD CONSTRAINT PK_volante_patio 
	PRIMARY KEY (id_volante_patio)
;


ALTER TABLE volante_patio ADD CONSTRAINT FK_volante_patio_entrada_vehiculo_patio 
	FOREIGN KEY (id_entrada_vehiculo_patio) REFERENCES entrada_vehiculo_patio (id_entrada_vehiculo_patio)
;

ALTER TABLE volante_patio ADD CONSTRAINT FK_volante_patio_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE detalle_volante_patio ADD CONSTRAINT PK_detalle_volante_patio 
	PRIMARY KEY (id_detalle_volante_patio)
;


ALTER TABLE detalle_volante_patio ADD CONSTRAINT FK_detalle_volante_patio_usuario 
	FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
;

ALTER TABLE detalle_volante_patio ADD CONSTRAINT FK_detalle_volante_patio_volante_patio 
	FOREIGN KEY (id_volante_patio) REFERENCES volante_patio (id_volante_patio)
;