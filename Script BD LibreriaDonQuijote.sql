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


CREATE TABLE users
(
    idUser serial NOT NULL PRIMARY KEY,
    username varchar(50) unique not null,
    password varchar(50) not null,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    cedula character varying(15) UNIQUE NOT NULL,
    fechaNacimiento date NOT NULL,
    salario double precision NOT NULL,
    sexo boolean NOT NULL,
    estadoBorrado boolean NOT NULL,
    enabled boolean not null 
);

create table authorities (
    idAuthority serial not null primary key,
    username varchar(50) not null,
    authority varchar(50) not null,
    estadoBorrado boolean not null,
    constraint fk_authorities_users foreign key(username) references users(username) 
) ;

create unique index ix_auth_username on authorities(username,authority);


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
      REFERENCES users(idUser) MATCH SIMPLE
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