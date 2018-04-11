/* Poblando tablas*/
/*Creando zonas*/
INSERT INTO zonas (nombre, precio_envio) VALUES ('Z001',1000);

/*Creando estados*/
INSERT INTO estados (descripcion) VALUES ('Pendiente');
INSERT INTO estados (descripcion) VALUES ('Producción');
INSERT INTO estados (descripcion) VALUES ('Despachado');
INSERT INTO estados (descripcion) VALUES ('Entregado');
INSERT INTO estados (descripcion) VALUES ('Incidencia');
INSERT INTO estados (descripcion) VALUES ('Cancelado');
INSERT INTO estados (descripcion) VALUES ('Erróneo');

/* Creando productos*/
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Panasonic Pantalla LCD','Una descripción detallada del producto', 259990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Sony Camara digital DSC-W320B','Una descripción detallada del producto', 123490, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Apple iPod shuffle', 'Una descripción detallada del producto',1499990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Sony Notebook Z110','Una descripción detallada del producto', 37990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Hewlett Packard Multifuncional F2280', 'Una descripción detallada del producto',100000, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Bianchi Bicicleta Aro 26','Una descripción detallada del producto', 69990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Mica Comoda 5 Cajones', 'Una descripción detallada del producto',299990, '');




/*Creando direcciones*/
INSERT INTO direcciones (tipo_direccion, numero1, numero2, numero3, tipo_residencia, barrio, zonaid_nombre) VALUES ('Kra', '19', '22N', '81', 'Altos del bosque apto 301B','Laureles', 'Z001' )




/*Creando clientes*/
INSERT INTO clientes (telefono, nombre, direccion_id, empresa, create_at, resenia) VALUES (3053772423, 'Julián Guerrero', 1, 'UQ', NOW(), 'Una reseña')

