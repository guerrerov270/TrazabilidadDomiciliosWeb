/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-01', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('John', 'Doe', 'john.doe@gmail.com', '2017-08-02', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2017-08-03', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '2017-08-04', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2017-08-05', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2017-08-06', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2017-08-07', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2017-08-08', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2017-08-09', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('James', 'Gosling', 'james.gosling@gmail.com', '2017-08-010', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Bruce', 'Lee', 'bruce.lee@gmail.com', '2017-08-11', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Johnny', 'Doe', 'johnny.doe@gmail.com', '2017-08-12', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('John', 'Roe', 'john.roe@gmail.com', '2017-08-13', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Jane', 'Roe', 'jane.roe@gmail.com', '2017-08-14', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Richard', 'Doe', 'richard.doe@gmail.com', '2017-08-15', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Janie', 'Doe', 'janie.doe@gmail.com', '2017-08-16', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Phillip', 'Webb', 'phillip.webb@gmail.com', '2017-08-17', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Stephane', 'Nicoll', 'stephane.nicoll@gmail.com', '2017-08-18', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Sam', 'Brannen', 'sam.brannen@gmail.com', '2017-08-19', '', 'una dirección', '7773636');  
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Juergen', 'Hoeller', 'juergen.Hoeller@gmail.com', '2017-08-20', '', 'una dirección', '7773636'); 
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Janie', 'Roe', 'janie.roe@gmail.com', '2017-08-21', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('John', 'Smith', 'john.smith@gmail.com', '2017-08-22', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Joe', 'Bloggs', 'joe.bloggs@gmail.com', '2017-08-23', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('John', 'Stiles', 'john.stiles@gmail.com', '2017-08-24', '', 'una dirección', '7773636');
INSERT INTO clientes (nombre, apellido, email, create_at, foto, direccion, telefono) VALUES('Richard', 'Roe', 'stiles.roe@gmail.com', '2017-08-25', '', 'una dirección', '7773636');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);
