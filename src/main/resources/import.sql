/* Populate tables */
INSERT INTO clientes (telefono, nombre, direccion, empresa, create_at) VALUES('7355586', 'Andrés Guzman','una dirección', 'Don Pollo', NOW());


/* Populate tabla productos */
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Panasonic Pantalla LCD','Una descripción detallada del producto', 259990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Sony Camara digital DSC-W320B','Una descripción detallada del producto', 123490, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Apple iPod shuffle', 'Una descripción detallada del producto',1499990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Sony Notebook Z110','Una descripción detallada del producto', 37990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Hewlett Packard Multifuncional F2280', 'Una descripción detallada del producto',100000, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Bianchi Bicicleta Aro 26','Una descripción detallada del producto', 69990, '');
INSERT INTO productos (nombre, descripcion,  precio, foto) VALUES('Mica Comoda 5 Cajones', 'Una descripción detallada del producto',299990, '');

/*Creando los estados*/
INSERT INTO estados (descripcion) VALUES ('Pendiente');
INSERT INTO estados (descripcion) VALUES ('Producción');
INSERT INTO estados (descripcion) VALUES ('Despachado');
INSERT INTO estados (descripcion) VALUES ('Entregado');
INSERT INTO estados (descripcion) VALUES ('Incidencia');
INSERT INTO estados (descripcion) VALUES ('Cancelado');

/* Creamos algunas facturas */
INSERT INTO facturas (observacion, creado, estado, entregado, clientef_id) VALUES('Alguna nota importante!',NOW(), 'Recibido', null,1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 1, 6);
