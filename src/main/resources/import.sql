/* Populate tables */
INSERT INTO clientes (telefono, nombre, direccion, empresa, create_at) VALUES('7355586', 'Andrés Guzman','una dirección', 'Don Pollo', NOW());


/* Populate tabla productos */
INSERT INTO productos (nombre,  precio, foto) VALUES('Panasonic Pantalla LCD', 259990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Sony Camara digital DSC-W320B', 123490, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Apple iPod shuffle', 1499990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Sony Notebook Z110', 37990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Hewlett Packard Multifuncional F2280', 100000, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Bianchi Bicicleta Aro 26', 69990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Mica Comoda 5 Cajones', 299990, '');

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, clientef_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, clientef_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);
