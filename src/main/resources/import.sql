/* Populate tables */
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Andres', 'Guzman','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('John', 'Doe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Linus', 'Torvalds','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Jane', 'Doe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Rasmus', 'Lerdorf','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Erich', 'Gamma','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Richard', 'Helm','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Ralph', 'Johnson','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('John', 'Vlissides','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('James', 'Gosling','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Bruce', 'Lee','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Johnny', 'Doe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('John', 'Roe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Jane', 'Roe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Richard', 'Doe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Janie', 'Doe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Phillip', 'Webb','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Stephane', 'Nicoll','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Sam', 'Brannen','una dirección', '7773636');  
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Juergen', 'Hoeller','una dirección', '7773636'); 
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Janie', 'Roe','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('John', 'Smith','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Joe', 'Bloggs','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('John', 'Stiles','una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES('Richard', 'Roe','una dirección', '7773636');

/* Populate tabla productos */
INSERT INTO productos (nombre,  precio, foto) VALUES('Panasonic Pantalla LCD', 259990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Sony Camara digital DSC-W320B', 123490, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Apple iPod shuffle', 1499990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Sony Notebook Z110', 37990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Hewlett Packard Multifuncional F2280', 100000, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Bianchi Bicicleta Aro 26', 69990, '');
INSERT INTO productos (nombre,  precio, foto) VALUES('Mica Comoda 5 Cajones', 299990, '');

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);
