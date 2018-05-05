INSERT INTO `productos` VALUES (1,'',' ','Pollo asado',20900),(2,'',' ','Medio asado',10600),(3,'',' ','Cuarto asado',6200),(4,'',' ','Familiar asado',26600),(5,'',' ','Broaster entero',22600),(6,'',' ','Familiar broaster',28600),(7,'',' ','Medio broaster',11600),(8,'',' ','Cuarto broaster',6200),(9,'',' ','Arroz con pollo',21900),(10,'',' ','Medio arroz con pollo',11500),(11,'',' ','Pechuga a la parrilla',18000),(12,'',' ','Carne asada',18000),(13,'',' ','Churrasco',19000),(14,'',' ','Sobrebarriga',18000),(15,'',' ','Chuleta cerdo',18000),(16,'',' ','Chuleta pollo',18000),(17,'',' ','Chuleta pez',18000),(18,'',' ','Sopa menudencias',6400),(19,'',' ','Consomé',5000),(20,'',' ','Porcion frijoles',4500),(21,'',' ','Porcion arroz',3000),(22,'',' ','Porcion ensalada',5000),(23,'',' ','Porcion francesa/yuca',5000),(24,'',' ','Porcion arepas',3000),(25,'',' ','Porcio papa',3000),(26,'',' ','Gaseosa 350 cc.',2600),(27,'',' ','Mr Tea',2800),(28,'',' ','Gaseosa Mega',6200),(29,'',' ','Gaseosa 3 litros',7500),(30,'',' ','Agua botella',2600),(31,'',' ','Cerveza',3500),(32,'',' ','Milo frio',3500),(33,'',' ','Milo caliente',3000),(34,'',' ','Jugo leche',3800),(35,'',' ','Jugo agua',3500),(36,'',' ','Limonada natural',3500),(37,'',' ','Café en leche',1800),(38,'',' ','Gaseosa 600 cc.',3000),(39,'',' ','Mojarra',19000),(40,'',' ','Gaseosa litro/2 litros',4200),(41,'',' ','Bandeja pollo asado',10000),(42,'',' ','Bandeja filete pollo',10000),(43,'',' ','Desechables',500),(44,'',' ','Bandeja filete pez',10000),(45,'',' ','Bandeja filete cerdo',10000),(46,'',' ','Bandeja carne asada',10000),(47,'',' ','Bandeja pollo broaster',10000),(48,'',' ','Bagre',18000),(49,'',' ','Trucha',18000),(50,'',' ','Combo pollo asado',8000),(51,'',' ','Combo pollo broaster',8000),(52,'',' ','Combo infantil',8000),(53,'',' ','Maduro con queso',5500),(54,'',' ','Porcion patacón',5000),(55,'',' ','Consomé pequeño',3500),(56,'',' ','Muslitos',7500),(57,'',' ','Nuggets',8000),(58,'',' ','Combo chispa',29900),(59,'',' ','Serlog Pollo asado',10000),(60,'',' ','Tinto',1200),(61,'',' ','Serlog Carne',10000),(62,'',' ','Serlog fil.Pollo',10000),(63,'',' ','Serlog fil.Cerdo',10000),(64,'',' ','Serlog fil.Pez',10000);

INSERT INTO `role` VALUES (1,'ADMIN');
INSERT INTO `role` VALUES (2,'RECEP');
INSERT INTO `role` VALUES (3,'DOMI');

INSERT INTO `user` VALUES (1,1,'rocio@email.com','Jaimes','Rocío','$2a$10$kBNYnE1Dxq1cKm4KrHFaKO27O3riuvzhXtFRCBuvyuXN6DETaHy9e'),(3,1,'willman@email.com','Montoya','Willman','$2a$10$wuRKVAXjMVxR/phGWPZFd.sa7K9V/CU9m66MKthTk2kS7Q7pKvcHe'),(2,1,'diego@email.com','Ortiz','Diego','$2a$10$IItX5GR3hoQPcCXAlJRW6uXBWWVUUELCoTjSdoh8br9XSBn9u9BYK');

INSERT INTO `user_role` VALUES (1,1),(3,2),(2,3);

INSERT INTO estados (descripcion) VALUES ('Pendiente');
INSERT INTO estados (descripcion) VALUES ('Producción');
INSERT INTO estados (descripcion) VALUES ('Despachado');
INSERT INTO estados (descripcion) VALUES ('Entregado');
INSERT INTO estados (descripcion) VALUES ('Incidencia');
INSERT INTO estados (descripcion) VALUES ('Cancelado');
INSERT INTO estados (descripcion) VALUES ('Erróneo');

INSERT INTO zonas(nombre, precio_envio) VALUES ('Z00',0);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z10',1000);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z15',1500);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z20',2000);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z25',2500);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z30',3000);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z35',3500);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z40',4000);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z45',4500);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z50',5000);
INSERT INTO zonas(nombre, precio_envio) VALUES ('Z70',7000);

INSERT INTO clientes (id, direccion,empresa, nombre) VALUES(3103567898,'Dirección','Empresa','Un usuario');

INSERT INTO facturas (creado,encargado,state,clientef_id, observacion) VALUES(NOW(), 3, 1,3103567898, '');
INSERT INTO facturas_items (cantidad, producto_id,factura_id) VALUES(1,1,1);

INSERT INTO facturas (creado,encargado,state,clientef_id, observacion) VALUES(NOW(), 2, 2,3103567898, '');
INSERT INTO facturas_items (cantidad, producto_id,factura_id) VALUES(1,1,2);

INSERT INTO facturas (creado,encargado,state,clientef_id, observacion) VALUES(NOW(), 2, 3,3103567898, '');
INSERT INTO facturas_items (cantidad, producto_id,factura_id) VALUES(1,1,3);

INSERT INTO facturas (creado,encargado,state,clientef_id, observacion) VALUES(NOW(), 3, 4,3103567898, '');
INSERT INTO facturas_items (cantidad, producto_id,factura_id) VALUES(1,1,4);

INSERT INTO facturas (creado,encargado,state,clientef_id, observacion) VALUES(NOW(), 2, 5,3103567898, '');
INSERT INTO facturas_items (cantidad, producto_id,factura_id) VALUES(1,1,5);

INSERT INTO facturas (creado,encargado,state,clientef_id, observacion) VALUES(NOW(), 1, 6,3103567898, '');
INSERT INTO facturas_items (cantidad, producto_id,factura_id) VALUES(1,1,6);

INSERT INTO facturas (creado,encargado,state,clientef_id, observacion) VALUES(NOW(), 3, 7,3103567898, '');
INSERT INTO facturas_items (cantidad, producto_id,factura_id) VALUES(1,1,7);





