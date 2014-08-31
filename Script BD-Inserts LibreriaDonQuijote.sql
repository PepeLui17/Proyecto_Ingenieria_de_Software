
CREATE TABLE Libro
(
  idLibro serial NOT NULL,
  nombre character varying(50) NOT NULL,
  autor character varying(50) NOT NULL,
  codigoISBN character varying(30) NOT NULL,
  precioUnitario double precision NOT NULL,
  pvp double precision NOT NULL,
  categoria character varying(20) NOT NULL,
  editorial character varying(30) NOT NULL,
  edicion integer NOT NULL,
  anioPublicacion integer NOT NULL,
  stock integer NOT NULL,
  descripcion text NOT NULL,
  estadoBorrado boolean NOT NULL,
  CONSTRAINT libro_pkey PRIMARY KEY (idLibro),
  CONSTRAINT libro_codigoISBN_key UNIQUE (codigoISBN)
);



CREATE TABLE Cliente
(
  idCliente serial NOT NULL,
  nombre character varying(30) NOT NULL,
  apellido character varying(30) NOT NULL,
  cedula_ruc character varying(15) NOT NULL,
  ciudad character varying(30) NOT NULL,
  direccion character varying(50) NOT NULL,
  telefono character varying(20) NOT NULL,
  estadoBorrado boolean NOT NULL,
  CONSTRAINT cliente_pkey PRIMARY KEY (idCliente),
  CONSTRAINT cliente_cedula_ruc_key UNIQUE (cedula_ruc)
);

create table Rol (
    idRol serial not null primary key,
    nombreRol varchar(50) not null,
    estadoBorrado boolean not null
) ;

CREATE TABLE Usuario
(
    idUsuario serial NOT NULL PRIMARY KEY,
	idRol serial NOT NULL,
    username varchar(50) unique not null,
    password varchar(50) not null,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    cedula character varying(15) UNIQUE NOT NULL,
    fechaNacimiento date NOT NULL,
    salario double precision NOT NULL,
    sexo boolean NOT NULL,
    estadoBorrado boolean NOT NULL,
    enabled boolean not null,
	CONSTRAINT usuario_idRol_fkey FOREIGN KEY (idRol)
      REFERENCES rol(idRol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE Factura
(
  idFactura serial NOT NULL PRIMARY KEY,
  idUsuario serial NOT NULL,
  idCliente serial NOT NULL,
  numeroFactura character varying(64) UNIQUE NOT NULL,
  iva double precision NOT NULL,
  fechaCompra date NOT NULL,
  estadoBorrado boolean NOT NULL,
  CONSTRAINT factura_idCliente_fkey FOREIGN KEY (idCliente)
      REFERENCES cliente(idCliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT factura_idUsuario_fkey FOREIGN KEY (idUsuario)
      REFERENCES usuario(idUsuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE detalle_factura
(
  idDetalle_Factura serial NOT NULL PRIMARY KEY,
  idFactura serial NOT NULL,
  idLibro serial NOT NULL,
  cantidad integer NOT NULL,
  estadoBorrado boolean NOT NULL,
  CONSTRAINT detalle_factura_idFactura_fkey FOREIGN KEY (idFactura)
      REFERENCES factura (idFactura) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT detalle_factura_idLibro_fkey FOREIGN KEY (idLibro)
      REFERENCES libro (idLibro) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--Insertar datos--
--Roles--
insert into rol (nombrerol, estadoBorrado)
values ('administrador',False);
insert into rol (nombrerol, estadoBorrado)
values ('vendedor',False);
--Usuario--
insert into usuario (idrol, username, password, nombre, apellido, cedula, fechanacimiento, salario, sexo, estadoborrado, enabled)
values (1, 'Administrador', 'ACM1234', 'Quijote', 'ACM', '0000000000', '2014-08-29', 0.00, False, False, True); --date se inserta asi año-mes-dia y double precision asi n1.n2
insert into usuario (idrol, username, password, nombre, apellido, cedula, fechanacimiento, salario, sexo, estadoborrado, enabled)
values (2, 'Vendedor', '12345', 'Quijote', 'ACM', '9999999999', '2014-08-29', 0.00, False, False, True); --date se inserta asi año-mes-dia y double precision asi n1.n2
insert into usuario (idrol, username, password, nombre, apellido, cedula, fechanacimiento, salario, sexo, estadoborrado, enabled)
values (2, 'jlmonar', 'pepemonar', 'Jose', 'Monar', '1207104116', '1991-08-31', 0.00, False, False, True);

--Libro--
insert into libro (nombre, autor, codigoisbn, preciounitario, pvp, categoria, editorial, edicion, aniopublicacion, stock, descripcion, estadoborrado)
values ('Don Quijote de la Mancha', 'Miguel de Cervantes Saavedra', '9788499892429', 17.20, 23.50, 'Literatura', 'DEBOLSILLO', 1, 1605, 30, 'Don Quijote de la Mancha es una novela escrita por el español Miguel de Cervantes Saavedra. Es una de las obras más destacadas de la literatura española y la literatura universal, y una de las más traducidas.', False);
--Cliente--
insert into cliente (nombre, apellido, cedula_ruc, ciudad, direccion, telefono, estadoborrado)
values ('Marlon', 'Calderón', '0925317638', 'Guayaquil', 'Sauces 8 mz454', '0984287897', False);
--Factura--
insert into factura (idusuario, idcliente, numerofactura, iva, fechacompra, estadoborrado)
values (1, 1, '000000001', 0.0, '2014-08-29', True);
--DetalleFactura--
insert into detalle_factura (idfactura, idlibro, cantidad, estadoborrado)
values (1, 1, 1, False);


