drop database if exists cine;
create database cine;
use cine;

-- drop table salas;
create table salas
(
    numero int,
    tipo enum('DOSD','TRESD','CUATROD'),
    capacidad int not null,
    asientosDisponibles int not null,
    transmitiendo boolean not null,
    primary key(numero)
);

-- drop table clientes;
create table clientes
(
    id int auto_increment,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    edad int not null,
    primary key(id)
);

-- drop table peliculas
create table peliculas
(
    codigo int auto_increment,
    titulo varchar(100) not null,
    duracion int not null,
    genero varchar(30) not null,
    esMas18 boolean not null,
    primary key(codigo)
);

-- drop table detalles
create table detalles
(
    codDetalle int auto_increment,
    codPelicula int not null,
    nroSala int not null,
    fecha DateTime not null,
    primary key(codDetalle)
);

-- drop table cartelera;
create table carteleras
(
    codCartelera int not null,
    codDetalle int not null,
    primary key(codCartelera)
);

-- drop table entradas;
create table entradas
(
    nroEntrada int not null auto_increment,
    idCliente int not null,
    datosPeli int not null,
    primary key(nroEntrada)
);

alter table detalles
add constraint FK_detalles_peliculas
foreign key(codPelicula)
references peliculas(codigo);

alter table detalles
add constraint FK_detalles_salas
foreign key(nroSala)
references salas(numero);

alter table carteleras
add constraint FK_carteleras_detalles
foreign key(codCartelera)
references detalles(codDetalle);

alter table entradas
add constraint FK_entradas_clientes
foreign key(idCliente)
references clientes(id);

alter table entradas
add constraint FK_entradas_detalles
foreign key(datosPeli)
references detalles(codDetalle);