drop database if exists cine;
create database cine;
use cine;

-- drop table salas;
create table salas
(
    numero int,
    tipo enum('DOSD','TRESD','CUATROD'),
    cantAsientos int not null,
    asientosDisponibles int not null,
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
    duracion time not null,
    genero varchar(30) not null,
    primary key(codigo)
);

-- drop table cartelera;
create table cartelera
(
    codEstreno int auto_increment,
    fechaDisponible datetime not null,
    sala int not null,
    codPelicula int not null,
    primary key(codEstreno)
);

-- drop table entradas;
create table entradas
(
    nroEntrada int auto_increment,
    precio double not null,
    idCliente int not null,
    codCartelera int not null,
    primary key(nroEntrada)
);

alter table cartelera
add constraint FK_cartelera_peliculas
foreign key(codPelicula)
references peliculas(codigo);

alter table cartelera
add constraint FK_cartelera_salas
foreign key(sala)
references salas(numero);

alter table entradas
add constraint FK_entradas_clientes
foreign key(idCliente)
references clientes(id);

alter table entradas
add constraint FK_entradas_cartelera
foreign key(codCartelera)
references cartelera(codEstreno);