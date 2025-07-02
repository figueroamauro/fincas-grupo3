

-- ===================== ESTRUCTURA BASE DE LAS TABLAS =====================




--USUARIOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'usuarios' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE usuarios(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL,
	apellido NVARCHAR(50) NOT NULL,
	correo NVARCHAR(200) NOT NULL UNIQUE,
	contrasenia NVARCHAR(300) NOT NULL,
	telefono NVARCHAR(30) NOT NULL
);
END;


--ROLES
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'roles' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE roles(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--ROL_USUARIOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'rol_usuarios' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE  rol_usuarios(
	usuario_id BIGINT NOT NULL,
	rol_id BIGINT NOT NULL,
	PRIMARY KEY(usuario_id, rol_id)
);
END;


--FINCAS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'fincas' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE fincas(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL,
	descripcion NVARCHAR(3000),
	tarifa_hora DECIMAL(10,2),
	tarifa_dia DECIMAL(10,2)
);
END;


--FOTOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'fotos' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE fotos(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	url_imagen NVARCHAR(300) NOT NULL
);
END;


--HORARIOS_DISPONIBLES
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'horarios_disponibles' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE horarios_disponibles(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	dia_semana NVARCHAR(100) NOT NULL,
	hora_inicio TIME NOT NULL,
	hora_fin TIME NOT NULL
);
END;


--SERVICIOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'servicios' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE servicios(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--SERVICIO_OFRECIDO
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'servicio_ofrecido' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE  servicio_ofrecido(
	servicio_id BIGINT NOT NULL,
	finca_id BIGINT NOT NULL,
	PRIMARY KEY(servicio_id, finca_id)
);
END;


--DIRECCIONES
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'direcciones' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE direcciones(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	calle NVARCHAR(100) NOT NULL,
	numero NVARCHAR(10) NOT NULL,
	codigo_postal NVARCHAR(10)
);
END;


--PROVINCIAS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'provincias' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE provincias(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(100) NOT NULL UNIQUE
);
END;


--CIUDADES
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'ciudades' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE ciudades(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(100) NOT NULL
);
END;


--RESERVAS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'reservas' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
CREATE TABLE reservas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    fecha_inicio DATETIME NOT NULL,
    fecha_fin DATETIME NOT NULL,
    precio_total decimal(10,2) NOT NULL
);
END;


--TIPOS_RESERVA
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'tipos_reserva' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE tipos_reserva(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--ESTADOS_RESERVA
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'estados_reserva' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE estados_reserva(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--HISTORIAL_RESERVAS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'historial_reservas' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
CREATE TABLE historial_reservas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    fecha DATETIME NOT NULL,
);
END;


--FINCA_TIPO
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'finca_tipo' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE  finca_tipo(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	finca_id BIGINT NOT NULL,
	tipo_reserva_id BIGINT NOT NULL
);
END;


--DESCUENTOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'descuentos' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE descuentos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    cant_dias INT NOT NULL,
    porcentaje DECIMAL(3,1) NOT NULL
);
END;


--PUBLICACIONES
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'publicaciones' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
CREATE TABLE publicaciones (
    id BIGINT PRIMARY KEY IDENTITY (1,1),
    titulo NVARCHAR(100) NOT NULL,
    descripcion NVARCHAR(3000),
    fecha_creacion DATETIME NOT NULL,
    fecha_actualizacion DATETIME
);
END;


--ESTADOS_PUBLICACION
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'estados_publicacion' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE estados_publicacion(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--HISTORIAL_PUBLICACIONES
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'historial_publicaciones' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
CREATE TABLE historial_publicaciones (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    fecha DATETIME NOT NULL,
);
END;


--PAGOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'pagos' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
CREATE TABLE pagos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    monto DECIMAL(10,2) NOT NULL,
    fecha DATETIME NOT NULL
);
END;


--MEDIOS_PAGO
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'medios_pago' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE medios_pago(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--TIPOS_MONEDA
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'tipos_moneda' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE tipos_moneda(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--ESTADOS_PAGOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'estados_pago' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE estados_pago(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;


--HISTORIAL_PAGOS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'historial_pagos' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
CREATE TABLE historial_pagos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    fecha DATETIME NOT NULL,
);
END;


--FACTURAS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'facturas' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
CREATE TABLE facturas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    codigo_factura NVARCHAR(100) NOT NULL,
    fecha DATETIME NOT NULL,
    precio_total DECIMAL(10,2) NOT NULL
);
END;


--TIPOS_FACTURAS
IF NOT EXISTS (
    SELECT * FROM INFORMATION_SCHEMA.TABLES
    WHERE TABLE_NAME = 'tipos_facturas' AND TABLE_TYPE = 'BASE TABLE'
)
BEGIN
	CREATE TABLE tipos_facturas(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL UNIQUE
);
END;




-- ===================== FOREIGN KEYS =====================




--USUARIOS -> DIRECCION
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_usuarios_direcciones'
)
BEGIN
    ALTER TABLE usuarios
    ADD direccion_id bigint NOT NULL;

	ALTER TABLE usuarios
    ADD CONSTRAINT fk_usuarios_direcciones
    FOREIGN KEY (direccion_id)
    REFERENCES direcciones(id);
END;


--ROL_USUARIOS -> USUARIOS, ROL
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_usuario_rol_usuario'
    OR NAME = 'fk_usuario_rol_roles'
)
BEGIN
    ALTER TABLE rol_usuarios
    ADD CONSTRAINT fk_usuario_rol_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuarios(id),

    CONSTRAINT fk_usuario_rol_roles
    FOREIGN KEY (rol_id)
    REFERENCES roles(id);
END;



--FINCAS -> DIRECCIONES, USUARIOS
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_fincas_direcciones'
    OR NAME = 'fk_fincas_usuarios'
)
BEGIN
    ALTER TABLE fincas
    ADD direccion_id bigint NOT NULL;

	ALTER TABLE fincas
    ADD CONSTRAINT fk_fincas_direcciones
    FOREIGN KEY (direccion_id)
    REFERENCES direcciones(id);

	ALTER TABLE fincas
    ADD usuario_id bigint NOT NULL;

	ALTER TABLE fincas
    ADD CONSTRAINT fk_fincas_usuarios
    FOREIGN KEY (usuario_id)
    REFERENCES usuarios(id);
END;


--FOTOS -> FINCAS
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_fotos_fincas'
)
BEGIN
    ALTER TABLE fotos
    ADD finca_id bigint NOT NULL;

	ALTER TABLE fotos
    ADD CONSTRAINT fk_fotos_fincas
    FOREIGN KEY (finca_id)
    REFERENCES fincas(id);
END;


--HORARIOS_DISPONIBLES -> FINCAS
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_horarios_fincas'
)
BEGIN
    ALTER TABLE horarios_disponibles
    ADD finca_id bigint NOT NULL;

	ALTER TABLE horarios_disponibles
    ADD CONSTRAINT fk_horarios_fincas
    FOREIGN KEY (finca_id)
    REFERENCES fincas(id);
END;


--SERVICIO_OFRECIDO -> SERVICIO, FINCA
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_servicio_ofrecido_servicios'
    OR NAME = 'fk_servicio_ofrecido_fincas'
)
BEGIN
    ALTER TABLE servicio_ofrecido
    ADD CONSTRAINT fk_servicio_ofrecido_servicios
    FOREIGN KEY (servicio_id)
    REFERENCES servicios(id),

    CONSTRAINT fk_servicio_ofrecido_fincas
    FOREIGN KEY (finca_id)
    REFERENCES fincas(id);
END;



--CIUDADES -> PROVINCIAS
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_ciudades_provincias'
)
BEGIN
    ALTER TABLE ciudades
    ADD provincia_id bigint NOT NULL;

	ALTER TABLE ciudades
    ADD CONSTRAINT fk_ciudades_provincias
    FOREIGN KEY (provincia_id)
    REFERENCES provincias(id);
END;


--RESERVAS -> USUARIOS, FINCAS, TIPO_RESERVAS, ESTADO_RESERVAS
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_reservas_usuarios'
    OR NAME = 'fk_reservas_fincas'
    OR NAME = 'fk_reservas_tipo_reserva'
    OR NAME = 'fk_reservas_estados_reservas'
)
BEGIN
    ALTER TABLE reservas
    ADD usuario_id bigint NOT NULL;

 	ALTER TABLE reservas
    ADD CONSTRAINT fk_reservas_usuarios
    FOREIGN KEY (usuario_id)
    REFERENCES usuarios(id);

 	ALTER TABLE reservas
    ADD finca_id bigint NOT NULL;

 	ALTER TABLE reservas
    ADD CONSTRAINT fk_reservas_fincas
    FOREIGN KEY (finca_id)
    REFERENCES fincas(id);

 	ALTER TABLE reservas
    ADD tipo_reserva_id bigint NOT NULL;

    ALTER TABLE reservas
    ADD CONSTRAINT fk_reservas_tipo_reserva
    FOREIGN KEY (tipo_reserva_id)
    REFERENCES tipos_reserva(id);

    ALTER TABLE reservas
    ADD estado_id bigint NOT NULL;

    ALTER TABLE reservas
    ADD CONSTRAINT fk_reservas_estados_reservas
    FOREIGN KEY (estado_id)
    REFERENCES estados_reserva(id);
END;


--HISTORIAL_RESERVAS -> USUARIOS, RESERVAS, ESTADOS_RESERVA
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_historial_reservas_reservas'
    OR NAME = 'fk_historial_reservas_usuarios'
    OR NAME = 'fk_historial_reservas_estados_anterior'
    OR NAME = 'fk_historial_reservas_estados_actual'
)
BEGIN
    ALTER TABLE historial_reservas
    ADD reserva_id bigint NOT NULL;

	ALTER TABLE historial_reservas
    ADD CONSTRAINT fk_historial_reservas_reservas
    FOREIGN KEY (reserva_id)
    REFERENCES reservas(id);

	ALTER TABLE historial_reservas
    ADD usuario_id BIGINT NOT NULL;

	ALTER TABLE historial_reservas
    ADD CONSTRAINT fk_historial_reservas_usuarios
    FOREIGN KEY (usuario_id)
    REFERENCES usuarios(id);

	ALTER TABLE historial_reservas
    ADD estado_anterior_id BIGINT;

	ALTER TABLE historial_reservas
    ADD CONSTRAINT fk_historial_reservas_estados_anterior
    FOREIGN KEY (estado_anterior_id)
    REFERENCES estados_reserva(id);

	ALTER TABLE historial_reservas
    ADD estado_actual_id BIGINT;

	ALTER TABLE historial_reservas
    ADD CONSTRAINT fk_historial_reservas_estados_actual
    FOREIGN KEY (estado_actual_id)
    REFERENCES estados_reserva(id);
END;


--FINCA_TIPO -> TIPOS_RESERVA, FINCAS
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_finca_tipo_tipo_reserva'
    OR NAME = 'fk_finca_tipo_finca'
)
BEGIN
    ALTER TABLE finca_tipo
    ADD CONSTRAINT fk_finca_tipo_tipo_reserva
    FOREIGN KEY (tipo_reserva_id)
    REFERENCES tipos_reserva(id),

    CONSTRAINT fk_finca_tipo_finca
    FOREIGN KEY (finca_id)
    REFERENCES fincas(id);
END;



--DESCUENTOS -> FINCA_TIPO
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_descuentos_finca_tipo'
)
BEGIN
    ALTER TABLE descuentos
    ADD finca_tipo_id bigint NOT NULL;

	ALTER TABLE descuentos
    ADD CONSTRAINT fk_descuentos_finca_tipo
    FOREIGN KEY (finca_tipo_id)
    REFERENCES finca_tipo(id);
END;


--PUBLICACIONES -> FINCAS, ESTADOS_PUBLICACION
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_publicaciones_fincas'
    OR NAME = 'fk_publicaciones_estados_publicacion'
)
BEGIN
    ALTER TABLE publicaciones
    ADD finca_id bigint NOT NULL;

	ALTER TABLE publicaciones
    ADD CONSTRAINT fk_publicaciones_fincas
    FOREIGN KEY (finca_id)
    REFERENCES fincas(id);

	ALTER TABLE publicaciones
    ADD estado_id bigint NOT NULL;

	ALTER TABLE publicaciones
    ADD CONSTRAINT fk_publicaciones_estados_publicacion
    FOREIGN KEY (estado_id)
    REFERENCES estados_publicacion(id);
END;


--HISTORIAL_PUBLICACIONES -> PUBLICACIONES, ESTADOS_PUBLICACION
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_historial_publicaciones_estado_anterior'
    OR NAME = 'fk_historial_publicaciones_estado_actual'
    OR NAME = 'fk_historial_publicaciones_publicaciones'
)
BEGIN
	ALTER TABLE historial_publicaciones
    ADD publicacion_id BIGINT NOT NULL;

	ALTER TABLE historial_publicaciones
    ADD CONSTRAINT fk_historial_publicaciones_publicaciones
    FOREIGN KEY (publicacion_id)
    REFERENCES publicaciones(id);

	ALTER TABLE historial_publicaciones
    ADD estado_anterior_id BIGINT;

	ALTER TABLE historial_publicaciones
    ADD CONSTRAINT fk_historial_publicaciones_estado_anterior
    FOREIGN KEY (estado_anterior_id)
    REFERENCES estados_publicacion(id);

	ALTER TABLE historial_publicaciones
    ADD estado_actual_id BIGINT;

	ALTER TABLE historial_publicaciones
    ADD CONSTRAINT fk_historial_publicaciones_estado_actual
    FOREIGN KEY (estado_actual_id)
    REFERENCES estados_publicacion(id);
END;


--PAGOS -> ESTADOS_PAGO, MEDIOS_PAGO, TIPOS_MONEDA, RESERVAS
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_pagos_estados_pago'
    OR NAME = 'fk_pagos_medios_pago'
    OR NAME = 'fk_pagos_tipos_moneda'
    OR NAME = 'fk_pagos_reservas'
)
BEGIN
    ALTER TABLE pagos
    ADD estado_id bigint NOT NULL;

 	ALTER TABLE pagos
    ADD CONSTRAINT fk_pagos_estados_pago
    FOREIGN KEY (estado_id)
    REFERENCES estados_pago(id);

 	ALTER TABLE pagos
    ADD medio_pago_id bigint NOT NULL;

 	ALTER TABLE pagos
    ADD CONSTRAINT fk_pagos_medios_pago
    FOREIGN KEY (medio_pago_id)
    REFERENCES medios_pago(id);

 	ALTER TABLE pagos
    ADD tipo_moneda_id bigint NOT NULL;

    ALTER TABLE pagos
    ADD CONSTRAINT fk_pagos_tipos_moneda
    FOREIGN KEY (tipo_moneda_id)
    REFERENCES tipos_moneda(id);

    ALTER TABLE pagos
    ADD reserva_id bigint NOT NULL;

    ALTER TABLE pagos
    ADD CONSTRAINT fk_pagos_reservas
    FOREIGN KEY (reserva_id)
    REFERENCES reservas(id);
END;


--HISTORIAL_PAGOS -> PAGO, ESTADOS_PAGO
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_historial_pagos_pago'
    OR NAME = 'fk_historial_pagos_estado_anterior'
    OR NAME = 'fk_historial_pagos_estado_actual'
)
BEGIN
	ALTER TABLE historial_pagos
    ADD pago_id BIGINT NOT NULL;

	ALTER TABLE historial_pagos
    ADD CONSTRAINT fk_historial_pagos_pago
    FOREIGN KEY (pago_id)
    REFERENCES pagos(id);

	ALTER TABLE historial_pagos
    ADD estado_anterior_id BIGINT;

	ALTER TABLE historial_pagos
    ADD CONSTRAINT fk_historial_pagos_estado_anterior
    FOREIGN KEY (estado_anterior_id)
    REFERENCES estados_pago(id);

	ALTER TABLE historial_pagos
    ADD estado_actual_id BIGINT;

	ALTER TABLE historial_pagos
    ADD CONSTRAINT fk_historial_pagos_estado_actual
    FOREIGN KEY (estado_actual_id)
    REFERENCES estados_pago(id);
END;


--FACTURAS -> PAGOS, TIPOS_FACTURA
IF NOT EXISTS (
    SELECT * FROM sys.foreign_keys
    WHERE NAME = 'fk_facturas_pagos'
    OR NAME = 'fk_facturas_tipos_factura'
)
BEGIN
    ALTER TABLE facturas
    ADD pago_id bigint NOT NULL;

	ALTER TABLE facturas
    ADD CONSTRAINT fk_facturas_pagos
    FOREIGN KEY (pago_id)
    REFERENCES pagos(id);

	ALTER TABLE facturas
    ADD tipo_factura_id bigint NOT NULL;

	ALTER TABLE facturas
    ADD CONSTRAINT fk_facturas_tipos_factura
    FOREIGN KEY (tipo_factura_id)
    REFERENCES tipos_facturas(id);
END;


-- ===================== AGREGAR INDICES =====================


--USUARIOS POR NOMBRE
IF NOT EXISTS (
    SELECT * FROM sys.indexes
    WHERE NAME = 'idx_usuarios_nombre'
    AND object_id = OBJECT_ID('dbo.usuarios')
)
CREATE NONCLUSTERED INDEX idx_usuarios_nombre
ON usuarios(nombre);


--USUARIOS POR CORREO
IF NOT EXISTS (
    SELECT * FROM sys.indexes
    WHERE NAME = 'idx_usuarios_correo'
    AND object_id = OBJECT_ID('dbo.usuarios')
)
CREATE NONCLUSTERED INDEX idx_usuarios_correo
ON usuarios(correo);


--ROLES POR NOMBRE
IF NOT EXISTS (
    SELECT * FROM sys.indexes
    WHERE NAME = 'idx_roles_nombre'
    AND object_id = OBJECT_ID('dbo.roles')
)
CREATE NONCLUSTERED INDEX idx_roles_nombre
ON roles(nombre);


--FINCAS POR NOMBRE
IF NOT EXISTS (
    SELECT * FROM sys.indexes
    WHERE NAME = 'idx_fincas_nombre'
    AND object_id = OBJECT_ID('dbo.fincas')
)
CREATE NONCLUSTERED INDEX idx_fincas_nombre
ON fincas(nombre);


--RESERVAS POR ESTADO
IF NOT EXISTS (
    SELECT * FROM sys.indexes
    WHERE NAME = 'idx_reservas_estado'
    AND object_id = OBJECT_ID('dbo.reservas')
)
CREATE NONCLUSTERED INDEX idx_reservas_estado
ON reservas(estado_id);


--PUBLICACIONES POR ESTADO
IF NOT EXISTS (
    SELECT * FROM sys.indexes
    WHERE NAME = 'idx_publicaciones_estado'
    AND object_id = OBJECT_ID('dbo.publicaciones')
)
CREATE NONCLUSTERED INDEX idx_publicaciones_estado
ON publicaciones(estado_id);


--PAGOS POR ESTADO
IF NOT EXISTS (
    SELECT * FROM sys.indexes
    WHERE NAME = 'idx_pagos_estado'
    AND object_id = OBJECT_ID('dbo.pagos')
)
CREATE NONCLUSTERED INDEX idx_pagos_estado
ON pagos(estado_id);